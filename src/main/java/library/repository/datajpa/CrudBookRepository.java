package library.repository.datajpa;

import library.model.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudBookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> getByName(String name);

    Optional<Book> getByAuthor(String author);

//
    @EntityGraph(attributePaths = {"users"})//, type = EntityGraph.EntityGraphType.LOAD
    Book getById(int id);
//    @Query("SELECT b FROM Book b JOIN FETCH b.users WHERE b.id = ?1")
//    Book getBookWithUsers(int id);
//
}
