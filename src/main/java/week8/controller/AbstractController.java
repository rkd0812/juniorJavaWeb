package week8.controller;

import week8.http.HttpMethod;
import week8.http.HttpRequest;
import week8.http.HttpResponse;

public abstract class AbstractController implements Controller {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        HttpMethod httpMethod = request.getMethod();

        if (httpMethod.isPost()) {
            doPost(request, response);
        } else {
            doGet(request, response);
        }
    }

    protected void doPost(HttpRequest request, HttpResponse response) {

    }

    protected void doGet(HttpRequest request, HttpResponse response) {

    }
}
