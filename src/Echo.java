import javax.json.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class Echo {
    public static void main(String[] args) throws Exception{
        InputStream file = new FileInputStream("src/stats.json");
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();
        jsonReader.close();

        String username = object.getString("client_name");
        System.out.println(username);

        JsonObject lastThrow = object.getJsonObject("last_throw");
        Double throwSpeed = Double.parseDouble(String.valueOf(lastThrow.get("total_speed")));
        System.out.println(throwSpeed);


        JsonArray teamsArray = object.getJsonArray("teams");
        JsonArray identifier = teamsArray.getJsonArray(0);
        JsonArray players = identifier.getJsonArray(3);
        JsonObject playerData = players.getJsonObject(0);
        String playerName = playerData.getString("name");

        System.out.println(playerName);

    }
}
