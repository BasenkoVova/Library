package library.repository;

import library.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

    User getUserWithBooks(int id);
}
