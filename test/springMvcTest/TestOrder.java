package springMvcTest;

public class TestOrder {

	private String userName;
	private int age;
	private static String sex;
	
	static{
	   System.out.println("�˴���̬���������ִ��!");
	}
	
	public TestOrder() {
		System.out.println("���ǿչ��췽��");
	}

	public TestOrder(String userName, int age) {
		super();
		this.userName = userName;
		this.age = age;
		System.out.println("���Ǵ����Թ��췽��");
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
		System.out.println("��̬����---�ʺ�!");
	}
	public void sayBay(){
		System.out.println("�Ǿ�̬����--���");
	}
}
