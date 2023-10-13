package apiChecks;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.ExtentReportITestListner;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonDataValidation extends ExtentReportITestListner {

    public static void JsonDataValidation(Response res , String Key){
        JsonPath jsonpath = new JsonPath(res.getBody().asString());
        if(jsonpath.get() instanceof Map){
            JSONObject object = new JSONObject(res.getBody().asString());
            dynamicJsonKeyValidation(object, Key);

        } else if (jsonpath.get() instanceof List) {

            JSONArray outerarray = new JSONArray(res.getBody().asString());
            for(int i=0;i<outerarray.length();i++){
                JSONObject jsonObject = outerarray.getJSONObject(i);
                dynamicJsonKeyValidation(jsonObject, Key);
            }
        }

    }

    public static void parsedynamicJSON(JSONObject obj, String Key) {

        extentTest.pass(MarkupHelper.createLabel("Response Key Validated", ExtentColor.GREEN));
        extentTest.log(Status.PASS, "Key : "+Key+ " <br/> Value : "+obj.get(Key));
    }

    public static void dynamicJsonKeyValidation(JSONObject JSONobj, String Key) {
        Boolean keyExists;
        String outerkey;

        keyExists = JSONobj.has(Key);
        // IF KEY DOES NOT EXIST IN OUTTER AREA

        if (!keyExists) {
            Iterator<?> keyset = JSONobj.keys();
            while (keyset.hasNext()) {
                outerkey = (String) keyset.next();
                if (JSONobj.get(outerkey) instanceof JSONObject) {
                    if (keyExists == false) {
                        dynamicJsonKeyValidation(JSONobj.getJSONObject(outerkey), Key);
                    }

                } else if (JSONobj.get(outerkey) instanceof JSONArray) {

                    JSONArray array = JSONobj.getJSONArray(outerkey);
                    for (int i=0;i<array.length();i++) {
                        JSONObject innerobj = array.getJSONObject(i);
                        if(keyExists ==false) {
                            dynamicJsonKeyValidation(innerobj, Key);
                        }
                    }
                }
            }

        }

        // IF KEY EXISTS IN OUTER AREA
        else if (keyExists) {
            parsedynamicJSON(JSONobj, Key);
        }

    }
}
