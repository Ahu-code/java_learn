package HeiMa;

public class VarArgs {
	public static void main(String[] args) {
		int i = add(1,2,3);
		System.out.println(i);
		
		
	}
/*
 * 若add(); 就会创建长度为0的数组
 * 若add(10); 就会创建长度为1的数组
 */
//	public static int add(int ...arr) {
//		System.out.println(arr);
//		System.out.println(arr.length);
//		return 0;
//	}
	/*
	 * 注意：一个方法的参数列表，只能有一个可变参数，
	 * 若有多个参数，必须写在末尾
	 */
	
	//终极写法 Object...obj
	public static int add(int a, Object...obj) {
		
		for(Object i:obj)
			System.out.println(i);
		return 0;
	}
}
