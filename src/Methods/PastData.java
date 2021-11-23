package Methods;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;



public class PastData {
    public static int wins;
    public static int losses;
    public static int totalGames;
    public static float winRate;

    public static int points;
    public static int assists;
    public static int stuns;
    public static int saves;

    public static void getPastData() throws FileNotFoundException {
        InputStream file = new FileInputStream("C:\\Users\\Public\\Documents\\EchoStatsLogger\\continuousStorage.json");
        JsonReader jsonReader = Json.createReaderFactory(null).createReader(file, java.nio.charset.StandardCharsets.UTF_8);
        JsonObject object = jsonReader.readObject();

        wins = object.getInt("Wins");
        losses = object.getInt("Losses");
        totalGames = object.getInt("Total Games");

        points = object.getInt("Points");
        assists = object.getInt("Assists");
        saves = object.getInt("Saves");
        stuns = object.getInt("Stuns");

        jsonReader.close();
    }
}
