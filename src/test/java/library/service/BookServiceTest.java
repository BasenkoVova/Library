package library.service;

import library.TestDateUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import library.model.Book;
import library.model.User;

import java.util.List;
import java.util.Set;

import static library.TestDateBook.*;
import static library.TestDateUser.*;

public class BookServiceTest extends AbstractServiceTest{

    @Autowired
    private BookService service;

    @Test
    public void create() {
        Book newBook = new Book(null, "7 звичок надзвичайно ефективних людей", "Стівен Кові", "2012");
        Book created = service.create(newBook);
        newBook.setId(created.getId());
        assertMatch(created, newBook);
    }

    @Test
    public void delete() {
        service.delete(USER_BOOK_ID_1);
//        assertThrows(NotFoundException.class, () ->
//                service.delete(BOOK_ID));
    }

    @Test
    public void get() {
        Book book = service.get(USER_BOOK_ID_1);
        assertMatch(book, BOOK1);
    }


    @Test
    public void getByName() {
        Book book = service.getByName("Монах, що продав свій феррарі");
        assertMatch(book, BOOK1);
    }




    @Test
    public void getByAuthor() {
        Book book = service.getByAuthor("Робін Шарма");
        assertMatch(book, BOOK1);
    }

    @Test
    public void getAll() {
        List<Book> all = service.getAll();
        assertMatch(all, List.of(BOOK1, BOOK2,BOOK3));
    }

    @Test
    public void getAllByUsers()
    {
        Book all = service.getBookWithUsers(USER_BOOK_ID_1);
        Set<User> BookUsers = all.getUsers();
        TestDateUser.assertMatch(BookUsers, List.of(USER, ADMIN));
    }



    @Test
    public void update() {
        Book book = BOOK1;
        book.setName("Монах, що продав свій феррарі і придбав жигуля");
        Book updater = service.create(book);
        assertMatch(updater, book);
    }
}