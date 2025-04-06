package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String nameProduct, int price) {
        super(nameProduct);
        try {
            definitionPrice(price);
        } catch (IllegalArgumentException e) {
            System.out.println("Цена не может быть меньше или равна 0");
        }
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
