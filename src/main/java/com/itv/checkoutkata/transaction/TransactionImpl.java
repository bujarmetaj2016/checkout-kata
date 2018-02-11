package com.itv.checkoutkata.transaction;

import com.google.common.base.Strings;
import com.itv.checkoutkata.api.TransactionIF;
import com.itv.checkoutkata.pricing.implementation.PricingInformation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TransactionImpl implements TransactionIF {
    private Map<String, Product> productMap = new HashMap<>();

    public TransactionImpl scan(String productName) {
        if (Strings.isNullOrEmpty(productName)) throw new IllegalArgumentException("ProductName can't be null.");

        if (productMap.containsKey(productName)) {
            final Product product = productMap
                    .get(productName);
            product.incremeantQuantity();
        } else {
            final Product product = new Product()
                    .setName(productName);
            product.incremeantQuantity();
            productMap.put(productName, product);
        }
        return this;
    }

    public Long checkout(Set<PricingInformation> rules) {
        if (rules == null || rules.isEmpty()) throw new IllegalArgumentException("ProductName can't be null.");

        if (productMap == null || productMap.isEmpty()) return 0L;

        final Map<String, PricingInformation> ruleMap = rules.stream().collect(Collectors.toMap(PricingInformation::getProductName, o -> o));

        return productMap.values().stream().mapToLong(product -> calculate(ruleMap, product)).sum();
    }

    private Long calculate(Map<String, PricingInformation> ruleMap, Product product) {
        final String productName = product.getName();
        final Integer quantity = product.getQuantity() == null ||
                product.getQuantity() == 0 ? 1 : product.getQuantity();

        final PricingInformation pricingRule = ruleMap.get(productName);
        if (pricingRule.getProductSpecialPrice() == null) return quantity * pricingRule.getProductPrice();

        final Integer producQuatity = pricingRule.getProducQuatity() == null ||
                pricingRule.getProducQuatity() == 0 ? 1 : pricingRule.getProducQuatity();

        final Integer remainder = quantity % producQuatity;
        final Integer number = quantity / producQuatity;

        return number * pricingRule.getProductSpecialPrice() + remainder * pricingRule.getProductPrice();
    }
}
