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
        servidor.createContext("/sla", new TuqueEh());
        servidor.createContext("/soma", new Soma());

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
                 float num1 = Float.parseFloat(partes[3]);
                 float num2 = Float.parseFloat(partes[4]);
                 
                //if(partes[2].equals("/")){
                    byte[] resposta = "sou n cara".getBytes();
                    exchange.sendResponseHeaders(200, resposta.length);
                    exchange.getResponseBody().write(resposta);
                    return;
                //}

                
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                exchange.close();
            }
            
        }
            
    }
    static class Soma implements HttpHandler{

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try{
                String[] partes = exchange.getRequestURI().getPath().split("/");
                for (String string : partes) {
                    System.out.println(string);
                }
                 float num1 = Float.parseFloat(partes[2]);
                 float num2 = Float.parseFloat(partes[3]);
                 float valor = num1+num2;
                 String vvalor = Float.toString(valor);
               // if(partes[2].equals("/")){
                   // byte[] resposta = "sou n cara".getBytes();
                    byte[] resposta = vvalor.getBytes();
                    exchange.sendResponseHeaders(200, resposta.length);
                    exchange.getResponseBody().write(resposta);
                    
                    return;
                //}

                
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                exchange.close();
            }
            
        }
            
    }
}