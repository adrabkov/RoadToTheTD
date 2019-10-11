package utils;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonToOdjects {

    public static <T> T mapToObject(String filePath, Class<T> targetClass) {
        JSONObject jsonObject = readFromFile(filePath);
        return new Gson().fromJson(jsonObject.toJSONString(), targetClass);
    }

    private static JSONObject readFromFile(String filePath) {
        JSONObject data = null;
        try {
            data = (JSONObject) new JSONParser().parse(new FileReader(filePath));
        } catch (IOException | ParseException e) {
            System.err.println(e);
        }
        return data;
    }
}
