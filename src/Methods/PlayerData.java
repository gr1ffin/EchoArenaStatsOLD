package Methods;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.InputStream;



public class PlayerData {

    public static int points = 0;
    public static int stuns = 0;
    public static int saves = 0;
    public static int assists = 0;
    public static String userName;

    public static void getData(String loc, int team, int user) throws Exception {
        // Pulls player Data from JSON
        InputStream file = new FileInputStream(loc);
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();

        userName = object.getString("teams[" + team + "].players[" + user + "].name");
        points = object.getInt("teams[" + team + "].players[" + user + "].stats.points");
        stuns = object.getInt("teams[" + team + "].players[" + user + "].stats.stuns");
        saves = object.getInt("teams[" + team + "].players[" + user + "].stats.saves");
        assists = object.getInt("teams[" + team + "].players[" + user + "].stats.assists");
    }
}