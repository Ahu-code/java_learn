package annotation;

/*
 * * JDK中预定义的一些注解
		* @Deprecated：该注解标注的内容，表示已过时//强制使用不影响
		* @SuppressWarnings：压制警告
		* 一般传递参数all  @SuppressWarnings("all")
 */

@SuppressWarnings("all")
public class AnnoDemo2 {
	
	public static void main(String[] args) {
		show1();
	}
	@Override
	public String toString() {
		return super.toString();
	}
/*
 * * 自定义注解
	* 格式：
		元注解
		public @interface 注解名称{
			属性列表;
		}	
 */
	
	/**
	 *@deprecated 
	 */
	private static void show1() {
	}
	
	@MyAnno(age = 0, anno2 = @MyAnno2(per = Person.P2, show1 = 0, show2 = ""))
	private void show2() {
		//替代show1
	}
}
