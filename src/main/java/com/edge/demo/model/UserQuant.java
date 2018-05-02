package com.edge.demo.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UserQuant {
  public String name;
  public String symbol;
  public BigDecimal price;
  public BigDecimal totalMoney;
  public BigDecimal quant;
  public int uid;

  public UserQuant() {}

  public UserQuant(PriceAsset asset, BigDecimal quant) {
    this.name  = asset.name;
    this.symbol = asset.symbol;
    this.price = asset.price.setScale(2, RoundingMode.DOWN);
    this.quant = quant.setScale(8, RoundingMode.DOWN);
    this.uid = asset.assetUid;

    totalMoney = asset.price.multiply(quant).setScale(2, RoundingMode.DOWN);
  }
}
