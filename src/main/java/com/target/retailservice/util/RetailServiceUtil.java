package com.target.retailservice.util;

import com.jayway.jsonpath.JsonPath;

public class RetailServiceUtil {
	
	public static String getValueByJsonPath(String jsonString, String jsonPath) {
		return JsonPath.read(jsonString, jsonPath);
	}

}
