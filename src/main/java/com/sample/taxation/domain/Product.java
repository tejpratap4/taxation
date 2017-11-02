package com.sample.taxation.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Product and tax type mapping.
 */
public class Product {

    private String name;
  
    private List<TaxType> applicableTaxes;

    public Product(String name, TaxType... applicableTaxes) {
        this.name = name;       
        this.applicableTaxes = Arrays.asList(applicableTaxes);
    }

    public String getName() {
        return name;
    }   

    public List<TaxType> getApplicableTaxes() {
        return applicableTaxes;
    }
}