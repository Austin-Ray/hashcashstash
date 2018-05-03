/*
 * This file is part of HashCash Stash.
 *
 * HashCash Stash is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * HashCash Stash is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with HashCash Stash.  If not, see <http://www.gnu.org/licenses/>.
 */

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
