package com.edge.demo.model;

import latesco.core.data.Asset;
import latesco.core.data.PriceRecord;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class PriceAsset {

  public int assetUid;
  public String name;
  public String symbol;
  public BigDecimal price;
  public String date;

  public PriceAsset(Asset asset, PriceRecord price) {
    assetUid  = asset.getUid();
    name      = asset.getName();
    symbol    = asset.getSymbol();

    this.price = price.getPrice().setScale(2, RoundingMode.DOWN);
    this.date  = new Date(price.getTimestamp().getTime()).toString();
  }
}
