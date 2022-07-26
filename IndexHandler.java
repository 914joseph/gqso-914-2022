import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;   

public class IndexHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                byte[] resposta = "<h1>Verdade é ate que aceitavel</h1>".getBytes();
                OutputStream corpoResposta = exchange.getResponseBody();
                exchange.sendResponseHeaders(200, resposta.length);
                corpoResposta.write(resposta);
            }finally{
                exchange.close();
            }
            
        }

    }
