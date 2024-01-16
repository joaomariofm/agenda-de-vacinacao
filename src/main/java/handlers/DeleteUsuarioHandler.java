package handlers;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import javax.persistence.EntityManager;

import persistence.JPAUtil;
import entities.Usuario;
import DAOs.UsuarioDAO;

public class DeleteUsuarioHandler implements HttpHandler {
	public void handle(HttpExchange exchange) throws IOException {
		String method = exchange.getRequestMethod();
		String path = exchange.getRequestURI().getPath();
		String[] pathParts = path.split("/");
		String id = pathParts[pathParts.length - 1];

		if (method.equals("DELETE")) {
			EntityManager entityManager = JPAUtil.getEntityManager();
			UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);
			Usuario usuario = usuarioDAO.read(Integer.parseInt(id));

			if (usuario != null) {
				usuarioDAO.delete(usuario);
				exchange.sendResponseHeaders(200, 0);
			} else {
				exchange.sendResponseHeaders(404, 0);
			}

			entityManager.close();
			exchange.close();
		}
	} 
}
