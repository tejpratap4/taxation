package com.sample.taxation.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.taxation.domain.LineItem;
import com.sample.taxation.payload.Item;
import com.sample.taxation.payload.TaxRequest;
import com.sample.taxation.payload.TaxResponse;
import com.sample.taxation.persistence.MapProductRepository;

/**
 * TaxationService will call tax calculator to apply the tax and perform the
 * total for sales taxes and purchase items totals.
 *
 */
@Service
public class TaxationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TaxationService.class);
	private final TaxCalculateService taxCalculateService;
	private final MapProductRepository productRepository;
	private List<LineItem> items;

	@Autowired
	public TaxationService(TaxCalculateService taxCalculateService, MapProductRepository productRepository) {
		this.taxCalculateService = taxCalculateService;
		this.productRepository = productRepository;
	}

	private void addItems(List<Item> requestitems) {
		this.items = new ArrayList<>();
		for (Item item : requestitems) {
			BigDecimal tax = taxCalculateService.calculateTax(item.getItemName().toLowerCase(), item.getChargeAmount());
			LineItem lineItem = new LineItem(item.getItemName().toLowerCase(), item.getChargeAmount(), tax,
					item.getQuantity());
			items.add(lineItem);
		}
	}

	/**
	 * Get the purchase list and calculate tax.
	 * 
	 * @param TaxRequest
	 *            purchase items.
	 * @return TaxResponse purchase items details with tax related detail.
	 */
	public TaxResponse calculateTax(final TaxRequest taxationRequest) {
		LOGGER.info(" Enter calculateTax");
		TaxResponse taxResponse = new TaxResponse();
		List<Item> requestShoppingListItems = taxationRequest.getPurchaseItems();
		addItems(requestShoppingListItems);
		List<Item> resShoppingListItems = new ArrayList<>();
		for (LineItem lineItem : this.items) {
			Item it = new Item();
			it.setQuantity(lineItem.getQuantity());
			it.setItemName(lineItem.getName());
			it.setChargeAmount(lineItem.getNetPrice());
			resShoppingListItems.add(it);
		}
		taxResponse.setTaxImpacts(resShoppingListItems);
		taxResponse.setSalesTax(getSalesTax());
		taxResponse.setTotalAmount(getTotalPrice());
		LOGGER.info(" Output : \n {}", toString());
		LOGGER.info(" Exit calculateTax");
		return taxResponse;
	}

	/**
	 * Calculate the total price.
	 *
	 */
	private BigDecimal getTotalPrice() {
		return items.stream().map(LineItem::getNetPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	/**
	 * Calculate the total sales tax applied for purchase items.
	 *
	 */
	private BigDecimal getSalesTax() {
		return items.stream().map(LineItem::getTax).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	/**
	 * Populate the product and tax type mapping master data.
	 *
	 */
	public void populate() {
		productRepository.existingProduct();
	}

	@Override
	public String toString() {
		String formattedItems = items.toString().replace(",", "").replace("[", "").replace("]", "").trim();
		return formattedItems + "\nSales Taxes: " + getSalesTax() + "\nTotal: " + getTotalPrice() + "\n";
	}	
}
