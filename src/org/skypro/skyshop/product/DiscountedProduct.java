package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - basePrice * discount / 100;
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return nameProduct + '\'' +
                " : " + getPrice() + " рублей" + " с учетом cкидки " + discount + "%";
    }
}
