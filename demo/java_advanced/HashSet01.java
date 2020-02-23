package HeiMa;

import java.util.HashSet;

public class HashSet01 {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		String s1 = new String("aaaa");
		String s2 = new String("bbbb");
		
		set.add(s1);
		set.add(s2);
		set.add("重地");
		set.add("通话");
		set.add("cccc");
		System.out.println(set);
	}
}
