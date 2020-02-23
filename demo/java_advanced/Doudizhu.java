package HeiMa;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 斗地主案例
 */
public class Doudizhu {
	public static void main(String[] args) {
		/*
		 * 1.准备牌 
		 * 定义一个存储54张牌的ArrayList集合，泛型使用String
		 */
		ArrayList<String> poker = new ArrayList<String>();
		//定义两数组 一个存储花色 一个存序号
		String[] colors = {"♠","♥","♣","♦"};
		String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
		//存储大王小王
		poker.add("大王");
		poker.add("小王");

		//循环嵌套遍历
		for(String number:numbers)
			for (String color : colors)
				poker.add(color+number);
		//System.out.println(poker);
		
		/*
		 * 2.洗牌
		 * 使用Collections 中的Shuffle
		 */
		Collections.shuffle(poker);
		//System.out.println(poker);
		
		/*
		 * 3.发牌
		 * 定义四个集合，存储玩家的牌和底牌
		 */
		ArrayList<String> player01 = new ArrayList<String>();
		ArrayList<String> player02 = new ArrayList<String>();
		ArrayList<String> player03 = new ArrayList<String>();
		ArrayList<String> dipai = new ArrayList<String>();
		
		/*
		 * 遍历poker集合 获取每一张牌
		 * 使用poker集合的索引%3给玩家轮流发牌
		 * 剩余3张牌给底牌
		 * 先判断牌是否发没
		 */
		for(int i=0; i<poker.size(); i++)
		{
			String s = poker.get(i);
			if(i>=51) {
				dipai.add(s);
			} else if(i%3==0) {
				player01.add(s);
			} else if(i%3==1) {
				player02.add(s);
			} else if(i%3==2) {
				player03.add(s);
			}
		}
		System.out.println("底牌："+dipai);
		System.out.println("浩哥："+player01);
		System.out.println("宇哥："+player02);
		System.out.println("迅宝："+player03);
	}
}
