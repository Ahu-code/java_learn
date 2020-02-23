package HeiMa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * 1.4 Map集合遍历键找值方式
 * 键找值方式：即通过元素中的键，获取键所对应的值
 * 分析步骤：
 * 1. 获取Map中所有的键，由于键是唯一的，所以返回一个Set集合存储所有的键。方法提示: keyset()
 * 2. 遍历键的Set集合，得到每一个键。
 * 3. 根据键，获取键所对应的值。方法提示: get(K key)
 */
public class Map02 {
	public static void main(String[] args) {
		Map<String,Integer> map01 = new HashMap<String,Integer>();
		
		map01.put("李晨", 180);
		map01.put("黄晓明", 170);
		map01.put("刘亦菲", 165);
		
		//，所以返回一个Set集合存储所有的键。方法提示: keyset()
		Set<String> set = map01.keySet();
		
		//使用迭代器遍历
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Integer value = map01.get(key);
			System.out.println(value);
		}
		
		//增强for循环
		
		for(String s: set) {
			Integer it01 = map01.get(s);
			System.out.println(it01);
		}
	}
}
