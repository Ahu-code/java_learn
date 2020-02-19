package HeiMa;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * 1:of()方法只是Map，List，Set这三个接口的静态方法，其父类接口和子类实现并没有这类方法，比如HashSet，ArrayList等等；
 * 2:返回的集合是不可变的，集合不能再使用add,put方法添加元素
 * 3:Set接口和Map接口在调用of方法时，不能有重复元素，否则会抛出异常
 */
public class JDK9_01 {
	public static void main(String[] args) {
		List<String> list = List.of("a","c","b","d","d");;
		System.out.println(list);
		//list.add("s");//java.lang.UnsupportedOperationException不支持操作异常
		
		/*Set<String> set = Set.of("a","c","b","d","d");
		IllegalArgumentException   非法参数异常，不能添加重复元素*/
		Set<String> set = Set.of("a","c","b","d");
		System.out.println(set);
		
		Map<String, Integer> map = Map.of("a",1,"b",2,"c",3);
		System.out.println(map);
		//map.put("c", 3);
		
	}
}
