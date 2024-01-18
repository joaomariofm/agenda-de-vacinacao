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
import entities.Vacina;
import entities.Usuario;
import DAOs.AgendaDAO;
import DAOs.VacinaDAO;
import DAOs.UsuarioDAO;
import handlers.payloads.CreateAgendaPayload;
import enums.Situacao;
import enums.Periodicidade;

public class CreateAgendaHandler implements HttpHandler {
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
            CreateAgendaPayload payload = gson.fromJson(body, CreateAgendaPayload.class);

            EntityManager entityManager = JPAUtil.getEntityManager();
            AgendaDAO agendaDAO = new AgendaDAO(entityManager);
            VacinaDAO vacinaDAO = new VacinaDAO(entityManager);
            UsuarioDAO usuarioDAO = new UsuarioDAO(entityManager);

            Vacina vacina = vacinaDAO.read(payload.getVacinaId());
            Usuario usuario = usuarioDAO.read(payload.getUsuarioId());

						LocalDate baseDate = LocalDate.parse(payload.getDate());

						for (int i = 0; i < vacina.getDoses(); i++) {
							Agenda agenda = new Agenda(
									baseDate.toString(),
									payload.getHour(),
									Situacao.Agendado,
									payload.getSituationDate(),
									payload.getObservation(),
									vacina,
									usuario
							);

							baseDate = calcularProximaData(baseDate, vacina.getPeriodicity(), vacina.getInterval());

							agendaDAO.create(agenda);
						}

            entityManager.close();
        }

        exchange.sendResponseHeaders(200, 0);
        exchange.getResponseBody().close();
    }

	private LocalDate calcularProximaData(LocalDate baseDate, Periodicidade periodicity, int interval) {
			switch (periodicity) {
				case dias:
					return baseDate.plusDays(interval);
				case semanas:
					return baseDate.plusWeeks(interval);
				case meses:
					return baseDate.plusMonths(interval);
				case anos:
					return baseDate.plusYears(interval);
				default:
					return baseDate;
			}
	}
}
