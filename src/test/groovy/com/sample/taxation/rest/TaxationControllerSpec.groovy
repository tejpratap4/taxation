package com.sample.taxation.rest

import org.springframework.web.util.OpaqueUriComponents
import org.springframework.web.util.UriComponentsBuilder

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import com.sample.taxation.TaxationController

/**
 * Created by himanish on 10/12/16.
 * Unit Test for a TaxationController
 */
class TaxationControllerSpec extends Specification {

  @Shared tax1 = null; //new Taxation(id:'1', billingId:'1', billingProfile:'1', billingAmount:'1000', billingCurrency:'USD', taxAmount:'100', taxCurrency:'USD')
  @Shared tax2 = null; //new Taxation(id:'2', billingId:'2', billingProfile:'2', billingAmount:'2000', billingCurrency:'USD', taxAmount:'200', taxCurrency:'USD')

  def setupSpec() {
    // method called only once prior to running all testcases in this class
    println "TaxationController::Setup specification"
  }

  def cleanupSpec() {
    // method called only once after running all testcases in this class
    println "TaxationController::Clean up specification"
  }

  def setup() {
    // method called before each testcase method
    println "TaxationController::Setup"
  }

  def cleanup() {
    // method called after each testcase method
    println "TaxationController::Clean up"
  }

  /*
   Verify the TaxationController "list" method returns all values from the Repository
   
  def "test TaxationController list() method"() {

    // mock the values that are expected to be found in the repo
    def mockedTaxationRepository = Mock(TaxationRepository)
    mockedTaxationRepository.findAll() >> [tax1, tax2]

    given:
    def taxationController = new TaxationController(mockedTaxationRepository,null)


    when:
    def thelist= taxationController.list()

    then:
    thelist.getStatusCodeValue() == 200
    thelist.getBody().size() == 2
    thelist.getBody() == [tax1, tax2]
  }

  /*
   Verify the TaxationController "get" method returns all values from the Repository
   
  @Unroll("Expected TaxAmount for #id is #expectedTaxAmount")
  def "test TaxationController get() method"() {

    // mock the values that are expected to be found in the repo
    def mockedTaxationRepository = Mock(TaxationRepository)
    mockedTaxationRepository.findOne("1") >> tax1
    mockedTaxationRepository.findOne("2") >> tax2
    mockedTaxationRepository.findOne("3") >> null

    given:
    def taxationController = new TaxationController(mockedTaxationRepository,null)
    when:
    def result= taxationController.get(id)

    then:
    result.getStatusCodeValue() == statusCode
    (result.getBody() != null) == hasBody
    if (hasBody) {
      // must use assert if you are doing equivalence check inside an opened block
      result.getBody().getId() == id
      assert(result.getBody().getBillingId() == expectedBillingId)
      result.getBody().getBillingProfile() == expectedBillingProfile
      result.getBody().getBillingAmount() == expectedBillingAmount
      result.getBody().getBillingCurrency() == expectedBillingCurrency
      result.getBody().getTaxAmount() == expectedTaxAmount
      result.getBody().getTaxCurrency() == expectedTaxCurrency
    }

    where:
    id   |  expectedBillingId  |  expectedBillingProfile | expectedBillingAmount  | expectedBillingCurrency | expectedTaxAmount|  expectedTaxCurrency |   hasBody  |  statusCode
    "1"  |      "1"            |          "1"            |       "1000"           |         "USD"           |        "100"     |         "USD"        |     true   |     200
    "2"  |      "2"            |          "2"            |       "2000"           |         "USD"           |        "200"     |         "USD"        |     true   |     200
    "3"  |      null           |         null            |        null            |         null            |        null      |         null         |     false  |     404
  }

  /*
   Verify the TaxationController "store" method
   
  @Unroll("Validate store() method for TaxEngine #id")
  def "test TaxationController store() method"() {

    // mock the values that are expected to be found in the repo
    def mockedTaxationRepository = Mock(TaxationRepository)
    def mockedUriComponentsBuilder = Mock(UriComponentsBuilder)
    mockedUriComponentsBuilder.path(_) >> mockedUriComponentsBuilder
    mockedUriComponentsBuilder.build() >> new OpaqueUriComponents("hello","hello","hello")

    given:
    def taxationController = new TaxationController(mockedTaxationRepository,null)
    def tax = null; //new Taxation(id:theId, billingId:theBillingId, billingProfile:theBillingProfile, billingAmount:theBillingAmount, billingCurrency:theBillingCurrency, taxAmount:theTaxAmount, taxCurrency:theTaxCurrency)

    when:
    taxationController.store(tax, mockedUriComponentsBuilder)

    then:
    1* mockedTaxationRepository.save(tax) >> tax

    where:
    theId << ['3', '4', '5']
    theBillingId << ['3', '4', '5']
    theBillingProfile << ['3', '4', '5']
    theBillingAmount << ['3000', '4000', '5000']
    theBillingCurrency << ['USD', 'USD', 'USD']
    theTaxAmount << ['300', '400', '500']
    theTaxCurrency << ['USD', 'USD', 'USD']
  }

  /*
   Verify the TaxationController "delete" method
   
  @Unroll("Validate delete() method for TaxEngine #id")
  def "test TaxationController delete() method"() {

    // mock the values that are expected to be found in the repo
    def mockedTaxationRepository = Mock(TaxationRepository)
    mockedTaxationRepository.findOne("1") >> tax1
    mockedTaxationRepository.findOne("2") >> tax2
    mockedTaxationRepository.delete(_) >> null

    given:
    def taxationController = new TaxationController(mockedTaxationRepository,null)

    when:
    def result= taxationController.delete(theId)

    then:
    1*mockedTaxationRepository.delete(theId)
    result.getStatusCodeValue() == 200
    result.getBody().getId() == theId

    where:
    theId << ['1', '2']
  }

  /*
   Verify the TaxationController "merge" method
  
  @Unroll("Validate merge() method for TaxEngine #id")
  def "test TaxationController merge() method"() {

    // mock the values that are expected to be found in the repo
    def mockedTaxationRepository = Mock(TaxationRepository)
    mockedTaxationRepository.save(_) >> {arg -> return arg}

    given:
    def taxationController = new TaxationController(mockedTaxationRepository,null)
    def tax = null; //new Taxation(id:'7', billingId:'7', billingProfile:'7', billingAmount:'7000', billingCurrency:'USD', taxAmount:'700', taxCurrency:'USD')

    when:
    def result= taxationController.merge('7', tax)

    then:
    1 * mockedTaxationRepository.save(tax) >> tax
    result.getStatusCodeValue() == 200
    result.getBody().getId() == '7'
    result.getBody().getBillingId() == '7'
    result.getBody().getBillingProfile() == '7'
    result.getBody().getBillingAmount() == '7000'
    result.getBody().getBillingCurrency() == 'USD'
    result.getBody().getTaxAmount() == '700'
    result.getBody().getTaxCurrency() == 'USD'
  }
  
  /*
   Verify the TaxationController "calculateTaxes" method returns all values from the Repository
 
  def "test TaxationController calculateTaxes() method"() {

    // mock the values that are expected to be found in the repo
    def mockedTaxCalculatorService = Mock(TaxCalculatorService)
    def mockedUriComponentsBuilder = Mock(UriComponentsBuilder)
    mockedUriComponentsBuilder.path(_) >> mockedUriComponentsBuilder
    mockedUriComponentsBuilder.build() >> new OpaqueUriComponents("hello","hello","hello")
    mockedTaxCalculatorService.calculateTaxes(_) >> new TaxationResponse()

    given:
    def taxationController = new TaxationController(null, mockedTaxCalculatorService)

    when:
    def taxationResponse= taxationController.calculateTaxes(new TaxationRequest(), mockedUriComponentsBuilder)

    then:
    taxationResponse.getStatusCodeValue() == 200
  }  */
}

