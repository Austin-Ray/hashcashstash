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
