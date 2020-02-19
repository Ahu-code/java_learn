package HeiMa;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSet01 {
	public static void main(String[] args) {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		
		set.add("aab");
		set.add("aab");
		set.add("aad");
		set.add("aac");
		
		System.out.println(set);
		System.out.println("-------------------------"
				+ "");
		
		HashSet<String> hash = new HashSet<String>();
		
		hash.add("aab");
		hash.add("aab");
		hash.add("aad");
		hash.add("aac");
		
		System.out.println(hash);
	}
}	
