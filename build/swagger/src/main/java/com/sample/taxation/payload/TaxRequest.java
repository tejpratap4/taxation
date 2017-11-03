package com.sample.taxation.payload;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.sample.taxation.payload.Item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;



/**
 * The body of the request to calculate the tax.
 **/

/**
 * The body of the request to calculate the tax.
 */
@ApiModel(description = "The body of the request to calculate the tax.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-11-03T06:02:54.512+05:30")

public class TaxRequest   {
  private List<Item> purchaseItems = new ArrayList<Item>();

  public TaxRequest purchaseItems(List<Item> purchaseItems) {
    this.purchaseItems = purchaseItems;
    return this;
  }

  public TaxRequest addPurchaseItemsItem(Item purchaseItemsItem) {
    this.purchaseItems.add(purchaseItemsItem);
    return this;
  }

   /**
   * A list of tax details for the tax applied to the purchase.
   * @return purchaseItems
  **/
  @ApiModelProperty(required = true, value = "A list of tax details for the tax applied to the purchase.")
  public List<Item> getPurchaseItems() {
    return purchaseItems;
  }

  public void setPurchaseItems(List<Item> purchaseItems) {
    this.purchaseItems = purchaseItems;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxRequest taxRequest = (TaxRequest) o;
    return Objects.equals(this.purchaseItems, taxRequest.purchaseItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchaseItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxRequest {\n");
    
    sb.append("    purchaseItems: ").append(toIndentedString(purchaseItems)).append("\n");
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

