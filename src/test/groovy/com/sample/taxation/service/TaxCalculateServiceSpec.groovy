package com.sample.taxation.service

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import com.sample.taxation.domain.Product
import com.sample.taxation.domain.TaxType
import com.sample.taxation.persistence.MapProductRepository

class TaxCalculateServiceSpec extends Specification {
	@Shared product1 = new Product("book", TaxType.GENERAL)
	@Shared product2 = new Product("music cd", TaxType.GENERAL, TaxType.ENTERTENMENT)
	
	def productRepository = new MapProductRepository()	
	def taxService1 =new GeneralTaxEngine()
	def taxService2 =new EntertainmentTaxEngine()
	
	def taxCalculateService = new TaxCalculateService (productRepository, taxService1, taxService2)
	
	/*
	 Verify the TaxCalculateService "getProductByName" method to get the product detail based on product name
	 */
	def "test TaxCalculateService getProductByName() method"() {
		given:
		productRepository.existingProduct();
		productRepository.findByProductName(_) >> product1

		when:
		def product = taxCalculateService.getProductByName(name)

		then:
		product != null
			
		where:
		name << ["book","music cd"]
		output << [product1,product2]
	}
	
	/*
	 Verify the TaxCalculateService "calculateTax" method to calculate the tax for product.
	 */
	@Unroll("TaxCalculateService.calculateTax should calculate tax on \"#name\" and \"#amount\" and return \"#output\".")
	def "test TaxCalculateService calculateTax() method"() {
		given:
		productRepository.existingProduct();
		productRepository.findByProductName(_) >> product

		when:
		BigDecimal taxAmount = taxCalculateService.calculateTax(name,amount)

		then:
		print taxAmount
		taxAmount == output
			
		where:
		name << ["book","music cd"]
		amount << [100, 100]
		output << [17.50,18.75]
		product << [product1,product2]
	}

}
