package com.itv.checkoutkata.pricing.implementation;

import com.itv.checkoutkata.pricing.api.ProductQuatityIF;
import com.itv.checkoutkata.pricing.api.ProductPriceIF;

public class ProductPrice implements ProductPriceIF {

    private PricingFactoryBuilder pricingFactoryBuilder;
    private PricingInformation pricingInformation;

    public ProductPrice(PricingFactoryBuilder pricingFactoryBuilder, PricingInformation pricingInformation) {
        this.pricingFactoryBuilder = pricingFactoryBuilder;
        this.pricingInformation = pricingInformation;
    }

    @Override
    public ProductPriceIF price(Long price) {
        if (price == null) throw new IllegalArgumentException("Price can't be null.");
        this.pricingInformation.setProductPrice(price);
        return this;
    }

    @Override
    public ProductQuatityIF offer() {
        return new ProductQuatity(pricingFactoryBuilder, pricingInformation);
    }

    @Override
    public ProductName and() {
        return pricingFactoryBuilder.informations();
    }

    @Override
    public PricingFactory build() {
        return pricingFactoryBuilder.build();
    }
}
