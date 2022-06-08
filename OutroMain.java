import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
public class OutroMain{
    public static void main(String[] args) throws IOException{
        

        InetSocketAddress endereco = new InetSocketAddress(8889);
        HttpServer servidor = HttpServer.create(endereco,10);
        servidor.createContext("/", new IndexHandler());
        servidor.createContext("/bemchato", new TuqueEh());

        servidor.start();



        System.out.println("Servidor outro iniciado em "+ endereco.getPort());
    }

    static class IndexHandler implements HttpHandler{

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
    static class TuqueEh implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try{
                String[] partes = exchange.getRequestURI().getPath().split("/");
                if(partes[2].equals("java")){
                    byte[] resposta = "sou n cara".getBytes();
                    exchange.sendResponseHeaders(200, resposta.length);
                    exchange.getResponseBody().write(resposta);
                    return;
                }
                
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                exchange.close();
            }
            
        }
            
    }
}