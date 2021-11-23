package Methods;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import static Methods.Averages.avgFinder;
import static Methods.ChangeMonitor.fileMonitor;
import static Methods.ContinuousStorage.continuousMethod;
import static Methods.FlattenJSON.*;
import static Methods.PlayerData.*;
import static Methods.PlayerLocation.*;
import static Methods.RoundOver.onRoundEnd;
import static Methods.WebServer.CreateServer.*;
import static Methods.InitialStorage.createStorage;
import static Methods.PastData.*;

public class EchoMain {
    public static String clientName;

    public static void main(String[] args) throws Exception {
        initialMethod();
    }

    public static void initialMethod() throws Exception{
        // Call Methods
        //pullJson();
        createStorage();
        flattenJSON(jsonLocation, flattenLocation);
        findPlayer(flattenLocation);
        getPastData();
        getData(flattenLocation, teamNum, userNum);
        onRoundEnd(flattenLocation, teamNum);
        avgFinder(points, assists, stuns, saves, totalGames);
        continuousMethod();
        startServer();
        TimeUnit.SECONDS.sleep(10);
        fileMonitor();

        InputStream file = new FileInputStream(flattenLocation);
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();
        jsonReader.close();


        clientName = object.getString("client_name");
        System.out.println(clientName);

    }
}


