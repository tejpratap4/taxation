package com.sample.taxation.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.sample.taxation.domain.Product;
import com.sample.taxation.domain.TaxType;

/**
 * GeneralTaxEngine will apply the general tax on given product value.
 *
 */
@Service
public class GeneralTaxEngine implements TaxEngine {

	public static final BigDecimal ROUND_TO = new BigDecimal("0.05");
	public static final BigDecimal TAX_RATE = new BigDecimal(".175");

	/**
	 * Calculate tax.
	 *
	 * @param Product
	 *            provide the detail of type of tax that need to apply.
	 * @param Amount
	 *            for we need to calculate the tax.
	 */
	@Override
	public BigDecimal calculate(Product product, BigDecimal actualAmount) {

		if (!product.getApplicableTaxes().contains(TaxType.GENERAL)) {
			return BigDecimal.ZERO;
		}
		return percentage(actualAmount, TAX_RATE);
	}

	/**
	 * Return the percentage of passed value.
	 * 
	 */
	private BigDecimal percentage(BigDecimal base, BigDecimal percentage) {
		return round(base.multiply(percentage));
	}

	/**
	 * Round of the passed value.
	 * 
	 */
	private BigDecimal round(BigDecimal value) {
		BigDecimal divided = value.divide(ROUND_TO, 0, BigDecimal.ROUND_UP);
		return divided.multiply(ROUND_TO);
	}

}
