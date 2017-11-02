package com.sample.taxation.domain

import java.util.Arrays;

import org.codehaus.groovy.control.messages.Message

import spock.lang.Specification
import spock.lang.Unroll
import com.sample.taxation.domain.TaxType;

class ProductSpec  extends Specification {

	@Unroll("#name getters should return \"#name\" and \"#applicableTaxes\" ")
	def "test greeting accessors"() {

		given:
		def product = new Product(name,applicableTaxes,applicableTaxes1)		

		when:
		product != null
		
		then:
		product.getName() == name
		product.getApplicableTaxes() == Arrays.asList(applicableTaxes,applicableTaxes1)

		where:
		name       |  applicableTaxes |  applicableTaxes1
		"book"     |  TaxType.GENERAL | null
		"cd"       |  TaxType.GENERAL | TaxType.ENTERTENMENT
	}	

}
