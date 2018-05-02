package com.edge.demo.controller;

import com.edge.demo.DemoApplication;
import com.edge.demo.model.PriceAsset;
import com.edge.demo.model.UserQuant;
import latesco.core.connector.FrontendConnector;
import latesco.core.data.Asset;
import latesco.core.data.PriceRecord;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/port")
public class PortfolioController {

  private FrontendConnector connector = DemoApplication.connector;

  private List<Asset> asset = new ArrayList<>();

  private void loadAsset() {
    if (asset.size() == 0) {
      asset = connector.getLatesco().getAssets();
    }
  }

  @RequestMapping(value = "/owned", method = RequestMethod.GET)
  public List<UserQuant> list() {
    loadAsset();
    List<PriceAsset> pa = new ArrayList<>();
    List<UserQuant> userQuant = new ArrayList<>();
    List<Integer> assets = connector.getAllUsersAssets(1);

    for (Integer integer : assets) {
      PriceRecord price = connector.getCurrentPrice(integer, 14);
      Asset tempAsset = asset.stream().filter(it -> it.getUid() == integer).findFirst().get();
      pa.add(new PriceAsset(tempAsset, price));
    }

    for (PriceAsset pas : pa) {
      BigDecimal quant = connector.getUserQuant(1, pas.assetUid);
      userQuant.add(new UserQuant(pas, quant));
    }

    return userQuant;
  }

  @RequestMapping(value = "/total", method = RequestMethod.GET)
  public BigDecimal totalWorth() {
    BigDecimal total = new BigDecimal(0.0);
    List<Integer> assets = connector.getAllUsersAssets(1);

    for (Integer asset : assets) {
      PriceRecord price = connector.getCurrentPrice(asset, 14);
      BigDecimal quant = connector.getUserQuant(1, asset);
      total = total.add(quant.multiply(price.getPrice()));
    }

    return total.setScale(2, RoundingMode.DOWN);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<UserQuant> allList() {
    List<Asset> asset = connector.getLatesco().getAssets();
    List<UserQuant> userQuant = new ArrayList<>();

    for (Asset asset1 : asset) {
      BigDecimal quant;
      try {
        quant = connector.getUserQuant(1, asset1.getUid());
      } catch (Exception e) {
        quant = new BigDecimal(0);
      }

      PriceRecord price = connector.getCurrentPrice(asset1.getUid(), 14);
      PriceAsset pa = new PriceAsset(asset1, price);

      userQuant.add(new UserQuant(pa, quant));
    }

    return userQuant;
  }

  @RequestMapping(value = "/modquant", method = RequestMethod.POST)
  public String addEntry(@RequestBody UserQuant quant) {
    connector.setUserQuant(1, quant.uid, quant.quant);
    return "works";
  }

  @RequestMapping(value = "wealth_hist", method = RequestMethod.GET)
  public List<WealthEntry> getWealth() {
    List<WealthEntry> entries = new ArrayList<>();
    WealthEntry entry = new WealthEntry();

    // This SQL statements is a monster, but time is short.
    String sql =
        "SELECT  date(u.ins_time), price, quant_total " +
            "FROM (" +
            "SELECT asset_uid, MAX(ins_time) as lts " +
            "FROM users " +
            "WHERE user_uid = 1 " +
            "GROUP BY date(ins_time), asset_uid " +
            "ORDER BY lts DESC" +
            ") as q " +
            "JOIN users as u " +
            "ON q.lts = u.ins_time AND  q.asset_uid = u.asset_uid " +
            "JOIN (" +
            "SELECT date(lts), p.asset_uid, p.price " +
            "FROM (" +
            "SELECT MAX(ret_time) as lts, asset_uid " +
            "FROM price " +
            "WHERE api_uid = 14 " +
            "GROUP BY date(ret_time), asset_uid " +
            "ORDER BY lts DESC" +
            ") as q " +
            "JOIN price as p " +
            "ON q.lts = p.ret_time AND q.asset_uid = p.asset_uid" +
            ") as prices " +
            "ON date(u.ins_time) = prices.date AND prices.asset_uid = u.asset_uid;";

    try {
      PreparedStatement statement = DemoApplication.conn.prepareStatement(sql);
      boolean hasResult = statement.execute();

      if (hasResult) {
        ResultSet rs = statement.getResultSet();
        Date dateConst = null;
        BigDecimal sum = new BigDecimal(0.0);

        while (rs.next()) {
          Date date = rs.getDate("date");
          BigDecimal price = rs.getBigDecimal("price");
          BigDecimal quant = rs.getBigDecimal("quant_total");

          if (dateConst == null) {
            dateConst = date;
            entry.labels.add(0, date.toString());
          }

          if (!dateConst.toString().equals(date.toString())) {
            entry.data.add(0, sum);
            sum = price.multiply(quant);
            dateConst = date;
            entry.labels.add(0, date.toString());
          } else {
            sum = sum.add(price.multiply(quant));
          }
        }

        entry.data.add(0, sum);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    entries.add(entry);

    return entries;
  }
}

class WealthEntry {
  public List<BigDecimal> data;
  public List<String> labels;
  public String label = "Wealth";
  public String borderColor = "rgba(0, 123, 255, 0.5)";
  public String backgroundColor = "rgba(0, 123, 255, 0.15)";

  public WealthEntry() {
    data = new ArrayList<>();
    labels = new ArrayList<>();
  }
}
