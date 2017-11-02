package com.sample.taxation.domain;

import java.math.BigDecimal;
import java.util.StringJoiner;

/**
 * Purchase product line item detail with tax information.
 */
public class LineItem {

	private final String name;
	private final Integer quantity;
	private final BigDecimal gross;
	private final BigDecimal tax;

	public LineItem(String name, BigDecimal gross, BigDecimal tax, Integer quantity) {
		this.name = name;
		this.quantity = quantity;
		this.gross = gross;
		this.tax = tax;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public BigDecimal getNetPrice() {
		return getGross().add(getTax());
	}

	public BigDecimal getGross() {
		return gross;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(quantity.toString());
		joiner.add(name);
		joiner.add(":");
		joiner.add(getNetPrice().toString());
		return "\n" + joiner.toString();
	}
}