package library.web;

import library.model.Book;
import library.model.Role;
import library.model.User;
import library.web.user.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import library.service.BookService;
import library.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Controller
public class RootController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String root() {
        return "index";
    }




    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

//    @PostMapping("/users")
//    public String setUser(HttpServletRequest request) {
//        int userId = Integer.parseInt(request.getParameter("userId"));
//        SecurityUtil.setAuthUserId(userId);
//        return "redirect:books";
//    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books",
                bookService.getAll());
        return "books";
    }

    @GetMapping("/books/user")
    public String getBooksUser(Model model) {
        model.addAttribute("books",
                userService.getUserWithBooks(SecurityUtil.authUserId()).getBooks());
        return "books";
    }








//    @GetMapping("/books/update")
//    public String update(HttpServletRequest request, Model model) {
//        model.addAttribute("book", bookService.get(getReqParameter(request, "id")));
//        return "bookForm";
//    }
//
//    @GetMapping("/books/create")
//    public String create(Model model) {
//        model.addAttribute("book", new Book(null, "", "","",null));
//        return "bookForm";
//    }
//
//
//    @GetMapping("/books/delete")
//    public String delete(HttpServletRequest request) {
//        bookService.delete(getReqParameter(request, "id"));
//        return "redirect:/books";
//    }


//    @PostMapping("/books")
//    public String updateOrCreate(HttpServletRequest request) {
//        Book book = new Book(
//                request.getParameter("id").isEmpty() ? null : getReqParameter(request, "id"),
//                request.getParameter("name_book"),
//                request.getParameter("author_book"),
//                request.getParameter("date_book"),
//                getReqParameter(request, "price_book"));
//        bookService.create(book);
//        return "redirect:books";
//    }




//    private int getReqParameter(HttpServletRequest request, String nameParameter) {
//        String paramId = Objects.requireNonNull(request.getParameter(nameParameter));
//        return Integer.valueOf(paramId);
//    }

}
