package HeiMa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * ·准备牌：完成数字与纸牌的映射关系：
 * 使用双列Map（HashMap）集合，完成一个数字与字符串纸牌的对应关系（相当于一个字典）。
 * LinkedHashMap<Integer，String>值为扑克牌    键为牌编号
 * ·洗牌：Arraylist<Integer>记录54个牌的编号通过数字完成洗牌发牌
 * Collections.shuffle（List list）
 * ·发牌：将每个人以及底牌设计为ArrayList<String>，将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。
 * 发牌：发的是牌的编号
 * 存放的过程中要求数字大小与斗地主规则的大小对应。将代表不同纸牌的数字分配给不同的玩家与底牌。
 * ·看牌：
 * 通过Map集合找到对应字符展示。通过牌的编号，去Map集合中，查询对应编号的扑克牌
 * 通过查询纸牌与数字的对应关系，由数字转成纸牌字符串再进行展示。
 * 把查询到的扑克牌存储到ArrayLists String>
 */
public class Doudizhu02 {
	public static void main(String[] args) {
		//1.洗牌
		//使用双列Map（HashMap）集合，完成一个数字与字符串纸牌的对应关系（相当于一个字典）
		HashMap<Integer, String> poker = new HashMap<Integer, String>();
		//创建一个List集合，存储牌的索引
		ArrayList<Integer> pokerIndex = new ArrayList<Integer>();
		//定义两个集合，分别存储花色和序号
		List<String> colors = List.of("♠","♥","♣","♦");
		List<String> numbers = List.of("2","A","K","Q","J","10","9","8","7","6","5","4","3");
		//存储大王与小王到集合中
		//定义牌的索引
		int index = 0;
		poker.put(index, "大王");
		pokerIndex.add(index);
		index++;
		poker.put(index, "小王");
		pokerIndex.add(index);
		index++;
		for(String number: numbers)
		for(String color: colors) {
				poker.put(index, color+number);
				pokerIndex.add(index);
				index++;
			}
		
		//2.洗牌
		//使用Collections的shuffle
		Collections.shuffle(pokerIndex);
		//System.out.println(pokerIndex);
		
		//3.发牌
		//定义4个集合，存储各个索引
		ArrayList<Integer> player01 = new ArrayList<Integer>();
		ArrayList<Integer> player02 = new ArrayList<Integer>();
		ArrayList<Integer> player03 = new ArrayList<Integer>();
		ArrayList<Integer> dipai = new ArrayList<Integer>();
		
		//存储每一个牌的索引
		for (int i = 0; i < pokerIndex.size(); i++) {
			Integer in = pokerIndex.get(i);
			//先判断底牌
			if(in>=51)
				dipai.add(in);
			else if(i%3==0)
				player01.add(in);
			else if(i%3==1)
				player02.add(in);
			else if(i%3==2)
				player03.add(in);
		}
		
		//排序
		//使用Collections中的sort方法  默认是升序排序
		Collections.sort(player01);
		Collections.sort(player02);
		Collections.sort(player03);
		Collections.sort(dipai);
		
		/*
		 * 定义一个看牌方法，提高代码复用性
		 * 参数：String name:玩家名称
		 * 		hashMap< 存储牌的poker集合
		 * 		ArrayList  存储玩家和底牌的list集合
		 * 查表法：
		 * 		遍历玩家或者底牌集合，获得索引
		 * 		根据索引去找对应牌
		 */
		
		//看牌
		lookPoker("浩哥", poker, player01);
		lookPoker("迅宝", poker, player02);
		lookPoker("小宇", poker, player03);
		lookPoker("底牌", poker, dipai);
	}
	
	public static void lookPoker(String name, HashMap<Integer,String> poker, ArrayList<Integer> list) {
		System.out.print(name+" :");
		
		for(Integer key: list) {
			String value = poker.get(key);
			System.out.print(value+" ");
		}
		System.out.println();//换行
	}
}
