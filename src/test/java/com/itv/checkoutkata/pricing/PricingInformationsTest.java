package com.itv.checkoutkata.pricing;

import com.itv.checkoutkata.pricing.implementation.PricingInformations;
import org.junit.Before;
import org.junit.Test;

public class PricingInformationsTest {

    PricingInformations pricingInformations;

    @Before
    public void setUp() {
        this.pricingInformations = new PricingInformations(null);
    }

    @Test
    public void testSetRule() {
        pricingInformations.informations();
    }
}