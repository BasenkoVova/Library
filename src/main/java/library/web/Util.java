package library.web;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


public class Util {






    public static int getReqParameter(HttpServletRequest request, String nameParameter) {
        String paramId = Objects.requireNonNull(request.getParameter(nameParameter));
        return Integer.valueOf(paramId);
    }





}
