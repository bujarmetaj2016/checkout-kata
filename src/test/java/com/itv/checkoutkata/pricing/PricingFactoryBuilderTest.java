package com.itv.checkoutkata.pricing;

import com.itv.checkoutkata.pricing.implementation.PricingFactory;
import com.itv.checkoutkata.pricing.implementation.PricingFactoryBuilder;
import com.itv.checkoutkata.pricing.implementation.PricingInformation;
import com.itv.checkoutkata.pricing.implementation.ProductName;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PricingFactoryBuilderTest {

    private PricingFactory pricingFactory;

    @Test
    public void testInitPricingFactory() {
        pricingFactory = new PricingFactoryBuilder().build();
        ProductName information = pricingFactory.getPricingInformations().informations();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullProductName() {
        new PricingFactoryBuilder()
                .informations()
                .productName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyProductName() {
        new PricingFactoryBuilder()
                .informations()
                .productName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullProductPrice() {
        new PricingFactoryBuilder()
                .informations()
                .productName("A")
                .price(null);
    }

    @Test
    public void testWithTwoPriceInformations() {
        this.pricingFactory = new PricingFactoryBuilder()
                .informations()
                    .productName("A")
                    .price(1l)
                .and()
                    .productName("B")
                    .price(2L)
                .build();
        Set<PricingInformation> informations = this.pricingFactory.getPricingInformations().getPricingInformations();
        Assert.assertEquals(2, informations.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullQuantity() {
        new PricingFactoryBuilder()
                .informations()
                    .productName("A")
                    .price(0l)
                .offer()
                    .quatity(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullSpecialPrnice() {
        new PricingFactoryBuilder()
                .informations()
                    .productName("A")
                    .price(0l)
                .offer()
                    .quatity(1)
                    .specialPrice(null);
    }

    @Test
    public void testCheckIfWeCanCreateExampleOne() {
        final Set<PricingInformation> expected = expectedPricingInformation();

        final PricingFactory pricingFactory = new PricingFactoryBuilder()
                .informations()
                    .productName("A")
                    .price(50L)
                    .offer()
                        .quatity(3)
                        .specialPrice(130L)
                .and()
                    .productName("B")
                    .price(30L)
                    .offer()
                        .quatity(2)
                        .specialPrice(45L)
                .and()
                    .productName("C")
                    .price(20L)
                .and()
                    .productName("D")
                    .price(15L)
                .build();

        Set<PricingInformation> actual = pricingFactory.getPricingInformations().getPricingInformations();

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertEquals(expected, actual);
    }

    private Set<PricingInformation> expectedPricingInformation() {
        Set<PricingInformation> pricingInformations = new HashSet<>();
        pricingInformations.add(new PricingInformation()
                .setProductName("A")
                .setProductPrice(50L)
                .setProducQuatity(3)
                .setProductSpecialPrice(130L));
        pricingInformations.add(new PricingInformation()
                .setProductName("B")
                .setProductPrice(30L)
                .setProducQuatity(2)
                .setProductSpecialPrice(45L));
        pricingInformations.add(new PricingInformation()
                .setProductName("C")
                .setProductPrice(20L));
        pricingInformations.add(new PricingInformation()
                .setProductName("D")
                .setProductPrice(15L));
        return pricingInformations;
    }

}