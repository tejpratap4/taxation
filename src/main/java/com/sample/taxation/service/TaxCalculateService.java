package com.sample.taxation.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.taxation.domain.Product;
import com.sample.taxation.exception.ErrorEnum;
import com.sample.taxation.exception.NotFoundInMapException;
import com.sample.taxation.persistence.MapProductRepository;

/**
 * TaxCalculateService call the tax engines to apply the tax on given product.
 *
 */
@Service
public class TaxCalculateService {

	private MapProductRepository productRepository;
	private List<TaxEngine> taxes;

	@Autowired
	public TaxCalculateService(MapProductRepository productRepository, TaxEngine... taxes) {
		this.productRepository = productRepository;
		this.taxes = Arrays.asList(taxes);
	}

	/**
	 * calculateTax find the product based on product name and call the
	 * taxEngine for calculating the tax.
	 * 
	 * @param productName name of the product.
	 * @param actualAmount on we need to apply the tax.
	 * @return return the sum of taxes those are applicable for that product.
	 */
	public BigDecimal calculateTax(String productName, BigDecimal actualAmount) {
		Product product = getProductByName(productName);
		if (product == null) {
			throw new NotFoundInMapException(ErrorEnum.PRODUCT_NOT_FOUND_IN_MAP);
		}
		return taxes.stream().map(tax -> tax.calculate(product, actualAmount)).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public Product getProductByName(String name) {
		return productRepository.findByProductName(name);
	}

}
