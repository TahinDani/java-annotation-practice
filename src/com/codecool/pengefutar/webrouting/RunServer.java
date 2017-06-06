package com.codecool.pengefutar.webrouting;

import com.sun.deploy.net.HttpRequest;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class RunServer {

    public static void main(String[] args) throws Exception {
        Class<Routes> obj = Routes.class;

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.start();

        for (Method method : obj.getDeclaredMethods()) {

            // if method is annotated with @Test
            if (method.isAnnotationPresent(WebRoute.class)) {
                Annotation annotation = method.getAnnotation(WebRoute.class);
                WebRoute route = (WebRoute) annotation;
                HttpHandler handler = (HttpHandler) method.invoke(obj.newInstance());
                try {
                    server.createContext(route.routeName(), handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
