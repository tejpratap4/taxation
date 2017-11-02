package com.sample.taxation.domain

import spock.lang.Specification
import spock.lang.Unroll

class LineItemSpec  extends Specification {

	@Unroll("LineItem getters should return \"#name\", \"#gross\", \"#tax\" and \"#quantity\" ")
	def "test greeting accessors"() {	
	
		given:
		def lineItem = new LineItem("book",100.24, 17.6, 1)

		when:
		lineItem != null
		
		then:
		lineItem.getName() == name
		lineItem.getGross() == gross
		lineItem.getQuantity() == quantity 
		lineItem.getTax() == tax
		

		where:
		name       |  quantity | gross  | tax
		"book"     |  1        | 100.24 | 17.6
	}

}
