package org.example;

import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
public class Main {
    static void main() throws IOException {
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8080),0);
        servidor.createContext("/api/productos", new ProductoHandler());
        servidor.setExecutor(null);
        servidor.start();
        System.out.println("Iniciando el servidor en el puerto 8080");
    }
}
