import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.function.Supplier;

public class Server {
    private static Model model = new Model();

    public static void main(String[] args) throws IOException {
        //Cria o servidor HTTP na porta 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        //criando rotas
        server.createContext("/model", handle(() -> model.toJson()));
        server.createContext("/step", handle(() -> {
            model.executarPasso();
            return model.toJson();
        }));
        server.createContext("/reset", handle(() -> {
            model.resetar();
            return model.toJson();
        }));

        server.start();
        System.out.println("Servidor iniciado na porta 8000");
    }

    // Metodo que cria um HttpHandler para responder requisições HTTP
    private static com.sun.net.httpserver.HttpHandler handle(Supplier<String> responseSupplier) {
        return exchange -> {
            String response = responseSupplier.get();
            exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        };
    }
}
