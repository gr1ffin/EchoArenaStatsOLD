package Methods;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.InputStream;

import static Methods.PastData.*;



public class PlayerData {

    public static int recentPoints = 0;
    public static int recentStuns = 0;
    public static int recentSaves = 0;
    public static int recentAssists = 0;
    public static String userName;

    public static void getData(String loc, int team, int user) throws Exception {
        // Pulls player Data from JSON
        InputStream file = new FileInputStream(loc);
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();


        if (object.getString("teams[" + team + "].players[" + user + "].name") != null) {
            userName = object.getString("teams[" + team + "].players[" + user + "].name");
            System.out.println(userName);
            recentPoints = object.getInt("teams[" + team + "].players[" + user + "].stats.points");
            recentStuns = object.getInt("teams[" + team + "].players[" + user + "].stats.stuns");
            recentSaves = object.getInt("teams[" + team + "].players[" + user + "].stats.saves");
            recentAssists = object.getInt("teams[" + team + "].players[" + user + "].stats.assists");
        }


        System.out.println(userName);
        System.out.println(recentPoints);
        System.out.println(recentStuns);
        System.out.println(recentSaves);
        System.out.println(recentAssists);

        points += recentPoints;
        stuns += recentStuns;
        saves += recentSaves;
        assists += recentAssists;
    }
}