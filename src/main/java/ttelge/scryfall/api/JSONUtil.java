package ttelge.scryfall.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Utility class, mostly for dealing with casting JSON objects when they
 * may be null
 * @author ForOhForError
 */

@SuppressWarnings("unused")
public class JSONUtil {
	public static String getStringData(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		Object obj = data.get(key);
		if(obj==null){
			return null;
		}
		return obj.toString();
	}
	
	public static Long getLongData(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		Object obj = data.get(key);
		if(obj==null){
			return null;
		}
		if(obj instanceof Long){
			return (Long)obj;
		}
		return null;
	}
	
	public static Integer getIntData(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		Object obj = data.get(key);
		if(obj==null){
			return null;
		}
		if(obj instanceof Long){
			return ((Long)obj).intValue();
		}
		return null;
	}

	public static Double getDoubleData(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		Object obj = data.get(key);
		if(obj==null){
			return null;
		}
		if(obj instanceof Double){
			return (Double)obj;
		}
		return null;
	}
	
	public static HashMap<String,String> getStringMap(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		Object obj = data.get(key);
		if(obj==null){
			return null;
		}
		
		HashMap<String,String> map = new HashMap<>();
		
		JSONObject o = (JSONObject)obj;
		for(Object k:o.keySet())
		{
			map.put(((String)k).toLowerCase(), (String)o.get(k));
		}
		return map;
	}
	
	public static Boolean getBoolData(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		Object obj = data.get(key);
		if(obj==null){
			return null;
		}
		if(obj instanceof Boolean){
			return (Boolean)obj;
		}
		return null;
	}
	
	public static String[] getStringArrayData(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		Object obj = data.get(key);
		if(obj==null){
			return null;
		}
		
		JSONArray jarr = (JSONArray)obj;
		
		String[] arr = new String[jarr.size()];
		int i = 0;
		for(Object o:jarr)
		{
			arr[i] = (String)o;
			i++;
		}
		return arr;
	}

	public static Integer[] getIntArrayData(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		Object obj = data.get(key);
		if(obj==null){
			return null;
		}
		
		JSONArray jarr = (JSONArray)obj;
		
		Integer[] arr = new Integer[jarr.size()];
		int i = 0;
		for(Object o:jarr)
		{
			arr[i] = (Integer)o;
			i++;
		}
		return arr;
	}
	
	public static Date getIsoDateData(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		String date = getStringData(data,key);
		if(date==null)
		{
			return null;
		}
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static JSONObject getObject(JSONObject data, String key)
	{
		if(data == null)
		{
			return null;
		}
		Object obj = data.get(key);
		if(obj instanceof JSONObject){
			return (JSONObject)obj;
		}
		return null;
	}
}
