package com.sample.taxation.service

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import com.sample.taxation.domain.LineItem
import com.sample.taxation.payload.Item
import com.sample.taxation.payload.TaxRequest
import com.sample.taxation.payload.TaxResponse
import com.sample.taxation.persistence.MapProductRepository

class TaxationServiceSpec extends Specification  {
	// internal calculation line item
	@Shared lineItem1 = new LineItem("book", 100.00, 17.50, 1)
	@Shared lineItem2 = new LineItem("music cd", 100.00, 18.25, 1)
	// request object
	@Shared requestItem1 = new Item(itemName: "book", quantity: 1, chargeAmount: 29.49)
	@Shared requestItem2 = new Item(itemName: "music cd", quantity: 1, chargeAmount: 15.99)
	@Shared requestItem3 = new Item(itemName: "chocolate snack", quantity: 1, chargeAmount: 0.75)
	@Shared taxRequest1 = new TaxRequest(purchaseItems : [requestItem1,requestItem2,requestItem3])
	
	@Shared requestItem21 = new Item(itemName: "bottle of wine", quantity: 1, chargeAmount: 20.99)
	@Shared requestItem22 = new Item(itemName: "box of tooth ache pills", quantity: 1, chargeAmount: 4.15)
	@Shared requestItem23 = new Item(itemName: "box of pins", quantity: 1, chargeAmount: 11.25)
	@Shared requestItem24 = new Item(itemName: "music cd", quantity: 1, chargeAmount: 14.99)
	@Shared taxRequest2 = new TaxRequest(purchaseItems : [requestItem21,requestItem22,requestItem23,requestItem24])
	
	// response object line item
	@Shared resItem1 = new Item(itemName: "book", quantity: 1, chargeAmount: 34.69)
	@Shared resItem2 = new Item(itemName: "music cd", quantity: 1, chargeAmount: 20.04)
	@Shared resItem3 = new Item(itemName: "chocolate snack", quantity: 1, chargeAmount: 0.90)
	@Shared taxResponse = new TaxResponse(taxImpacts : [resItem1,resItem2, resItem3], salesTax : 9.40, totalAmount : 55.63)	
	
	@Shared resItem21 = new Item(itemName: "bottle of wine", quantity: 1, chargeAmount: 24.69)
	@Shared resItem22 = new Item(itemName: "box of tooth ache pills", quantity: 1, chargeAmount: 4.15)
	@Shared resItem23 = new Item(itemName: "box of pins", quantity: 1, chargeAmount: 13.25)
	@Shared resItem24 = new Item(itemName: "music cd", quantity: 1, chargeAmount: 18.89)
	@Shared taxResponse2 = new TaxResponse(taxImpacts : [resItem21,resItem22, resItem23, resItem24], salesTax : 9.60, totalAmount : 60.98)
	
		
	def productRepository = new MapProductRepository()
	def taxService1 =new GeneralTaxEngine()
	def taxService2 =new EntertainmentTaxEngine()
	
	def taxCalculateService = new TaxCalculateService (productRepository, taxService1, taxService2)
	def taxationService = new TaxationService (taxCalculateService, productRepository)

	/*
	 Verify the TaxationServiceSpec "calculateTax" calculate the tax on shopping list data
	 */
	@Unroll("TaxationServiceSpec calculateTax \"#input\"  and apply tax on purchase list and output with taxes \"#output\".")
	def "test TaxationServiceSpec calculateTax() method"() {
		given:
			taxationService.populate()
		when:
			TaxResponse response = taxationService.calculateTax(input)
		then:		    
			response == output			
		where:
		input << [taxRequest1,taxRequest2]
		output << [taxResponse,taxResponse2]
	}
	
}
