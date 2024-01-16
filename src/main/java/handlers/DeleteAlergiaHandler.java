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

public class DeleteAlergiaHandler implements HttpHandler {
	public void handle(HttpExchange exchange) throws IOException {
		String method = exchange.getRequestMethod();
		String path = exchange.getRequestURI().getPath();
		String[] pathParts = path.split("/");
		String id = pathParts[pathParts.length - 1];

		if (method.equals("DELETE")) {
			EntityManager entityManager = JPAUtil.getEntityManager();
			AlergiaDAO alergiaDAO = new AlergiaDAO(entityManager);
			Alergia alergia = alergiaDAO.read(Integer.parseInt(id));

			if (alergia != null) {
				alergiaDAO.delete(alergia);
				exchange.sendResponseHeaders(200, 0);
			} else {
				exchange.sendResponseHeaders(404, 0);
			}

			entityManager.close();
			exchange.close();
		}
	} 
}
