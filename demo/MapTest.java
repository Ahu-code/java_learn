package HeiMa;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 1. 获取一个字符串对象
 * 2. 创建一个Map集合，键代表字符，值代表次数。
 * 3. 遍历字符串得到每个字符。
 * 4. 判断Map中是否有该键。
 * 5. 如果没有，第一次出现，存储次数为1；如果有，则说明已经出现过，获取到对应的值进行++，再次存储。
 * 6. 打印最终结果
 */
public class MapTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String str = sc.next();
		
		//2. 创建一个Map集合，键代表字符，值代表次数。
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		//3. 遍历字符串得到每个字符。
		for(char c:str.toCharArray()) {
			/* 4. 判断Map中是否有该键。
			 * 5. 如果没有，第一次出现，存储次数为1；
			 * 如果有，则说明已经出现过，获取到对应的值进行++，再次存储。
			 */
			if(map.containsKey(c)) {
				//字符存在
				Integer value = map.get(c);
				value++;
				map.put(c,value);
			}else {
				//字符不存在
				map.put(c, 1);
			}
		}
		
		for(Character key : map.keySet()) {
			Integer value = map.get(key);
			System.out.println("key:"+key+"="+"value:"+value);
		}
		System.out.println(map);
		
	}
}
