package de.reifebuch;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

/** Lokale HTTP-Demo mit synthetischen Daten für Paketmanager und JMeter. */
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String sorte = StringUtils.capitalize("bergkaese");
        byte[] response = gson.toJson(List.of(Map.of(
                "chargennummer", "2026-112",
                "sorte", sorte,
                "laibeImKeller", 24
        ))).getBytes(StandardCharsets.UTF_8);

        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 8080), 100);
        server.setExecutor(Executors.newFixedThreadPool(64));
        server.createContext("/api/chargen", exchange -> {
            try (exchange) {
                if (!exchange.getRequestURI().getPath().equals("/api/chargen")) {
                    exchange.sendResponseHeaders(404, -1);
                    return;
                }
                if (!exchange.getRequestMethod().equals("GET")) {
                    exchange.getResponseHeaders().set("Allow", "GET");
                    exchange.sendResponseHeaders(405, -1);
                    return;
                }
                exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
                exchange.sendResponseHeaders(200, response.length);
                exchange.getResponseBody().write(response);
            }
        });
        server.start();
        LOG.info("Demo-API bereit unter http://127.0.0.1:8080/api/chargen");
    }
}
