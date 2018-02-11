package com.itv.checkoutkata.pricing.implementation;

import com.itv.checkoutkata.pricing.api.AndIF;

public class AndImpl implements AndIF {
    private PricingFactoryBuilder pricingFactoryBuilder;

    public AndImpl(PricingFactoryBuilder pricingFactoryBuilder) {
        this.pricingFactoryBuilder = pricingFactoryBuilder;
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
