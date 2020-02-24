package library.repository.datajpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import library.model.User;


@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {

    User getByEmail(String email);


    @EntityGraph(attributePaths = {"books"})
    User getUserById(int id);
}
