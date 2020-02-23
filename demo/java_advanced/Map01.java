package HeiMa;

import java.util.HashMap;
import java.util.Map;

public class Map01 {
/*
 * public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
 * public V remove(Object key) : 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
 * public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
 * public Set<K> keySet() : 获取Map集合中所有的键，存储到Set集合中。
 * public Set<Map.Entry<K,V>> entrySet() : 获取到Map集合中所有的键值对对象的集合(Set集合)。
 */
	public static void main(String[] args) {
		show01();
		System.out.println("---------------------------");
		show02();
	}
	
	/*
	 *  public V put(K key, V value) : 把指定的键与指定的值添加到Map集合中。
	 *  返回值value
	 *  key不重复时，返回value 为 null
	 *  重复时，会拿value替换，返回被替换的value
	 */
	private static void show01() {
		//创建map集合
		Map<String,String> map = new HashMap<String,String>();
		
		String s1 = map.put("李晨", "范冰冰");
		System.out.println("s1:"+s1);
		
		String s2 = map.put("李晨", "范冰冰2");
		System.out.println("s2:"+s2);
		
		System.out.println(map);
		
		map.containsKey("李晨");
		System.out.println(	map.containsKey("李晨"));
	}
	
	//public V remove(Object key)
	//public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
	private static void show02() {
		//创建map集合
		Map<String,Integer> map01 = new HashMap<String,Integer>();
			
		map01.put("李晨", 180);
		map01.put("黄晓明", 170);
		map01.put("刘亦菲", 165);
		System.out.println(map01);
		Integer i1 = map01.remove("刘亦菲");
		System.out.println(i1);

		Integer i2 = map01.get("黄晓明");
		System.out.println(i2);
	}
	
}




