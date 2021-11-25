package Methods;

import com.github.wnameless.json.flattener.JsonFlattener;

import java.io.*;
import java.util.Map;

public class FlattenJSON {
    // Flattens JSON from arrays/nested into objects.
    public static String jsonLocation = "C:\\Users\\Public\\Public Documents\\EchoStatsLogger\\stats.json";
    public static String flattenLocation = "C:\\Users\\Public\\Public Documents\\EchoStatsLogger\\flattened.json";
    public static void flattenJSON(String initial, String writeTo) throws Exception {
        InputStream inputStream = new FileInputStream(initial);
        Reader reader = new InputStreamReader(inputStream);

        JsonFlattener jf = new JsonFlattener(reader);
        String str = String.valueOf(jf);
        String newStr = removeChars(str);

        Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(newStr);
        FileWriter file = new FileWriter(writeTo);
        file.write(String.valueOf(flattenJson));
        file.close();



    }

    public static String removeChars(String str) {
        str = str.substring(21, str.length()-1);

        return str;
    }

}
