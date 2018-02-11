package com.itv.checkoutkata.pricing.implementation;

import com.itv.checkoutkata.pricing.api.AndIF;
import com.itv.checkoutkata.pricing.api.SpecialPriceIF;
import com.itv.checkoutkata.pricing.implementation.AndImpl;
import com.itv.checkoutkata.pricing.implementation.PricingFactoryBuilder;
import com.itv.checkoutkata.pricing.implementation.PricingInformation;

public class SpecialPriceImpl implements SpecialPriceIF {
    private PricingFactoryBuilder pricingFactoryBuilder;
    private PricingInformation pricingInformation;

    public SpecialPriceImpl(PricingFactoryBuilder pricingFactoryBuilder, PricingInformation pricingInformation) {
        this.pricingFactoryBuilder = pricingFactoryBuilder;
        this.pricingInformation = pricingInformation;
    }

    @Override
    public AndIF specialPrice(Long price) {
        if (price == null) throw new IllegalArgumentException("Price can't be null.");
        pricingInformation.setProductSpecialPrice(price);
        return new AndImpl(pricingFactoryBuilder);
    }
}
