package library.web.book;

import library.model.Book;
import library.service.BookService;
import library.web.user.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AbstractBookController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookService service;

    public Book get(int id) {
        log.info("get book (id = {})", id);
        return service.get(id);
    }

    public void delete(int id) {
        log.info("delete book (id = {})", id);
        service.delete(id);
    }

    public List<Book> getAll() {
        log.info("getAll books");
        return service.getAll();
    }

    public Book create(Book book) {
        log.info("create (id = {})", book);
        return service.create(book);
    }

    public Book getByName(String name) {
        int userId = SecurityUtil.authUserId();
        log.info("get by book with name = {}", name);
        return service.getByName(name);
    }

    public Book getByAuthor(String author) {
        int userId = SecurityUtil.authUserId();
        log.info("get by book with author = {}", author);
        return service.getByAuthor(author);
    }

    public Book getBookWithUsers(Book book) {
        int userId = SecurityUtil.authUserId();
        log.info("get book with users (id = {})", userId);
        return service.getBookWithUsers(userId);
    }
}
