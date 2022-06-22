import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
public class Main{
    public static void main(String[] args) throws IOException{
        

        InetSocketAddress endereco = new InetSocketAddress(8889);
        HttpServer servidor = HttpServer.create(endereco,10);
        servidor.createContext("/multiplicacao", new Multiplicacao());

        servidor.start();

        System.out.println("Servidor outro iniciado em "+ endereco.getPort());
    }
}

  