package library.web.user;

import library.model.Book;
import library.service.BookService;
import library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

//@RestController
//@RequestMapping(value = RestUserController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestUserController extends AbstractUserController {

    static final String REST_URL = "/rest/admin/users";






}
