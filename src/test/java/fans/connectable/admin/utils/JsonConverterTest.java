package fans.connectable.admin.utils;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class JsonConverterTest {

    private final String metadataSample = "{\"name\":\"조엘 콘서트 #2\",\"description\":\"조엘의 콘서트 at Connectable\",\"image\":\"https://connectable-events.s3.ap-northeast-2.amazonaws.com/ticket_test2.png\",\"attributes\":[{\"trait_type\":\"Artist\",\"value\":\"Joel\"},{\"trait_type\":\"Seat\",\"value\":\"A5\"},{\"trait_type\":\"Background\",\"value\":\"Yellow\"}]}";

    @Test
    void convert() {
        JSONObject jsonObject = JsonConverter.stringToJson(metadataSample);
        System.out.println("jsonObject = " + jsonObject);
    }
}
