package week8.controller;

import week8.db.DataBase;
import week8.http.HttpRequest;
import week8.http.HttpResponse;
import week8.model.User;

public class LoginController extends AbstractController {

    @Override
    protected void doPost(HttpRequest request, HttpResponse response) {
        User user = DataBase.findUserById(request.getParameter("userId"));
        if (user != null) {
            if (user.login(request.getParameter("password"))) {
                response.addHeader("Set-Cookie", "logined=true; Path=/");
                response.sendRedirect("/index.html");
            } else {
                response.sendRedirect("/user/login_failed.html");
            }
        } else {
            response.sendRedirect("/user/login_failed.html");
        }
    }
}
