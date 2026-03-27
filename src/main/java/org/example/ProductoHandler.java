package org.example;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProductoHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if(exchange.getRequestMethod().equals("GET")){
            System.out.println(exchange.getRequestMethod());
            Producto producto = new Producto("1","Preservativos",8700.0,"cuidado para san valentin",457,"Higiene");
            Gson gson = new Gson();
            String respuestaJson= gson.toJson(producto);
            System.out.println(respuestaJson);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200,respuestaJson.getBytes().length);
            OutputStream salida = exchange.getResponseBody();
            salida.write(respuestaJson.getBytes());
            salida.close();
        }
        else if (exchange.getRequestMethod().equals("POST")) {
            System.out.println(exchange.getRequestMethod());
            InputStream entrada = exchange.getRequestBody();
            String cuerpo = new String(entrada.readAllBytes());
            Gson gson = new Gson();
            Producto producto = gson.fromJson(cuerpo, Producto.class);

            String respuestaJson = gson.toJson(producto);

            System.out.println(respuestaJson);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, respuestaJson.getBytes().length);

            OutputStream salida = exchange.getResponseBody();
            salida.write(respuestaJson.getBytes());
            salida.close();
        }
        }
    }
