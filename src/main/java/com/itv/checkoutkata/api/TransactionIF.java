package com.itv.checkoutkata.api;

import com.itv.checkoutkata.pricing.implementation.PricingInformation;
import com.itv.checkoutkata.transaction.TransactionImpl;

import java.util.Set;

public interface TransactionIF {
    TransactionImpl scan(String productName);

    Long checkout(Set<PricingInformation> rules);
}
