package project;

// Necessary components to build http server.
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server 
{
    // Add interface later.

    public static void main(String[] args) throws IOException
    {
     HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
     server.createContext("/home", new MyHandler());
     System.out.println("------- Server started -------");
     server.start();
    }
    static class MyHandler implements HttpHandler
    {
        @Override
        public void handle(HttpExchange exchange) throws IOException
        {
            String query = exchange.getRequestURI().getQuery();
            System.out.println(query);

            // Add "param" code.
            // Add "view" code and "nextStep".

            String response = "<html>" +
                            "<head><title> Server </title></head>" +
                            "<body></body>" +
                            "</html>";

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
