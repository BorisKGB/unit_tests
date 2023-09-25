package ru.study.seminar1.Shop;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Shop emptyShop = new Shop();
        Product p1 = new Product();
        p1.setCost(15);
        p1.setTitle("p1");

        Product p2 = new Product();
        p2.setCost(5);
        p2.setTitle("p2");

        Product p3 = new Product();
        p3.setCost(25);
        p3.setTitle("p3");

        // 1. Напишите тесты, чтобы проверить, что
        // магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
        shop.setProducts(Arrays.asList(p1, p2, p3));

        assertThat(shop.getProducts()).containsExactly(p1, p2, p3);
        assertThat(emptyShop.getProducts()).isEqualTo(null);

        // 2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
        assertThat(shop.sortProductsByPrice()).containsExactlyInAnyOrder(p1, p2, p3);
        assertThat(emptyShop.sortProductsByPrice()).isEqualTo(null);

        // 3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(p3);
        assertThat(emptyShop.getMostExpensiveProduct()).isEqualTo(null);
    }

}