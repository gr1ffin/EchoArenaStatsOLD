import Methods.ImportJSON;

import javax.json.*;
import java.io.FileInputStream;
import java.io.InputStream;


import static Methods.Averages.avgFinder;
import static Methods.PlayerData.*;
import static Methods.PlayerLocation.*;
import static Methods.RoundOver.onRoundEnd;
import static Methods.RoundOver.totalGames;
import static Methods.ImportJSON.*;

public class EchoMain {
    public static String clientName;

    public static void main(String[] args) throws Exception{

        InputStream file = new FileInputStream(flattenLocation);
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();
        jsonReader.close();


        clientName = object.getString("client_name");
        System.out.println(clientName);

        // Call Methods
        findPlayer(flattenLocation);
        getData(flattenLocation, teamNum, userNum);
        onRoundEnd(flattenLocation, teamNum);
        avgFinder(points, assists, stuns, saves, totalGames);
    }
}


