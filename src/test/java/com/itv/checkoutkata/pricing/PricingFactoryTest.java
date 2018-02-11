package com.itv.checkoutkata.pricing;

import com.itv.checkoutkata.pricing.implementation.PricingFactory;
import org.junit.Before;
import org.junit.Test;

public class PricingFactoryTest {

    private PricingFactory pricingFactory;

    @Before
    public void setUp() {
        pricingFactory = new PricingFactory(null);
    }

    @Test(expected = NullPointerException.class)
    public void testPricingInformationsWhenNotInit() {
        pricingFactory.getPricingInformations().informations();
    }
}