package Methods;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import java.io.FileWriter;

import static Methods.Averages.*;
import static Methods.PlayerData.*;
import static Methods.RoundOver.*;
import static Methods.PastData.*;

public class ContinuousStorage {
    public static String continuousLocation = "C:\\Users\\Public\\Public Documents\\EchoStatsLogger\\continuousStorage.json";
    public static void continuousMethod() throws Exception{
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("Points", points);
        jsonBuilder.add("Assists", assists);
        jsonBuilder.add("Saves", saves);
        jsonBuilder.add("Stuns", stuns);

        jsonBuilder.add("PPG", avgPPG);
        jsonBuilder.add("APG", avgAPG);
        jsonBuilder.add("SPG", avgSPG);
        jsonBuilder.add("StPG", avgStPG);

        jsonBuilder.add("Total Games", totalGames);
        jsonBuilder.add("Wins", wins);
        jsonBuilder.add("Losses", losses);
        jsonBuilder.add("Win Rate", winRate);

        JsonObject statsObj = jsonBuilder.build();


        FileWriter file = new FileWriter(continuousLocation);
        file.write(String.valueOf(statsObj));
        file.close();
    }
}
