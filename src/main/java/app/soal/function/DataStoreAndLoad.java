package app.soal.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DataStoreAndLoad {

	public static final String KEY = "KEY";
	public static final String VALUE = "VALUE";
	
	@SuppressWarnings("unchecked")
	public static final Map<String, String>[] sampleDataArray(){
		Map<String, String>[] array = new HashMap[10];

		for (int j = 0; j < 10; j++) {
			Map<String, String> map = new HashMap<>();
			for (int i = 1; i <= 2; i++) {
				map.put(KEY + j+i, VALUE + j+i);
			}
			array[j] = map;
		}
		return array;
	}

	@SuppressWarnings("unchecked")
	public static Map<String,String>[] load(String deserialized) {
		List<Map<String, String>> deserializedList = new ArrayList<>();
		String [] sDeserialized = deserialized.split(Pattern.quote("\\n"));
		for (String string : sDeserialized) {
			Map<String, String> map = new HashMap<>();
			String[] split = string.split(Pattern.quote(";"));
			for (String x : split) {
				String[] xval = x.split(Pattern.quote("="));
				map.put(xval[0], xval[1]);
			}
			deserializedList.add(map);
		}
		Map<String, String>[] itemsArray = new HashMap[deserializedList.size()];
		return deserializedList.toArray(itemsArray);
	}
	
	public static String store(Map<String,String>[] array) {
		StringBuilder result = new StringBuilder();
		for (Map<String, String> map : array) {
			int i = 1;
			for (Map.Entry<String, String> entry : map.entrySet()) {
				result.append(entry.getKey()).append("=").append(entry.getValue());
				if (i == map.entrySet().size()) {
					result.append("\\n");
				} else {
					result.append(";");
				}
				i++;
			}
		}
		return result.toString();
		
	}
}
