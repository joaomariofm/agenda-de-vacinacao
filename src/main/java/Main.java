import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

import handlers.*;

public class Main {
	public static void main(String[] args) throws Exception {
		try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            server.createContext("/create-user", new CreateUsuarioHandler());
            server.createContext("/create-allergy", new CreateAlergiaHandler());
            server.createContext("/create-vaccine", new CreateVacinaHandler());
            server.createContext("/create-appointment", new CreateAgendaHandler());

            server.createContext("/list-users", new ListUsuariosHandler());
            server.createContext("/list-allergies", new ListAlergiasHandler());
            server.createContext("/list-vaccines", new ListVacinasHandler());
            server.createContext("/list-appointments", new ListAgendasHandler());

            server.start();

            System.out.println("Server started on port 8080");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
	}
}