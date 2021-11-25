package com.webdriver.io.customrunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONExample {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		List<String> modifiedfeatureList = new ArrayList<String>();
		
		try (FileReader reader = new FileReader("src//test//resources//ListOfFeatures.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			// JSONArray featureNames = (JSONArray) obj;
			System.out.println(obj);

			JSONObject jsonObject = (JSONObject) obj;

			// A JSON array. JSONObject supports java.util.List interface.
			JSONArray featureList = (JSONArray) jsonObject.get("Feature Names");

			for (int i = 0; i < featureList.size(); i++) {
				String[] split = featureList.get(i).toString().replace("\"","").split(":");
				
				String string = split[1];
				
				if(string == "yes")
				{
					modifiedfeatureList.add(split[0]);
				}
				
				
			}
			
			System.out.println(modifiedfeatureList);
			
			// An iterator over a collection. Iterator takes the place of Enumeration in the
			// Java Collections Framework.
			// Iterators differ from enumerations in two ways:
			// 1. Iterators allow the caller to remove elements from the underlying
			// collection during the iteration with well-defined semantics.
			// 2. Method names have been improved.
//			Iterator<JSONObject> iterator = companyList.iterator();
//			while (iterator.hasNext()) {
//				
//				JSONObject next = iterator.next();
//				
//				System.out.println(next.toString().split(":")[1]);
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
