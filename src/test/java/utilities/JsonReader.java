package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReader {
    private static JsonNode jsonData;

    static {
        try {
            File file = new File("src/test/resources/testdata/logindata.json");
            ObjectMapper objectMapper = new ObjectMapper();
            jsonData = objectMapper.readTree(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + e.getMessage());
        }
    }

    public static String getValue(String userType, String key) {
        return jsonData.get(userType).get(key).asText();
    }
}
