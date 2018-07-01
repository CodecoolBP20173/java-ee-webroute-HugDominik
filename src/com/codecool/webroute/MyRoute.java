package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

import static com.codecool.webroute.MyHandler.handleRequests;

public class MyRoute {

    @WebRoute("/test1")
    void onTest1(HttpExchange requestData) throws IOException {
        String response = "This is test 1";
        handleRequests(requestData, response);
    }

    @WebRoute("/test2")
    void onTest2(HttpExchange requestData) throws IOException {
        String response = "This is test 2";
        handleRequests(requestData, response);
    }

    @WebRoute("/nothing")
    void onNothing(HttpExchange requestData) throws IOException {
        String response = "This is nothing";
        handleRequests(requestData, response);
    }
}
