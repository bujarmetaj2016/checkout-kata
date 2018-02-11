package com.itv.checkoutkata.pricing.implementation;

import com.itv.checkoutkata.pricing.api.ProductQuatityIF;
import com.itv.checkoutkata.pricing.api.SpecialPriceIF;

public class ProductQuatity implements ProductQuatityIF {
    private PricingFactoryBuilder pricingFactoryBuilder;
    private PricingInformation pricingInformation;

    public ProductQuatity(PricingFactoryBuilder pricingFactoryBuilder, PricingInformation pricingInformation) {
        this.pricingFactoryBuilder = pricingFactoryBuilder;
        this.pricingInformation = pricingInformation;
    }

    @Override
    public SpecialPriceIF quatity(Integer quatity) {
        if (quatity == null) throw new IllegalArgumentException("Quatity can't be null.");
        pricingInformation.setProducQuatity(quatity);
        return new SpecialPriceImpl(pricingFactoryBuilder, pricingInformation);
    }
}
