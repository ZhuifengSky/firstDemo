package springMvcTest;

public class TestOrder {

	private String userName;
	private int age;
	private static String sex;
	
	static{
	   System.out.println("此处静态代码块正在执行!");
	}
	
	public TestOrder() {
		System.out.println("这是空构造方法");
	}

	public TestOrder(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
		System.out.println("这是带属性构造方法");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public static void sayHi(){
		System.out.println("静态方法---问好!");
	}
	public void sayBay(){
		System.out.println("非静态方法--告别");
	}
}
