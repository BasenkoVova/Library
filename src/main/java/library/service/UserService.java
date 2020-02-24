package library.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import library.model.User;
import library.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository repository;

//    @PostConstruct
//    private void postConstruct() {
//        repository.save(new User(null, "User", "user@google.ua", Role.ROLE_USER));
//        repository.save(new User(null, "Admin", "admin@google.ua", Role.ROLE_ADMIN));
//    }


    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public User get(int id) {
        return repository.get(id);
    }

    public User getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public User getUserWithBooks(int id) {
        return repository.getUserWithBooks(id);
    };










}
