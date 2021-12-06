package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager productManager = new ProductManager(repository);
    private final Book firstBook = new Book(1, "maker1", 1523, "author1");
    private final Book secondBook = new Book(2, "book2", 1500, "author2");
    private final Book thirdBook = new Book(3, "book3", 750, "author2");
    private final Smartphone firstSmartphone = new Smartphone(4, "smartphone1", 15000, "maker1");
    private final Smartphone secondSmartphone = new Smartphone(5, "smartphone2", 15000, "maker2");

    @BeforeEach
    public void setUp() {
        productManager.add(firstBook);
        productManager.add(secondBook);
        productManager.add(thirdBook);
        productManager.add(firstSmartphone);
        productManager.add(secondSmartphone);
    }

    @Test
    public void shouldSearchBookByAuthor1() {
        String text = "author1";

        Product[] expected = new Product[] {firstBook};
        Product[] actual = productManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByName() {
        String text = "book2";

        Product[] expected = new Product[] {secondBook};
        Product[] actual = productManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBooksByAuthor() {
        String text = "author2";

        Product[] expected = new Product[] {secondBook, thirdBook};
        Product[] actual = productManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTextMaker1() {
        String text = "maker1";

        Product[] expected = new Product[] {firstBook, firstSmartphone};
        Product[] actual = productManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameOfSmartphone2() {
        String text = "smartphone2";

        Product[] expected = new Product[] {secondSmartphone};
        Product[] actual = productManager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

}