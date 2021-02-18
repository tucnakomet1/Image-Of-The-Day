package sample;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public ReadJson(){
    }

    public static String GetElement(String site, FileReader jsonPath) throws IOException, ParseException {
        String element = null;
        JSONParser parser = new JSONParser();

        JSONObject jsonObject = (JSONObject) parser.parse(jsonPath);
        try {
            element = (String) jsonObject.get(site);
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        return element;
    }
}
