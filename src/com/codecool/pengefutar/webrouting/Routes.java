package com.codecool.pengefutar.webrouting;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Routes {

    @WebRoute(routeName = "/test1")
    public HttpHandler test1() throws IOException{
        MyHandler handler = new MyHandler();
        handler.setResponse("called test1");
        return handler;
    }

    @WebRoute(routeName = "/test2")
    public HttpHandler test2() throws IOException{
        MyHandler handler = new MyHandler();
        handler.setResponse("called test2");
        return handler;
    }

    @WebRoute(routeName = "/test3")
    public HttpHandler test3() throws IOException{
        MyHandler handler = new MyHandler();
        handler.setResponse("called test3");
        return handler;
    }
}
