package HeiMa;

public class HashCode01 {
	
	public static void main(String[] args) {
		HashCode01 a1 = new HashCode01();
		int i1 = a1.hashCode();
		System.out.println(i1);
		System.out.println(a1);
		
		/*  toString 源码
		 *  getClass().getName() + "@" + Integer.toHexString(hashCode());
		 *  1534030866 //十进制
			HeiMa.HashCode01@5b6f7412//16进制
		 */
		HashCode01 a2 = new HashCode01();
		int i2 = a2.hashCode();
		System.out.println(i2);
		System.out.println(a2);
		
		System.out.println(a1==a2);
		
		
		String s1 = new String("aaaa");
		String s2 = new String("aaaa");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println("重地".hashCode());//1179395
		System.out.println("通话".hashCode());//1179395字符串不一样，哈希值一样

	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
}