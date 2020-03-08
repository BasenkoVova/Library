package library.web.book;

import library.model.Book;
import library.service.BookService;
import library.service.UserService;
import library.web.user.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static library.web.Util.getReqParameter;

@Controller
@RequestMapping(value = "/books")
public class JspBookController extends AbstractBookController{




    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("book", super.get(getReqParameter(request, "id")));
        return "bookForm";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getReqParameter(request, "id"));
        return "redirect:/books";
    }




    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        Book book = new Book(
                request.getParameter("id").isEmpty() ? null : getReqParameter(request, "id"),
                request.getParameter("name_book"),
                request.getParameter("author_book"),
                request.getParameter("date_book"),
                getReqParameter(request, "price_book"));
        super.create(book);
        return "redirect:books";
    }





}
