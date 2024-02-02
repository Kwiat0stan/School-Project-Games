package project;

import project.childGames.GameGuess;
import project.childGames.GameOperators;
import project.childGames.GameWord;
import project.parentsGames.GameInterface;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server
{
    static GameInterface games[];
    static String gamesView[] = new String[1000];
    public static void main(String[] args) throws IOException
    {
        // How many games of specific kind.
        // Server.games = new GameGuess[2];
        // Server.games = new GameOperators[2];
        Server.games = new GameWord[2];

        //--------------------------------------------------------------------------
        // Creating objects of this game.
        // Server.games[0] = new GameGuess();
        // Server.games[1] = new GameGuess(1, "Custom game", 10, 15, 50);

        // Server.games[0] = new GameOperators();
        // Server.games[1] = new GameOperators(1, "Custom game", 1, 0.0, 20.0);

        Server.games[0] = new GameWord();
        Server.games[1] = new GameWord(5, "Custom game", 1, 3);
        //----------------------------------------------------------------------------

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0); //localhost:8080/home
        server.createContext("/home", new MyHandler());
        System.out.println(">> Server started");
        server.start();
    }

    static class MyHandler implements HttpHandler
    {
        @Override
        public void handle(HttpExchange exchange) throws  IOException
        {
            String query =  exchange.getRequestURI().getQuery();
            System.out.println(query);
            String parameter[] = new String[2];
            int id = 0;
            String val = "";
            if (query != null) {
                parameter = query.substring(2).split("_");
                id = Integer.parseInt(parameter[0]);
                val = parameter[1];
            }
            System.out.println("Parameter: " + val + " Id: " + id);

            int i = 0;
            for (GameInterface g: Server.games) {
                if (id == i) {
                    Server.gamesView[i] = Server.games[i].nextStep(val);
                } else {
                    Server.gamesView[i] = Server.games[i].nextStep("");
                }
                i++;
            }

            String response = "<html>" +
                    "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">" +
                    "<div class=\"w3-panel w3-red\"><h1>Strona z grami</h1></div>" +
                    "<div class=\"w3-container\" style=\"display: flex; flex-flow: row wrap; justify-content: center;\">";

                    i = 0;
                    for(GameInterface g: Server.games) {
                                response+= "<div class=\"w3-card-4 w3-margin\" style=\"width:300px;\">" +
                                "<div class=\"w3-panel w3-green w3-padding-16\">" + Server.gamesView[i] + "</div>" +
                                "<div class=\"w3-panel w3-blue w3-padding\"><input type=\"text\" id=\"id_" + i + "\"></div>" +
                                "<div class=\"w3-panel w3-blue w3-padding\"><button class=\"w3-button w3-orange w3-round\"  onclick=\"dalej("+ i +")\">Dalej</button></div>" +
                                "</div>";
                                i++;
                                // changed type z number na text
                    }

                    response += "</div>" +
                    "<script>" +
                    "function dalej(i){ " +
                    "var nextUrl = \"/home?n=\" ;" +
                    "var number = i.toString() + \"_\" + document.getElementById(\"id_\"+ i).value; " +
                    "window.location.href = nextUrl + number;" +
                    "}"+
                    "</script>" +
                    "</html>";

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
