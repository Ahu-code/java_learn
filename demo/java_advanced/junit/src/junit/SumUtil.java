package junit;

public class SumUtil {

	public static void main(String[] args) {
		int result = sum1(1,2);
		System.out.println(result);
	}

	public static int sum1(int i, int j) {
		return i+j;
	}
	
	public static int sum2(int i, int j, int k) {
		return i+j+k;
	}
	
	public int add(int a, int b) {
		//int   i = 3/0;
		return a+b;
	}
}
