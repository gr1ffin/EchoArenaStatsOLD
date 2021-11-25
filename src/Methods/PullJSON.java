package Methods;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

import java.io.FileWriter;

public class PullJSON {
    public static void pullJson() throws Exception {
        // Pulls JSON from API page
        String json = ClientBuilder.newClient().target("http://127.0.0.1:6721/session").request().accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(json);
        FileWriter file = new FileWriter("C:\\Users\\Public\\Documents\\EchoStatsLogger\\stats.json");
        file.write(String.valueOf(json));
        file.close();
    }
}
