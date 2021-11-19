import javax.json.*;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.Map;
import java.util.Objects;

public class Echo {
    public static int userNum;
    public static int teamNum;

    public static void main(String[] args) throws Exception{

        InputStream file = new FileInputStream(ImportJSON.flattenLocation);
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();
        jsonReader.close();


        String clientName = object.getString("client_name");
        String userName = object.getString("teams[0].players[0].name");
        System.out.println(clientName);
        System.out.println(userName);
        findPlayer();
        getData(teamNum, userNum);


    }
    public static void findPlayer() throws Exception{
        InputStream file = new FileInputStream(ImportJSON.flattenLocation);
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();
        String clientName = object.getString("client_name");


        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 4; b++) {
                String toCheck = "teams[" + a + "].players[" + b + "].name";
                if (Objects.equals(String.valueOf(object.getString(toCheck)), object.getString("client_name"))) {
                    teamNum = a;
                    userNum = b;
                    System.out.println("Player is on team " + teamNum + ".\nPlayer is number " + userNum + ".");
                    System.out.println(toCheck);
                }
            }


        }

    }

    public static int points = 0;
    public static int stuns = 0;
    public static int saves = 0;
    public static int assists = 0;

    public static void getData(int team, int user) throws Exception {
        InputStream file = new FileInputStream(ImportJSON.flattenLocation);
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();

        points = object.getInt("teams[" + team + "].players[" + user + "].stats.points");
        stuns = object.getInt("teams[" + team + "].players[" + user + "].stats.stuns");
        saves = object.getInt("teams[" + team + "].players[" + user + "].stats.saves");
        assists = object.getInt("teams[" + team + "].players[" + user + "].stats.assists");
    }

    public static int wins = 0;
    public static int losses = 0;
    public static int totalGames = 0;
    public static float winRate;

    public static void onRoundEnd (int team) throws Exception {
        InputStream file = new FileInputStream(ImportJSON.flattenLocation);
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();
        String userTeam;

        if (team == 0) {
            userTeam = "BLUE";
            if (object.getInt("blue_points") > object.getInt("orange_points")) {
                wins += 1;
            }
            else {
                losses += 1;
            }
            totalGames +=1;
        }
        else if (team == 1) {
            userTeam = "ORANGE";
            if (object.getInt("blue_points") < object.getInt("orange_points")) {
                wins += 1;
            }
            else {
                losses += 1;
            }
            totalGames +=1;
        }
        else {
            userTeam = "SPECTATOR";
        }
        winRate = (float) ((wins*100)/totalGames);
    }
}

