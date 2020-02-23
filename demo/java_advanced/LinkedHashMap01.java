package HeiMa;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMap01 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("d", "a");
		map.put("b", "c");
		map.put("b", "d");
		map.put("a", "d");
		System.out.println(map);
		
		LinkedHashMap<String, String> map02 = new LinkedHashMap<String, String>();
		map02.put("d", "a");
		map02.put("b", "c");
		map02.put("b", "d");
		map02.put("a", "d");
		System.out.println(map02);
		
	}
}
