//package com.edge.demo.controller;
//
//import com.edge.demo.model.Currency;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CurrencyStub {
//	private static Map<Double, Currency> coins = new HashMap<Double, Currency>();
//	private static Double idIndex = 3.0;
//
//	//populate initial coins
//	static {
//		Currency a = new Currency(1.0, "Bitcoin", "BTC", "1", 9312.69, 138.44, "March 3");
//		coins.put(1.0, a);
//		Currency b = new Currency(2.0, "Ethereum", "ETH", "2", 5.0, 138.44, "March 3");
//		coins.put(2.0, b);
//		Currency c = new Currency(3.0, "Ripple", "XRP", "3", 1.08, 138.44, "March 3");
//		coins.put(3.0, c);
//	}
//
//	public static List<Currency> list() {
//		return new ArrayList<Currency>(coins.values());
//	}
//
//	public static Currency create(Currency coin) {
//		idIndex += idIndex;
//		coin.setId(idIndex);
//		coins.put(idIndex, coin);
//		return coin;
//	}
//
//	public static Currency get(Double id) {
//		return coins.get(id);
//	}
//
//	public static Currency update(Double id, Currency coin) {
//		coins.put(id, coin);
//		return coin;
//	}
//
//	public static Currency delete(Double id) {
//		return coins.remove(id);
//	}
//}
