package handlers;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListAlergiasPageHandler implements HttpHandler {
	public void handle(HttpExchange exchange) throws IOException {
		byte[] bytes = Files.readAllBytes(Paths.get("./src/html/list-alergias.html"));
		
		exchange.sendResponseHeaders(200, bytes.length);
		OutputStream os = exchange.getResponseBody();
		os.write(bytes);
		os.close();
	}
}
