package com.itv.checkoutkata.pricing.api;

public interface ProductPriceIF extends AndIF {
    ProductPriceIF price(Long price);

    ProductQuatityIF offer();
}
