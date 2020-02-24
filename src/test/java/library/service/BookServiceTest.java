package library.service;

import javassist.NotFoundException;
import library.TestDateUser;
import library.model.Book;
import library.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static library.TestDateBook.*;
import static library.TestDateUser.ADMIN;
import static library.TestDateUser.USER;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookServiceTest extends AbstractServiceTest {

    @Autowired
    private BookService service;

    @Test
    void create() {
        Book newBook = new Book(null, "7 звичок надзвичайно ефективних людей", "Стівен Кові", "2012",90);
        Book created = service.create(newBook);
        newBook.setId(created.getId());
        assertMatch(created, newBook);
    }


    @Test
    void delete() {
        service.delete(USER_BOOK_ID_1);
        assertThrows(NotFoundException.class, () ->
                service.delete(USER_BOOK_ID_1));
    }

    @Test
    void get() {
        Book book = service.get(USER_BOOK_ID_1);
        assertMatch(book, BOOK1);
    }


    @Test
    public void getByName() {
        Book book = service.getByName("Монах, що продав свій феррарі");
        assertMatch(book, BOOK1);
    }


    @Test
    void getByAuthor() {
        Book book = service.getByAuthor("Робін Шарма");
        assertMatch(book, BOOK1);
    }

    @Test
    void getAll() {
        List<Book> all = service.getAll();
        assertMatch(all, List.of(BOOK1, BOOK2, BOOK3));
    }

    @Test
    void getAllByUsers() {
        Book all = service.getBookWithUsers(USER_BOOK_ID_1);
        Set<User> BookUsers = all.getUsers();
        TestDateUser.assertMatch(BookUsers, List.of(USER, ADMIN));
    }


    @Test
    void update() {
        Book book = BOOK1;
        book.setName("Монах, що продав свій феррарі і придбав жигуля");
        Book updater = service.create(book);
        assertMatch(updater, book);
    }

}