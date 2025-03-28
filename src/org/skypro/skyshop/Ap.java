package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class Ap {
    public static void main(String[] args) {
        Product table = new Product("Стол", 15000);
        Product chair = new Product("Стул", 7000);
        Product tv = new Product("телевизор", 75000);

        // объект корзина
        Product[] basketProduct = new Product[5];
        for (int i = 0; i < basketProduct.length; i++) {
            basketProduct[i] = null;
        }

        ProductBasket basket = new ProductBasket(basketProduct, 5);

        //добавляем в корзину продукты
        basket.addProduct(table);
        basket.addProduct(table);
        basket.addProduct(chair);
        basket.addProduct(chair);
        basket.addProduct(tv);
        // добавляем в корзину лишний продукт
        basket.addProduct(tv);

        basket.printBasket();
        basket.sumPrice();

        // поиск продукта в корзине
        if (basket.findProduct(table.getNameProduct())) {
            System.out.println("Продукт есть в корзине");
        } else {
            System.out.println("Продукта нет в корзине");
        }

        basket.cleanBasket();
        basket.printBasket();
        basket.sumPrice();


    }
}