package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private Product[] productBasket;
    private int size;

    public ProductBasket(Product[] productBasket, int size) {
        this.size = size;
        this.productBasket = productBasket;
    }

    public void addProduct(Product product) {
        for (int i = 0; i < this.size; i++) {
            if (this.productBasket[i] == null) {
                this.productBasket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int sumPrice() {
        int sum = 0;
        if (this.productBasket[0] == null) {
            sum = 0;
            return sum;
        }
        for (int i = 0; i < this.size; i++) {
            sum += this.productBasket[i].getPrice();
        }
        return sum;
    }

    public int sumSpecial() {
        int count = 0;
        if (this.productBasket[0] == null) {
            count = 0;
            return count;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.productBasket[i].isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public void printBasket() {
        if (this.productBasket[0] == null) {
            System.out.println("в корзине пусто");
            System.out.println("Итого: " + sumPrice());
            return;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.productBasket[i] != null) {
                System.out.println(this.productBasket[i]);
            }
        }
        System.out.println("Итого: " + sumPrice() + " рублей");
        System.out.println("Специальных товаров: " + sumSpecial() + " шт");
        System.out.println();
    }

    public boolean findProduct(String name) {
        for (int i = 0; i < this.size; i++) {
            if (this.productBasket[i].getNameProduct().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < this.size; i++) {
            this.productBasket[i] = null;
        }
    }

    public Product getProduct() {
        return productBasket[0];
    }

    public int getSize() {
        return size;
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
