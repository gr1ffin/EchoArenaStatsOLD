package WebServer;

import java.net.InetSocketAddress;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import static Methods.Averages.*;
import static Methods.PlayerData.*;
import static Methods.RoundOver.*;

public class CreateServer {
    public static HttpServer server;

    public static void startServer() throws Exception {
        server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/stats", new statsHandler());
        server.createContext("/overlay", new overlayHandler());
        server.createContext("/", new mainHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server has been started at http://localhost:8000/");
    }

    static void restartServer() throws Exception {
        server.stop(1);
        startServer();
    }

    static class statsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = stats1 + stats2 + stats3;
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();

        }
    }

    static class overlayHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = stats3;
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class mainHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "/stats - Stats about the game. \n/overlay - Overlay that display game stats. ";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }


    static String stats1 = "Points: " + points + "\n" + "Assists: " + assists + "\n" + "Saves: " + saves + "\n" + "Stuns: " + stuns + "\n";
    static String stats2 = "\n" + "Points Per Game: " + avgPPG + "\n" + "Assists Per Game: " + avgAPG + "\n" + "Saves Per Game: " + avgSPG + "\n" + "Stuns Per Game: " + avgStPG + "\n" + "\n";
    static String stats3 = "Total Games: " + totalGames + "\n" + "Wins: " + wins + "\n" + "Losses: " + losses + "\n" + "Win Rate: " + winRate;
}