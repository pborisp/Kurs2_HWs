package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private Product[] productBasket;
    private int count;

    public ProductBasket(int size) {
        productBasket = new Product[size];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count == productBasket.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        productBasket[count] = product;
        count++;
    }

    public void printBasket() {
        if (this.productBasket[0] == null) {
            System.out.println("в корзине пусто");
            System.out.println("Итого: 0 рублей");
            return;
        }
        int sum = 0;
        int countSpecial = 0;
        for (int i = 0; i < productBasket.length; i++) {
            if (this.productBasket[i] != null) {
                sum += this.productBasket[i].getPrice();
                System.out.println(this.productBasket[i]);
            }
            if (this.productBasket[i].isSpecial()) {
                countSpecial++;
            }
        }
        System.out.println("Итого: " + sum + " рублей");
        System.out.println("Специальных товаров: " + countSpecial + " шт");
        System.out.println();
    }

    public boolean findProduct(String name) {
        for (int i = 0; i < productBasket.length; i++) {
            if (this.productBasket[i].getNameProduct().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < productBasket.length; i++) {
            this.productBasket[i] = null;
        }
    }

    public Product getProduct() {
        return productBasket[0];
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket basket = (ProductBasket) o;
        return Objects.deepEquals(productBasket, basket.productBasket);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(productBasket);
    }
}
