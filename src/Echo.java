import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Echo {
    public static String userName;
    public static ArrayList<Double> throwData = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Object obj = new JSONParser().parse(new FileReader("stats.json"));
        JSONObject jo = (JSONObject) obj;

        userName = (String) jo.get("client_name");
        System.out.println(userName);

    }

    /*public static void getCorrectName() throws Exception {
        Object obj = new JSONParser().parse(new FileReader("stats.json"));
        JSONObject jo = (JSONObject) obj;

        if jo.get(players.name)
    }*/
}
