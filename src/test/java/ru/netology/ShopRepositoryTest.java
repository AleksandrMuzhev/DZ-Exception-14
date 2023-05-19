package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository shop = new ShopRepository();
    Product product = new Product(5, "хлеб", 40);

    @BeforeEach
    public void setup() throws AlreadyExistsException {
        shop.add(product);
    }

    @Test
    public void testSuccessRemoveExisting() {
        Product[] expected = {};
        Product[] actual = shop.removeById(5);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFoundExceptionRemove() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.removeById(55);
        });
    }

    @Test
    public void testSuccessAdd() throws AlreadyExistsException {
        Product product1 = new Product(15, "сникерс", 65);

        Product[] expected = {product, product1};
        Product[] actual = shop.add(product1);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAlreadyAddProduct() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shop.add(product);
        });
    }
}
