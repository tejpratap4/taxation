package com.sample.taxation.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.sample.taxation.domain.Product;
import com.sample.taxation.domain.TaxType;

/**
 * EntertainmentTaxEngine will apply the entertainment tax.
 *
 */
@Service
public class EntertainmentTaxEngine implements TaxEngine {

	public static final BigDecimal TAX = new BigDecimal("1.25");

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
		if (!product.getApplicableTaxes().contains(TaxType.ENTERTENMENT)) {
			return BigDecimal.ZERO;
		}
		return TAX;
	}

}
