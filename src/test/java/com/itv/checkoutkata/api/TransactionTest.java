package com.itv.checkoutkata.api;

import com.google.common.collect.ImmutableSet;
import com.itv.checkoutkata.pricing.implementation.PricingFactory;
import com.itv.checkoutkata.pricing.implementation.PricingFactoryBuilder;
import com.itv.checkoutkata.pricing.implementation.PricingInformation;
import com.itv.checkoutkata.transaction.TransactionImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransactionTest {

    private TransactionIF transaction;
    private PricingFactory pricingFactory;
    @Before
    public void setUp() {
        transaction = new TransactionImpl();
        pricingFactory = new PricingFactoryBuilder()
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
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullProductName() {
        transaction.scan(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyProductName() {
        transaction.scan("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullRules() {
        transaction.scan("A");
        transaction.checkout(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyRules() {
        transaction.scan("A");
        transaction.checkout(ImmutableSet.<PricingInformation>of());
    }

    @Test
    public void testFirstExampleFromTheTable() {
        transaction.scan("A")
                .scan("A")
                .scan("B")
                .scan("B")
                .scan("A")
                .scan("C")
                .scan("D");
        final Long total = transaction.checkout(pricingFactory.getPricingInformations().getPricingInformations());
        System.out.println(total);
        Assert.assertEquals(210L, total.longValue());
    }

    @Test
    public void testScaningInAnyOrderTheyCome() {
        transaction.scan("A")
                .scan("B")
                .scan("A")
                .scan("C")
                .scan("A")
                .scan("D");
        Long total = transaction.checkout(pricingFactory.getPricingInformations().getPricingInformations());
        Assert.assertEquals(195L, total.longValue());
    }

    @Test
    public void testScaningWithoutOffers() {
        transaction.scan("A")
                .scan("B")
                .scan("C")
                .scan("D");
        Long total = transaction.checkout(pricingFactory.getPricingInformations().getPricingInformations());
        Assert.assertEquals(115L, total.longValue());
    }

    @Test
    public void testScaningOnlyOneProductA() {
        transaction.scan("A");
        Long total = transaction.checkout(pricingFactory.getPricingInformations().getPricingInformations());
        Assert.assertEquals(50L, total.longValue());
    }

    @Test
    public void testScaningOnlyOneProductD() {
        transaction.scan("D");
        Long total = transaction.checkout(pricingFactory.getPricingInformations().getPricingInformations());
        Assert.assertEquals(15L, total.longValue());
    }

    @Test
    public void testScaningTwoTimesTheQuantityOfOffer(){
        final Long total = transaction.scan("A")
                                        .scan("B")
                                        .scan("A")
                                        .scan("C")
                                        .scan("A")
                                        .scan("D")
                                        .scan("A")
                                        .scan("A")
                                        .scan("A")
                                        .checkout(pricingFactory.getPricingInformations().getPricingInformations());
        Assert.assertEquals(325L, total.longValue());


    }

    @Test
    public void testingExampleTwo(){
        final Long total = transaction.scan("B")
                .scan("A")
                .scan("B")
                .checkout(pricingFactory.getPricingInformations().getPricingInformations());
        Assert.assertEquals(95L, total.longValue());
    }
}