package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfig {
	
	public static Map<String, String> defaultHeader() {
		
		Map<String, String>defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		defaultHeaders.put("Accept", "application/json");
		return defaultHeaders;
	}
	
	/*
	public static Map<String, String> headersWithAuth() {
		Map<String, String>headersWithAuth = new HashMap<String, String>();
		headersWithAuth.put("Content-Type", "application/json");
		headersWithAuth.put("Accept", "application/json");
		headersWithAuth.put("Authorization", "123456");
		return headersWithAuth;
	}
	*/

}
