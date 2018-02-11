package com.itv.checkoutkata.pricing.implementation;

import com.google.common.base.Strings;
import com.itv.checkoutkata.pricing.api.ProductNameIF;
import com.itv.checkoutkata.pricing.api.ProductPriceIF;

public class ProductName implements ProductNameIF {
    private PricingFactoryBuilder pricingFactoryBuilder;
    private PricingInformation pricingInformation;

    public ProductName(PricingFactoryBuilder pricingFactoryBuilder, PricingInformation pricingInformation) {
        this.pricingFactoryBuilder = pricingFactoryBuilder;
        this.pricingInformation = pricingInformation;
    }

    @Override
    public ProductPriceIF productName(String name) {
        if (Strings.isNullOrEmpty(name)) throw new IllegalArgumentException("ProductName can't be null.");
        pricingInformation.setProductName(name);
        return new ProductPrice(pricingFactoryBuilder, pricingInformation);
    }
}
