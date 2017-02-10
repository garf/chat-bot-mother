package libs.parsers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
    private JSONObject jsonObject;

    public JsonParser(String json) throws ParseException {
        JSONParser parser = new JSONParser();
        jsonObject = (JSONObject) parser.parse(json);
    }

    public String getByKey(String key)
    {
        return jsonObject.get(key).toString();
    }

    public JSONObject getObject(String key)
    {
        return jsonObject;
    }
}
