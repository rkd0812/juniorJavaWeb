package week8.controller;

import week8.http.HttpRequest;
import week8.http.HttpResponse;

public interface Controller {

    void service(HttpRequest httpRequest, HttpResponse httpResponse);
}
