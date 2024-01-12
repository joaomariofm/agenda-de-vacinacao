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
import entities.Usuario;
import entities.Alergia;
import DAOs.UsuarioDAO;
import DAOs.AlergiaDAO;
import handlers.payloads.CreateUsuarioPayload;

public class CreateUsuarioHandler implements HttpHandler {
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
            CreateUsuarioPayload payload = gson.fromJson(body, CreateUsuarioPayload.class);

            Usuario usuario = new Usuario(
                payload.getName(),
                payload.getBirthDate(),
                payload.getSexo(),
                payload.getStreet(),
                payload.getNumber(),
                payload.getSector(),
                payload.getCity(),
                payload.getUf()
            );

            EntityManager entityManager = JPAUtil.getEntityManager();
            UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);
            AlergiaDAO alergiaDAO = new AlergiaDAO(entityManager);

            usuarioDAO.create(usuario);

            for (int alergiaId : payload.getAlergias()) {
                Alergia alergia = alergiaDAO.read(alergiaId);

                usuario.addAlergia(alergia);
            }

            usuarioDAO.update(usuario);

            entityManager.close();
        }

        exchange.sendResponseHeaders(200, 0);
        exchange.getResponseBody().close();
    }
}
