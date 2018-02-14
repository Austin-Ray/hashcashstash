package com.edge.demo.model;

public class Currency {
	Long id;
	String name;
	String description;
	String condition;
	double priceChange;
	Double sodPrice;
	Double eodPrice;
	Integer yearDiscovered;

	public Currency() { }

	public Currency(Long id, String name, String description, String condition, Double priceChange, Double sodPrice, Double eodPrice, Integer yearDiscovered) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.condition = condition;
		this.priceChange = eodPrice - sodPrice;
		this.sodPrice = sodPrice;
		this.eodPrice = eodPrice;
		this.yearDiscovered = yearDiscovered;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Double getPriceChange() {
		return priceChange;
	}

	public void setPriceChange(Integer priceChange) {
		this.priceChange = priceChange;
	}

	public Double getSodPrice() {
		return sodPrice;
	}

	public void setSodPrice(Double sodPrice) {
		this.sodPrice = sodPrice;
	}

	public Double getEodPrice() {
		return eodPrice;
	}

	public void setEodPrice(Double eodPrice) {
		this.eodPrice = eodPrice;
	}

	public Integer getYearDiscovered() {
		return yearDiscovered;
	}

	public void setYearDiscovered(Integer yearDiscovered) {
		this.yearDiscovered = yearDiscovered;
	}
}
