package com.sample.taxation.payload;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.sample.taxation.payload.Item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



/**
 * The record that contains the results of the tax calculation.
 **/

/**
 * The record that contains the results of the tax calculation.
 */
@ApiModel(description = "The record that contains the results of the tax calculation.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-11-02T20:31:48.489+05:30")

public class TaxResponse   {
  private List<Item> taxImpacts = new ArrayList<Item>();

  private BigDecimal salesTax = null;

  private BigDecimal totalAmount = null;

  public TaxResponse taxImpacts(List<Item> taxImpacts) {
    this.taxImpacts = taxImpacts;
    return this;
  }

  public TaxResponse addTaxImpactsItem(Item taxImpactsItem) {
    this.taxImpacts.add(taxImpactsItem);
    return this;
  }

   /**
   * A list of tax details for the tax applied to the purchase.
   * @return taxImpacts
  **/
  @ApiModelProperty(required = true, value = "A list of tax details for the tax applied to the purchase.")
  public List<Item> getTaxImpacts() {
    return taxImpacts;
  }

  public void setTaxImpacts(List<Item> taxImpacts) {
    this.taxImpacts = taxImpacts;
  }

  public TaxResponse salesTax(BigDecimal salesTax) {
    this.salesTax = salesTax;
    return this;
  }

   /**
   * The amount of total sales tax applied to the purchase.
   * @return salesTax
  **/
  @ApiModelProperty(value = "The amount of total sales tax applied to the purchase.")
  public BigDecimal getSalesTax() {
    return salesTax;
  }

  public void setSalesTax(BigDecimal salesTax) {
    this.salesTax = salesTax;
  }

  public TaxResponse totalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
    return this;
  }

   /**
   * The total amount inclusive of taxs on the purchase.
   * @return totalAmount
  **/
  @ApiModelProperty(value = "The total amount inclusive of taxs on the purchase.")
  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxResponse taxResponse = (TaxResponse) o;
    return Objects.equals(this.taxImpacts, taxResponse.taxImpacts) &&
        Objects.equals(this.salesTax, taxResponse.salesTax) &&
        Objects.equals(this.totalAmount, taxResponse.totalAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxImpacts, salesTax, totalAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxResponse {\n");
    
    sb.append("    taxImpacts: ").append(toIndentedString(taxImpacts)).append("\n");
    sb.append("    salesTax: ").append(toIndentedString(salesTax)).append("\n");
    sb.append("    totalAmount: ").append(toIndentedString(totalAmount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

