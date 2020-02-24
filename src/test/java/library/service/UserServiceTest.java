package library.service;

import javassist.NotFoundException;
import library.TestDateBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import library.model.Book;
import library.model.Role;
import library.model.User;

import java.util.List;
import java.util.Set;

import static library.TestDateBook.*;
import static library.TestDateUser.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService service;

    @Test
    void create() throws Exception{
        User newUser = new User(null, "newSuperUser", "newUser@google.ua", Role.ROLE_USER);
        newUser.addBooks(BOOK1);
        User created = service.create(newUser);
        newUser.setId(created.getId());
        assertMatch(created, newUser);
    }

    @Test
    void delete() {
        service.delete(USER_ID);
        assertThrows(NotFoundException.class, () ->
                service.delete(USER_ID));
    }

    @Test
    void get()throws Exception {
        User user = service.get(ADMIN_ID);
        assertMatch(user, ADMIN);
    }

    @Test
    void getByEmail()throws Exception{
        User user = service.getByEmail("user@google.ua");
        assertMatch(user, USER);
    }

    @Test
    void getAll()throws Exception {
        List<User> all = service.getAll();
        assertMatch(all, List.of(ADMIN, USER));
    }

    @Test
    void update()throws Exception {
        User user = USER;
        user.setEmail("newEmail@google.ua");
        User newuser =service.create(user);
                assertMatch(newuser, user);
    }

    @Test
    void getUserWithBooks()
    {
        User all = service.getUserWithBooks(USER_ID);
        Set<Book> UserBooks = all.getBooks();
        TestDateBook.assertMatch(UserBooks, List.of(BOOK1, BOOK2, BOOK3));
    }
}