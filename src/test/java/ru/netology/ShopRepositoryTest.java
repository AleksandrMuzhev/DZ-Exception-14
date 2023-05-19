package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository shop = new ShopRepository();
    Product product = new Product(5, "хлеб", 40);

    @BeforeEach
    public void setup() {
        shop.add(product);
    }

    @Test
    public void testSuccessRemoveExisting() {
        Product[] expected = {};
        Product[] actual = shop.remove(5);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFoundExceptionRemove() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.remove(55);
        });
    }
}
