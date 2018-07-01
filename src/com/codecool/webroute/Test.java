package com.codecool.webroute;



import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class Test {

    public static void main(String[] args) throws Exception{
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        for (Method method: Class.forName("com.codecool.webroute.MyRoute").getDeclaredMethods()) {
            if(method.isAnnotationPresent(WebRoute.class)) {
                server.createContext(method.getAnnotation(WebRoute.class).value(), new MyHandler());
            }
        }

        server.setExecutor(null);
        server.start();
    }
}
