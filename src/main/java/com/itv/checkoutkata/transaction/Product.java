package com.itv.checkoutkata.transaction;

import com.google.common.base.Objects;

public class Product {
    private String name;
    private Integer quantity = 0;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public void incremeantQuantity() {
        this.quantity++;
    }

    public void decremeantQuantity() {
        this.quantity++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equal(name, product.name) &&
                Objects.equal(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
