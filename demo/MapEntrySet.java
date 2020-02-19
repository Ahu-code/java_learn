package HeiMa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map 中的一个Entry(项)：一一对应的key(键)与value(值)，Entry 将键值对的对应关系封装成了对象，即键值对对象。
 * 这样我们在遍历Map 集合时，就可以从每一个键值对（ Entry ）对象中获取对应的键与对应的值。
 * 1. 获取Map集合中，所有的键值对(Entry)对象，以Set集合形式返回。方法提示: entrySet() 。
 * 2. 遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象。
 * 3. 通过键值对(Entry)对象，获取Entry对象中的键与值。 方法提示: getkey() getValue()
 */
public class MapEntrySet {
	public static void main(String[] args) {
		Map<String,Integer> map01 = new HashMap<String,Integer>();
		
		map01.put("李晨", 180);
		map01.put("黄晓明", 170);
		map01.put("刘亦菲", 165);
		//1. 获取Map集合中，所有的键值对(Entry)对象，以Set集合形式返回。方法提示: entrySet() 
		Set<Map.Entry<String, Integer>> set = map01.entrySet();
		//2. 遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象。
		//使用迭代器
		Iterator<Map.Entry<String, Integer>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
		//3. 通过键值对(Entry)对象，获取Entry对象中的键与值。 方法提示: getkey() getValue()
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key:"+key+"  value:"+value);
			
			System.out.println("-------------------------------");
			for(Map.Entry<String, Integer> i : set) {
				String key02 = i.getKey();
				Integer value02 = i.getValue();
				System.out.println("key:"+key02+"  value:"+value02);				
			}
		}
	}
}
