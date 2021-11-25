package Methods;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static Methods.ContinuousStorage.continuousLocation;


public class InitialStorage {
    public static void createStorage() throws IOException {
        Path path = Paths.get("C:\\Users\\Public\\Documents\\EchoStatsLogger\\continuousStorage.json");
        Path path2 = Paths.get("C:\\Users\\Public\\Documents\\EchoStatsLogger\\stats.json");
        Path path3 = Paths.get("C:\\Users\\Public\\Documents\\EchoStatsLogger\\flattened.json");

        try {
            Files.createFile(path);
            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
            jsonBuilder.add("Points", 0);
            jsonBuilder.add("Assists", 0);
            jsonBuilder.add("Saves", 0);
            jsonBuilder.add("Stuns", 0);

            jsonBuilder.add("PPG", 0);
            jsonBuilder.add("APG", 0);
            jsonBuilder.add("SPG", 0);
            jsonBuilder.add("StPG", 0);

            jsonBuilder.add("Total Games", 0);
            jsonBuilder.add("Wins", 0);
            jsonBuilder.add("Losses", 0);
            jsonBuilder.add("Win Rate", 0);
            JsonObject newStatsObj = jsonBuilder.build();

            FileWriter file = new FileWriter(continuousLocation);
            file.write(String.valueOf(newStatsObj));
            file.close();


        } catch (FileAlreadyExistsException ex ) {
            System.out.println("File Already Exists");
        }
        try {
            Files.createFile(path2);
        } catch (FileAlreadyExistsException ex) {
            System.out.println("File already Exists");
        }
        try {
            Files.createFile(path3);
        } catch (FileAlreadyExistsException ex) {
            System.out.println("File already Exists");
        }


    }
}
