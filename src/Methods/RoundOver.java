package Methods;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.InputStream;


import static Methods.PastData.*;


public class RoundOver {


    
        public static void onRoundEnd (String loc, int team) throws Exception {
            InputStream file = new FileInputStream(loc);
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
            winRate = (float) ((wins*100)/totalGames); // Win Rate Calculation
        }
}
