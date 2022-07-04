package week8.webserver;

import week8.controller.Controller;
import week8.controller.CreateUserController;
import week8.controller.ListUserController;
import week8.controller.LoginController;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {

    private static Map<String, Controller> controllers = new HashMap<String, Controller>();

    static {
        controllers.put("/user/create", new CreateUserController());
        controllers.put("/user/login", new LoginController());
        controllers.put("/user/list", new ListUserController());
    }

    public static Controller getController(String requestUrl) {
        return controllers.get(requestUrl);
    }
}
