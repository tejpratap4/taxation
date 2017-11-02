package com.sample.taxation.service

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import com.sample.taxation.domain.Product
import com.sample.taxation.domain.TaxType

class EntertenmentTaxEngineSpec extends Specification {
	@Shared product1 = new Product("book", TaxType.ENTERTENMENT)
	@Shared product2 = new Product("book", TaxType.GENERAL)
	
	@Unroll("EntertainmentTaxEngine should calculate tax on \"#product\" and \"#amount\" and return \"#outputTax\".")
	def "test entertenment tax calculator."() {
		given:
			def entertenmentTaxImpl = new EntertainmentTaxEngine();
		when:
			BigDecimal tax = entertenmentTaxImpl.calculate(product, amount)
		then:
			println tax
			tax == outputTax    
        where:
        	product << [product1,product2]
			amount << [200.45, 100]
			outputTax << [1.25, 0]
		
		}
}
