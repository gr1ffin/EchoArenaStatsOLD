import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class main {
    public static String userName;
    public static Object obj;
    public static JSONObject jo;
    public static JSONArray teams;
    public static JSONObject players;
    public static ArrayList<Double> throwData = new ArrayList<>();

    /*public static void ignore(String[] args) throws Exception {
        obj = new JSONParser().parse(new FileReader("C:\\Users\\agent\\IdeaProjects\\EchoArenaStats\\src\\stats.json"));
        jo = (JSONObject) obj;
        userName = (String) jo.get("client_name");
        teams = (JSONArray) jo.get("teams");
        players = (JSONObject) teams.get(1, players);
        System.out.println(players);



    }*/





    /*  obj = new JSONParser().parse(new FileReader("C:\\Users\\agent\\IdeaProjects\\EchoArenaStats\\src\\stats.json"));
        jo = (JSONObject) obj;
        userName = (String) jo.get("client_name");
        JSONObject lastThrow = (JSONObject) jo.get("last_throw");
        String totalSpeed = String.valueOf(lastThrow.get("total_speed"));*/
}
