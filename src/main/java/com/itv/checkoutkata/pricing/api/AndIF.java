package com.itv.checkoutkata.pricing.api;

import com.itv.checkoutkata.pricing.implementation.PricingFactory;
import com.itv.checkoutkata.pricing.implementation.ProductName;

public interface AndIF {
    ProductName and();

    PricingFactory build();
}
