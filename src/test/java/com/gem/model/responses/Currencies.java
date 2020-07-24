package com.gem.model.responses;

public class Currencies {
	
	public Currencies() {
		
	}
	private String symbol;

	private String code;

	private String name;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Currencies [symbol = " + symbol + ", code = " + code + ", name = " + name + "]";
	}
}