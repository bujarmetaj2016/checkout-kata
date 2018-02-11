package com.itv.checkoutkata.pricing.implementation;

import com.google.common.base.Objects;

public class PricingInformation {
    private String productName;
    private Integer producQuatity;
    private Long productPrice;
    private Long productSpecialPrice;

    public String getProductName() {
        return productName;
    }

    public PricingInformation setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getProducQuatity() {
        return producQuatity;
    }

    public PricingInformation setProducQuatity(Integer producQuatity) {
        this.producQuatity = producQuatity;
        return this;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public PricingInformation setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public Long getProductSpecialPrice() {
        return productSpecialPrice;
    }

    public PricingInformation setProductSpecialPrice(Long productSpecialPrice) {
        this.productSpecialPrice = productSpecialPrice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PricingInformation that = (PricingInformation) o;
        return Objects.equal(productName, that.productName) &&
                Objects.equal(producQuatity, that.producQuatity) &&
                Objects.equal(productPrice, that.productPrice) &&
                Objects.equal(productSpecialPrice, that.productSpecialPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName, producQuatity, productPrice, productSpecialPrice);
    }

    @Override
    public String toString() {
        return "PricingInformation{" +
                "productName='" + productName + '\'' +
                ", producQuatity=" + producQuatity +
                ", productPrice=" + productPrice +
                ", productSpecialPrice=" + productSpecialPrice +
                '}';
    }
}
