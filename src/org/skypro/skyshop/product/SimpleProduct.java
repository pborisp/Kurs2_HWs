package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String nameProduct, int price) {
        super(nameProduct);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public Boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return nameProduct + '\'' +
                " : " + price + " рублей";
    }
}
