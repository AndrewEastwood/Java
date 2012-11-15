package starts;

public class Hello {

	
	public void show() {
		System.out.println("Hello World");

		int rez = this.demoOne(5+"");
		
		System.out.println(rez);

		int a = 5;
		int b = 6;
		int c = 0;
		
		c = ++a - b++;
		
		System.out.println(String.format("ARG A = {0}", a));
		System.out.println(b);
		System.out.println(b);
		System.out.println("------------------------");

		this.fact(6);
	}
	
	private int demoOne (String s) {
		
		int c = Integer.parseInt(s) + 555;
		
		return c++;
	}
	
	private int fact (int x){
		if (x < 0 ) throw new IllegalArgumentException("fdfdsfsdf");
		
		return 7;
	}
}
