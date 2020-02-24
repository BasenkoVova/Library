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

//        @PostConstruct
//    private void postConstruct() {
//            repository.save(new Book(1002, "Монах, що продав свій фераарі", "Робін Шарма", "2015"));
//            repository.save(new Book(1003, "Найбагатша людина у Вавилоні", "Джордж Клейсон", "2017"));
//            repository.save(new Book(1004, "Стратегії геніїв", "Девід Йоффе, Майкл Кузумано", "2017"));
//    }


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
