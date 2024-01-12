package handlers;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import com.google.gson.Gson;

import persistence.JPAUtil;
import entities.Alergia;
import DAOs.AlergiaDAO;

public class CreateAlergiaHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();

        if (requestMethod.equalsIgnoreCase("POST")) {
            String body = new BufferedReader(
                new InputStreamReader(
                    exchange.getRequestBody(),
                    "utf-8"
                )
            ).lines().collect(Collectors.joining("\n"));

            Gson gson = new Gson();
            Alergia alergia = gson.fromJson(body, Alergia.class);

            EntityManager entityManager = JPAUtil.getEntityManager();
            AlergiaDAO alergiaDAO = new AlergiaDAO(entityManager);

            alergiaDAO.create(alergia);

            entityManager.close();
        }

        exchange.sendResponseHeaders(200, 0);
        exchange.getResponseBody().close();
    }
}
