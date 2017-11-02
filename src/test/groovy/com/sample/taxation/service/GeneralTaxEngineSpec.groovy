package com.sample.taxation.service

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import com.sample.taxation.domain.Product
import com.sample.taxation.domain.TaxType

class GeneralTaxEngineSpec extends Specification {
	@Shared product1 = new Product("cd", TaxType.ENTERTENMENT)
	@Shared product2 = new Product("book", TaxType.GENERAL)
	@Shared product3 = new Product("pills", TaxType.PHARMA)
	
	@Unroll("GeneralTaxEngine should calculate tax on \"#product\" and \"#amount\" and return \"#outputTax\".")
	def "test general tax calculator."() {
		given:
			def generalTaxImpl = new GeneralTaxEngine();
		when:
			BigDecimal tax = generalTaxImpl.calculate(product, amount)
		then:
			println tax
			tax == outputTax
		where:
			product << [product1,product2, product3]
			amount << [200.45, 100, 0.75]
			outputTax << [0, 17.50, 0]		
		}
}
