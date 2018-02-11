package com.itv.checkoutkata.pricing.implementation;

import java.util.HashSet;
import java.util.Set;

public class PricingInformations {
    private PricingFactoryBuilder pricingFactoryBuilder;
    private Set<PricingInformation> pricingInformations = new HashSet<>();

    public PricingInformations(PricingFactoryBuilder pricingFactoryBuilder) {
        this.pricingFactoryBuilder = pricingFactoryBuilder;
    }

    public ProductName informations() {
        final PricingInformation pricingInformation = new PricingInformation();
        pricingInformations.add(pricingInformation);
        return new ProductName(pricingFactoryBuilder, pricingInformation);
    }

    public Set<PricingInformation> getPricingInformations() {
        return pricingInformations;
    }
}
