package com.sample.taxation.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sample.taxation.domain.Product;
import com.sample.taxation.domain.TaxType;

/**
 * MapProductRepository persist the product and tax type mapping. Support add
 * and search product functionality.
 *
 */

@Service
public class MapProductRepository {

	private final Map<String, Product> products = new HashMap<>();

	/**
	 * Find product by product name.
	 * 
	 * @param name
	 *            of the product.
	 * @return Product detail object.
	 */
	public Product findByProductName(String name) {
		return products.get(name.toLowerCase());
	}

	/**
	 * Add product.
	 * @param Product
	 *            object.
	 */
	public void add(Product product) {
		if (!products.containsKey(product.getName().toLowerCase())) {
			products.put(product.getName().toLowerCase(), product);
		}
	}

	/**
	 * Store product in map.
	 */
	public void existingProduct() {
		Product product = new Product("box of tooth ache pills");
		add(product);
		product = new Product("book", TaxType.GENERAL);
		add(product);
		product = new Product("music cd", TaxType.GENERAL, TaxType.ENTERTENMENT);
		add(product);
		product = new Product("chocolate snack", TaxType.GENERAL);
		add(product);
		product = new Product("bottle of wine", TaxType.GENERAL);
		add(product);
		product = new Product("box of pins", TaxType.GENERAL);
		add(product);
	}
}
