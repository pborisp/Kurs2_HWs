package org.skypro.skyshop.product;

public abstract class Product {
    protected String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract Boolean isSpecial();

    public abstract int getPrice();

    @Override
    public String toString() {
        return nameProduct + '\'';
    }
}
