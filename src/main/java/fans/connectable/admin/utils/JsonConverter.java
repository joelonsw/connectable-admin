package fans.connectable.admin.utils;

import org.json.JSONObject;

public class JsonConverter {

    private JsonConverter() {
    }

    public static JSONObject stringToJson(String target) {
        return new JSONObject(target);
    }
}
