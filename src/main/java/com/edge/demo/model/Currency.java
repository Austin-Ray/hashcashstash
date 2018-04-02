package com.edge.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Created by kelseyedge on 2/14/18.
 * This class connects the Currency model as a Spring JPA entity (which connects it to the database table)
 */

@Entity
public class Currency {
	//tells JPA that id is the auto-generated primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	String symbol;
	String rank;
	Double sodPrice;
	Double currentPrice;
	String date_time;

	public Currency() { }

	public Currency(String name, String symbol, String rank, Double sodPrice, Double currentPrice, String dateTime) {
		this.name = name;
		this.symbol = symbol;
		this.rank = rank;
		this.sodPrice = sodPrice;
		this.currentPrice = currentPrice;
		this.date_time = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Double getPriceChange() {
		return currentPrice-sodPrice;
	}

	public Double getSodPrice() {
		return sodPrice;
	}

	public void setSodPrice(Double sodPrice) {
		this.sodPrice = sodPrice;
	}

	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
}
