package com.edge.demo.controller;

import com.edge.demo.DemoApplication;
import com.edge.demo.model.PriceAsset;
import latesco.core.connector.FrontendConnector;
import latesco.core.data.Asset;
import latesco.core.data.PriceRecord;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/currency")
public class CurrencyController {

  private FrontendConnector connector = DemoApplication.connector;
  private Connection conn = DemoApplication.conn;

  private List<Asset> asset = new ArrayList<>();

  private void loadAsset() {
    if (asset.size() == 0) {
      asset = connector.getLatesco().getAssets();
    }
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<PriceAsset> list() {
    loadAsset();
    List<PriceAsset> pa = new ArrayList<>();

    for (Asset asset1 : asset) {
      PriceRecord price = connector.getCurrentPrice(asset1.getUid(), 14);
      pa.add(new PriceAsset(asset1, price));
    }

    return pa;
  }

  @RequestMapping(value = "/price_history", method = RequestMethod.GET)
  public List<DataSetEntry> priceHistory(@Param("uid") int uid) {
    loadAsset();

    // Pretty nasty SQL statement.
    String sql = "SELECT ret_time, asset_uid, price FROM price WHERE asset_uid = ?;";
//        "SELECT lts, p.asset_uid, p.price " +
//        "FROM (" +
//            "SELECT MAX(ret_time) as lts, asset_uid " +
//            "FROM price WHERE api_uid = 14 " +
//            "GROUP BY date(ret_time), asset_uid " +
//            "ORDER BY lts DESC" +
//        ") as q " +
//        "JOIN price as p " +
//        "ON q.lts = p.ret_time AND q.asset_uid = p.asset_uid;";
    List<DataSetEntry> data = new ArrayList<>();

    PreparedStatement statement;
    try {
      statement = conn.prepareStatement(sql);
      statement.setInt(1, uid);
      boolean hasResults = statement.execute();

      if (hasResults) {
        ResultSet rs = statement.getResultSet();

        while (rs.next()) {
          Timestamp time = rs.getTimestamp("ret_time");
          int aid = rs.getInt("asset_uid");
          BigDecimal price = rs.getBigDecimal("price");

          if (data.stream().anyMatch(it -> it.asset_id == aid)) {
            DataSetEntry ds = data.stream()
                .filter(it -> it.asset_id == aid)
                .findFirst()
                .get();
            ds.data.add(price);
            ds.labels.add(time.toLocalDateTime().toLocalDate().toString());
          } else {
            String name = asset.stream()
                .filter(it -> it.getUid() == aid)
                .findFirst()
                .get()
                .getName();

            data.add(new DataSetEntry(name, aid, price, time.toLocalDateTime().toLocalDate().toString()));
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return data;
  }
}

class DataSetEntry {
  public List<String> labels;
  public List<BigDecimal> data;
  public String label;
  public int asset_id;
  public boolean fill = false;
  public Color color;
  public int pointRadius = 0;
  public String borderColor = "rgba(0, 123, 255, 0.5)";
  public String backgroundColor = "rgba(0, 123, 255, 0.15)";

  // Default constructor for Spring.
  public DataSetEntry() { }

  public DataSetEntry(String name, int id, BigDecimal price, String time) {
    this.data = new ArrayList<>();
    data.add(price);
    this.labels = new ArrayList<>();
    labels.add(time);
    this.label = name;
    this.asset_id = id;
  }
}



