package library.repository.datajpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import library.model.User;
import library.repository.UserRepository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    @Autowired
    private CrudUserRepository repository;

    @Override
    public User save(User user) { return repository.save(user); }


    @Override
    public void delete(int id) { repository.deleteById(id); }

    @Override
    public User get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }


    @Override
    public User getUserWithBooks(int id) {
        return repository.getUserById(id);
//        return repository.getUserWithBooks(id);
    }
}
