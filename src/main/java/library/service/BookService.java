package library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import library.model.Book;
import library.repository.BookRepository;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private final BookRepository repository;


    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }


    public Book create(Book book) { return repository.save(book); }

    public void delete(int id) {
        repository.delete(id);
    }

    public Book get(int id) {
        return repository.get(id);
    }

    public Book getByName(String name) {
        return repository.getByName(name);
    }

    public Book getByAuthor(String author) {
        return repository.getByAuthor(author);
    }

    public List<Book> getAll() {
        return repository.getAll();
    }

    public Book getBookWithUsers(int id) { return repository.getBookWithUsers(id); }


}
