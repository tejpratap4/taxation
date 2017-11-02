package com.sample.taxation.service;

import java.math.BigDecimal;

import com.sample.taxation.domain.Product;

public interface TaxEngine {
	BigDecimal calculate(Product product, BigDecimal actualAmount);
}
