package com.edge.demo.controller;

import com.edge.demo.model.Currency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyStub {
	private static Map<Long, Currency> coins = new HashMap<Long, Currency>();
	private static Long idIndex = 3L;

	//populate initial coins
	static {
		Currency a = new Currency(1L, "Bitcoin", "BTC", "FAIR", 9312.69, 138.44, 1994);
		coins.put(1L, a);
		Currency b = new Currency(2L, "Ethereum", "ETH", "GOOD", 5.0, 138.44, 1994);
		coins.put(2L, b);
		Currency c = new Currency(3L, "Ripple", "XRP", "FAIR", 1.08, 138.44, 1994);
		coins.put(3L, c);
	}

	public static List<Currency> list() {
		return new ArrayList<Currency>(coins.values());
	}

	public static Currency create(Currency coin) {
		idIndex += idIndex;
		coin.setId(idIndex);
		coins.put(idIndex, coin);
		return coin;
	}

	public static Currency get(Long id) {
		return coins.get(id);
	}

	public static Currency update(Long id, Currency coin) {
		coins.put(id, coin);
		return coin;
	}

	public static Currency delete(Long id) {
		return coins.remove(id);
	}
}
