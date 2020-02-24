package library.repository;

import library.model.Book;

import java.util.List;

public interface BookRepository {
    Book save(Book book);

    void delete(int id);

    Book get(int id);

    Book getByName(String name);

    Book getByAuthor(String author);

    List<Book> getAll();

    Book getBookWithUsers(int id);

}
