package project.api;

import project.app.*;
import project.utils.*;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ApiController {
    private static String path = System.getProperty("user.dir") + "/src/main/java/project/";
    private static String fileName = "bd.json";
    private static final int PORT = 8080;
    private static final Gson gson = new Gson();
    private static final FileManager fileManager = new FileManager(path + fileName);

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        server.createContext("/api/avions", new JsonHandler("avions"));
        server.createContext("/api/aeroports", new JsonHandler("aeroports"));
        server.createContext("/api/vols", new JsonHandler("vols"));
        server.createContext("/api/reservations", new JsonHandler("reservations"));
        server.createContext("/api/personnes", new JsonHandler("personnes"));

        server.setExecutor(null);
        System.out.println("Serveur démarré sur http://localhost:" + PORT + "/api/" + "{catégorie}");
        server.start();
    }

    static class JsonHandler implements HttpHandler {
        private final String type;

        public JsonHandler(String type) {
            this.type = type;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            BaseDeDonnees bd = fileManager.lire(BaseDeDonnees.class);
            String response;

            switch (type) {
                case "avions":
                    response = gson.toJson(bd.getAvions());
                    break;
                case "aeroports":
                    response = gson.toJson(bd.getAeroports());
                    break;
                case "vols":
                    response = gson.toJson(bd.getVols());
                    break;
                case "reservations":
                    response = gson.toJson(bd.getReservations());
                    break;
                case "personnes":
                    response = gson.toJson(bd.getPersonnes());
                    break;
                default:
                    response = "{\"error\": \"Type inconnu\"}";
                    exchange.sendResponseHeaders(400, response.length());
                    break;
            }

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}