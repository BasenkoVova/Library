package library.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import library.model.Book;
import library.repository.BookRepository;

import java.util.List;

@Repository
public class DataJpaBookRepository implements BookRepository {

    @Autowired
    private CrudBookRepository repository;



    @Override
    public Book save(Book book) {
        return repository.save(book);
    }


    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Book get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book getByName(String name) {
        return repository.getByName(name).orElse(null);
    }

    @Override
    public Book getByAuthor(String author) {
        return repository.getByAuthor(author).orElse(null);
    }


    @Override
    public Book getBookWithUsers(int id) {
//        return repository.getBookWithUsers(id);
        return repository.getById(id);
    }

}

