package demoJDBC;

public class DemoForClass {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class.forName("demoJDBC.StaticClass");
//		Class.getDeclaredConstructor("demoJDBC.StaticClass").newInstance();
		
	}
}

class StaticClass
{
	static {
		System.out.println("This is static block");
	}
	{
		System.out.println("This is Instance block");
	}
}