package com.itv.checkoutkata.pricing.implementation;

public class PricingFactory {
    private PricingInformations pricingInformations;

    public PricingFactory(PricingInformations pricingInformations) {
        this.pricingInformations = pricingInformations;
    }

    public PricingInformations getPricingInformations() {
        return pricingInformations;
    }
}
