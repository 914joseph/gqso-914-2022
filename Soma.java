import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

    public class Soma implements HttpHandler{

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
                 System.out.println("Operacao realizada com sucesso");
                 String resul = Float.toString(valor);
                 byte[] resposta = resul.getBytes();
                 exchange.sendResponseHeaders(200, resposta.length);
                 exchange.getResponseBody().write(resposta);
                 return;
                //coment

                
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                exchange.close();
            }
            
        }
            
    }