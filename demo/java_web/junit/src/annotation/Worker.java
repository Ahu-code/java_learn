package annotation;


@MyAnno(age = 12, name = "小明", anno2 = @MyAnno2(per = Person.P1, show1 = 0, show2 = ""))
@MyAnno3
public class Worker {
	
	/*@MyAnno3
	int show1() {
		return 0;
	}*///只能作用于类
	
	
}
