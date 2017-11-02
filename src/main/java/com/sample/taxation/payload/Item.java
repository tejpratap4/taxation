package com.sample.taxation.payload;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;



/**
 * The details of a items purchased.
 **/

/**
 * The details of a items purchased.
 */
@ApiModel(description = "The details of a items purchased.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-11-02T20:31:48.489+05:30")

public class Item   {
  private String itemName = null;

  private Integer quantity = null;

  private BigDecimal chargeAmount = null;

  public Item itemName(String itemName) {
    this.itemName = itemName;
    return this;
  }

   /**
   * A description of item.
   * @return itemName
  **/
  @ApiModelProperty(required = true, value = "A description of item.")
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public Item quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * The purchased quantity.
   * @return quantity
  **/
  @ApiModelProperty(required = true, value = "The purchased quantity.")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Item chargeAmount(BigDecimal chargeAmount) {
    this.chargeAmount = chargeAmount;
    return this;
  }

   /**
   * The amount of the purchase. The tax was calculated on this amount.
   * @return chargeAmount
  **/
  @ApiModelProperty(required = true, value = "The amount of the purchase. The tax was calculated on this amount.")
  public BigDecimal getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(BigDecimal chargeAmount) {
    this.chargeAmount = chargeAmount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(this.itemName, item.itemName) &&
        Objects.equals(this.quantity, item.quantity) &&
        Objects.equals(this.chargeAmount, item.chargeAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemName, quantity, chargeAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    
    sb.append("    itemName: ").append(toIndentedString(itemName)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    chargeAmount: ").append(toIndentedString(chargeAmount)).append("\n");
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

