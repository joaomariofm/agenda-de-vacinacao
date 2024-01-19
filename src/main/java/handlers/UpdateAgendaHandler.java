package handlers;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import com.google.gson.Gson;
import java.time.LocalDate;

import persistence.JPAUtil;
import entities.Agenda;
import enums.Situacao;
import handlers.payloads.UpdateAgendaPayload;
import DAOs.AgendaDAO;

public class UpdateAgendaHandler implements HttpHandler {
	public void handle(HttpExchange exchange) throws IOException {
		String method = exchange.getRequestMethod();
		String path = exchange.getRequestURI().getPath();
		String id = path.split("/")[2];

		if (method.equals("PUT")) {
			String body = new BufferedReader(
				new InputStreamReader(
					exchange.getRequestBody(),
					"utf-8"
				)
			).lines().collect(Collectors.joining("\n"));

			Gson gson = new Gson();
			UpdateAgendaPayload payload = gson.fromJson(body, UpdateAgendaPayload.class);

			EntityManager entityManager = JPAUtil.getEntityManager();
			AgendaDAO agendaDAO = new AgendaDAO(entityManager);
			Agenda agenda = agendaDAO.read(Integer.parseInt(id));

			LocalDate date = LocalDate.now();

			agenda.setSituationDate(date.toString());

			if (payload.getSituation().equals("Cancelado")) {
				agenda.setSituation(Situacao.Cancelado);
			} else if (payload.getSituation().equals("Realizado")) {
				agenda.setSituation(Situacao.Realizado);
			}

			agendaDAO.update(agenda);
				
			entityManager.close();
		}

		exchange.sendResponseHeaders(200, 0);
		exchange.getResponseBody().close();
	} 
}
