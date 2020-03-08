package library.web.user;


import library.model.Role;
import library.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;
import java.util.Set;

import static library.web.Util.getReqParameter;


@Controller
@RequestMapping(value = "/users")
public class JspUserController extends AbstractUserController{


    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("user", super.get(getReqParameter(request, "id")));
        return "userForm";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }


    @GetMapping("/delete")
    public String delete(HttpServletRequest request) {
        super.delete(getReqParameter(request, "id"));
        return "redirect:/users";
    }


//    @GetMapping("/subscribe")
//    public String subscribe(HttpServletRequest request) {
//        super.getReqParameter(request, "id");
//        return "bookForm";
//    }



    @PostMapping("/login")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        SecurityUtil.setAuthUserId(userId);
        return "redirect:/books";
    }

    @PostMapping
    public String updateOrCreate(HttpServletRequest request) {
        User user = new User(
                request.getParameter("id").isEmpty() ? null : getReqParameter(request, "id"),
                request.getParameter("name_user"),
                request.getParameter("email_user"),
                Role.ROLE_USER);

        super.create(user);
        return "redirect:users";
    }
















//    private int getReqParameter(HttpServletRequest request, String nameParameter) {
//        String paramId = Objects.requireNonNull(request.getParameter(nameParameter));
//        return Integer.valueOf(paramId);
//    }
}
