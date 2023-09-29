package utils;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class dynamicJsonValidation {

	public static void parsedynamicJSON(JSONObject obj, String Key) {

		System.out.println("Key validated ::" + Key + " Value of Key is :: " + obj.get(Key));
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
