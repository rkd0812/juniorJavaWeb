package week8.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import week8.db.DataBase;
import week8.http.HttpRequest;
import week8.http.HttpResponse;
import week8.model.User;

public class CreateUserController extends AbstractController {
    private static final Logger log = LoggerFactory.getLogger(CreateUserController.class);

    @Override
    protected void doPost(HttpRequest request, HttpResponse response) {
        User user = new User(request.getParameter("userId"), request.getParameter("password"),
                request.getParameter("name"), request.getParameter("email"));
        log.debug("user : {}", user);
        DataBase.addUser(user);
        response.sendRedirect("/index.html");
    }
}
