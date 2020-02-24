package library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import library.service.BookService;
import library.service.UserService;


@Controller
public class RootController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;


//    @PostConstruct
//    private void postConstruct() {
//        bookService.create(new Book(null, "Монах, що продав свій фераарі", "Робін Шарма", "2015"));
//        bookService.create(new Book(null, "Найбагатша людина у Вавилоні", "Джордж Клейсон", "2017"));
//        bookService.create(new Book(null, "Стратегії геніїв", "Девід Йоффе, Майкл Кузумано", "2017"));
//
//        userService.create(new User(null, "User", "user@google.ua", Role.ROLE_USER));
//        userService.create(new User(null, "Admin", "admin@google.ua", Role.ROLE_ADMIN));
//    }


    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        return "users";
    }

    @GetMapping("/books")
    public String books(Model model) {
        return "books";
    }

}
