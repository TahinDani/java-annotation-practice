package com.codecool.pengefutar.webrouting;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

    public class MyHandler implements HttpHandler {

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        private String response;

        @Override
        public void handle(HttpExchange t) throws IOException {
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

