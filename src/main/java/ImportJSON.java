import com.github.wnameless.json.flattener.JsonFlattener;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import java.io.*;
import java.util.Map;

public class ImportJSON {
    public static String jsonLocation = "C:\\Users\\agent\\IdeaProjects\\EchoArenaStats\\src\\main\\java\\stats.json";
    public static String flattenLocation = "C:\\Users\\agent\\IdeaProjects\\EchoArenaStats\\src\\main\\java\\flattened.json";
    public static void importJSON() throws Exception {
        InputStream inputStream = new FileInputStream(jsonLocation);
        Reader reader = new InputStreamReader(inputStream);

        JsonFlattener jf = new JsonFlattener(reader);
        String str = String.valueOf(jf);
        String newStr = removeChars(str);

        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(newStr);
        FileWriter file = new FileWriter(flattenLocation);
        file.write(String.valueOf(flattenJson));
        file.close();



    }

    public static String removeChars(String str) {
        str = str.substring(21, str.length()-1);

        return str;
    }

}
