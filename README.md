Using Build patteren to add Price informations and offers.

Example from table is used to build Price informations.

Pricing Information Builder:
```
new PricingFactoryBuilder()
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
    .build();"# checkout-kata" 
```
