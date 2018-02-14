package com.edge.demo.controller;

import com.edge.demo.model.Currency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyStub {
	private static Map<Long, Currency> wrecks = new HashMap<Long, Currency>();
	private static Long idIndex = 3L;

	//populate initial wrecks
	static {
		Currency a = new Currency(1L, "U869", "A very deep German UBoat", "FAIR", 200.0, 44.12, 138.44, 1994);
		wrecks.put(1L, a);
		Currency b = new Currency(2L, "Thistlegorm", "British merchant boat in the Red Sea", "GOOD", 80.0, 44.12, 138.44, 1994);
		wrecks.put(2L, b);
		Currency c = new Currency(3L, "S.S. Yongala", "A luxury passenger ship wrecked on the great barrier reef", "FAIR", 50.0, 44.12, 138.44, 1994);
		wrecks.put(3L, c);
	}

	public static List<Currency> list() {
		return new ArrayList<Currency>(wrecks.values());
	}

	public static Currency create(Currency wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		wrecks.put(idIndex, wreck);
		return wreck;
	}

	public static Currency get(Long id) {
		return wrecks.get(id);
	}

	public static Currency update(Long id, Currency wreck) {
		wrecks.put(id, wreck);
		return wreck;
	}

	public static Currency delete(Long id) {
		return wrecks.remove(id);
	}
}
