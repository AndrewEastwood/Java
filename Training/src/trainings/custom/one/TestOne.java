package trainings.custom.one;

public class TestOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObjectOne<BaseObject> o1 = new ObjectOne<BaseObject>();
		o1.addEntry(new ExtendedStringInteger("Demo One", Integer.valueOf(0)));
		o1.addEntry(new ExtendedStringInteger("Demo Two", Integer.valueOf(1)));
		o1.addEntry(new ExtendedStringInteger("Demo Three", Integer.valueOf(3)));
		
		o1.printAll();

	}

}
