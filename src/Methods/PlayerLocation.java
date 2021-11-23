package Methods;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;


public class PlayerLocation {

    public static int userNum;
    public static int teamNum;
    public static void findPlayer(String loc) throws Exception{
        // Finds right player in JSON by Team and Player index.
        InputStream file = new FileInputStream(loc);
        JsonReader jsonReader = Json.createReader(file);
        JsonObject object = (JsonObject) jsonReader.readObject();
        String clientName = object.getString("client_name");
        System.out.println(clientName);


        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 3; b++) {
                String toCheck = "teams[" + a + "].players[" + b + "].name";
                System.out.println(toCheck);
                if (Objects.equals(String.valueOf(object.getString(toCheck)), clientName)) {
                    teamNum = a;
                    userNum = b;
                    System.out.println("Player is on team " + teamNum + ".\nPlayer is number " + userNum + ".");
                }
            }
        }
    }
}
