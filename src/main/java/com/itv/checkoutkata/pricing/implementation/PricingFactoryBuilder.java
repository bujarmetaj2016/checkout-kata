package com.itv.checkoutkata.pricing.implementation;

public class PricingFactoryBuilder {
    private PricingInformations pricingInformations;

    public PricingFactoryBuilder() {
        this.pricingInformations = new PricingInformations(this);
    }

    public ProductName informations() {
        return this.pricingInformations.informations();
    }

    public PricingFactory build() {
        return new PricingFactory(this.pricingInformations);
    }
}
