package handlers;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import javax.persistence.EntityManager;
import com.google.gson.Gson;

import persistence.JPAUtil;
import DAOs.AlergiaDAO;

public class ListAlergiasHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();

        if (requestMethod.equalsIgnoreCase("GET")) {
            EntityManager entityManager = JPAUtil.getEntityManager();
            AlergiaDAO alergiaDAO = new AlergiaDAO(entityManager);

            Gson gson = new Gson();
            String responseBody = gson.toJson(alergiaDAO.readAll());

            exchange.sendResponseHeaders(200, responseBody.getBytes().length);
            exchange.getResponseBody().write(responseBody.getBytes());
            exchange.getResponseBody().close();

            entityManager.close();
        }
    }
}
