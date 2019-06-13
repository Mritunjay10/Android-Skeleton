package in.indilabz.fillip_ecommerce.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Dell on 07-Mar-18.
 */

public class JSONParser {

    private static String value;
    private static volatile JSONParser Instance = null;


    public static JSONArray getArray(String s){

        JSONArray array = null;
        try {
            array =  new JSONArray(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return array;
    }

     public static String getString(String s, String key, int i){

        JSONObject json = null;
        JSONArray array = null;
        try {
            array =  new JSONArray(s);
            json = array.getJSONObject(i);

            value = json.getString(key);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return value;
    }

     public static String getSingleString(String s, String key){

        JSONObject json = null;
        JSONArray array = null;
        try {
            array =  new JSONArray(s);
            json = array.getJSONObject(0);

            value = json.getString(key);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return value;
    }


     public static String getWellFormedName(String value, int max, int min){

        if(value.trim().length()<max){

            return value;
        }
        else {

            String buffer = value.trim().substring(0, min)+"...";

            return buffer;
        }
    }

     public static String getJSONObject(String data, String key) {

        try {

            JSONObject json= new JSONObject(data);
            value = json.getString(key);

        } catch (JSONException e) {

            e.printStackTrace();
        }

        return  value;
    }


     public static String getSingleStringfromObject(String s, String key){

        JSONObject json = null;
        try {
            json = new JSONObject(s);

            value = json.getString(key);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return value;
    }
}
