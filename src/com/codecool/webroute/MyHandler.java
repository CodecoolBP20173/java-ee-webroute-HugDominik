package com.codecool.webroute;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MyHandler implements HttpHandler{

    private static int counter = 0;

    private int index;

    MyHandler() {
        this.index = counter;
        counter++;
    }

    static void handleRequests (HttpExchange requestData, String response) throws IOException {
        requestData.sendResponseHeaders(200, response.length());
        OutputStream os = requestData.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        MyRoute server = new MyRoute();
        try {
            Method[] routeList = routeMethodList();
            routeList[index].invoke(server, httpExchange);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Method[] routeMethodList() throws ClassNotFoundException {
        return Class.forName("com.codecool.webroute.MyRoute").getDeclaredMethods();
    }
}
