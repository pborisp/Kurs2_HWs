package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.fixPriceProduct;

public class Ap {
    public static void main(String[] args) {
        Product table = new SimpleProduct("Стол", 15000);
        Product chair = new SimpleProduct("Стул", 7000);
        Product tv = new SimpleProduct("телевизор", 75000);
        Product phone = new DiscountedProduct("телефон", 90000, 30);
        Product sofa = new DiscountedProduct("диван", 49000, 25);
        Product lamp = new fixPriceProduct("светильник");

        // объект корзина
        ProductBasket basket = new ProductBasket(5);

        //добавляем в корзину продукты
        basket.addProduct(table);
        basket.addProduct(lamp);
        basket.addProduct(sofa);
        basket.addProduct(chair);
        basket.addProduct(tv);
        // добавляем в корзину лишний продукт
        basket.addProduct(tv);
        System.out.println();

        basket.printBasket();

        // поиск продукта в корзине
        if (basket.findProduct(table.getNameProduct())) {
            System.out.println("Продукт есть в корзине");
        } else {
            System.out.println("Продукта нет в корзине");
        }

        basket.cleanBasket();
        basket.printBasket();
    }
}