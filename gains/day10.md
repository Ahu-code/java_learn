今天是研究os的一天....还是愧疚一下吧555
--------------------------------------
1回顾.Properties集合
Map-Hashtable-Properties类
/*
 * 属性集
 * java.util.Properties 继承于Hashtable ，来表示一个持久的属性集。
 * 是一个双列集合		Map-Hashtable-Properties类
 * 它使用键值结构存储数据，每个键及其对应值都是一个字符串。
 * 该类也被许多Java类使用，比如获取系统属性时， System.getProperties 方法就是返回一个Properties 对象
 */
-----------------
几个方法：
/*
 * setProperty(String key, String value) 
 * 	     调用 Hashtable方法 put 。
 * getProperty(String key) 
 * 	使用此属性列表中指定的键搜索属性。相当于map集合的get 
 * stringPropertyNames() 返回键集 相当于map中的Set方法
 */
/*
 * void store(OutputStream out, String comments) 字节流
 * void store(Writer writer, String comments) 字符流
 * 	String comments：注释，用于解释说明保存文件是干啥
 * 	不能使用中文，一般用空字符串（中文乱码）
 */
/*
 * load(InputStream inStream) 读取属性列表（键和元素对）。字节输入流
 * load(Reader reader) 读取属性列表（键和元素对）。  字符输入流
 * 
 * 存储键值对的文件中，可以用#进行注释
 * 键值对默认均为字符串，不用加引号
 * 文本中的数据，必须是键值对形式，可以使用空格、等号、冒号等符号分隔。
 */
eg:
Properties prop = new Properties();		
prop.load(new FileInputStream("F:\\a.txt"));