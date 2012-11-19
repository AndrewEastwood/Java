package trainings.custom;

//import java.util.logging.Logger;

import org.apache.log4j.Logger;


public class Primitives {

	static Logger log = Logger.getLogger(Primitives.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder strBld = new StringBuilder("qwertyuiop");

		// reverse string
		for (int i = 0, ln = strBld.length(); i < ln / 2; i++) {
			char tmp = strBld.charAt(i);
			strBld.setCharAt(i, strBld.charAt(ln - i - 1));
			strBld.setCharAt(ln - i - 1, tmp);

		}

		System.out.println(strBld.toString());

		// step 2. try references
		String refStr = "qwertyuiop";
		transformStr(refStr);
		System.out.println(refStr);

		// immutable test
		String A = "Test";
		String B = "Test";

		B = B.toUpperCase();

		A = A + A + A + B + A;

		
		//char[] c = A.toCharArray();
		//c[4] = 'X';
		//A = new StringBuilder().append(c).toString();
		
		// Logger lg = Logger.getLogger("A");
		// lg.info("works");

		log.debug("Hello this is an debug message");
		log.info("Hello this is an info message");

		System.out.println(A);
		System.out.println(B);
		
		Primitives.CustomObj cObj1 = Primitives.CustomObj.getInstance();
		
		transformCustomObj(cObj1);
		System.out.println(cObj1);
		
		// custom object one
		CustomObjectOne cstOne = CustomObjectOne.getInstance();
		transformCustomObj(cstOne);
		System.out.println(cstOne);

	}

	// passing by value
	public static void transformStr(String s) {
		s = "asdfghjkl" + s;
	}

	// passing by reference
	public static void transformCustomObj(ICustomObject s) {
		s.setObjectName("TESTING");
	}
	
	// making custom object
	public static class CustomObj implements ICustomObject {
		private String objectName = "";
		private static CustomObj _inst = null;
		
		private CustomObj () {
			System.out.println("private constructor of CustomObj called");
		}
		
		public static CustomObj getInstance () {
			System.out.println("getInstance() of CustomObj called");
			if (_inst == null)
				_inst = new CustomObj();
			return _inst;
		}
		
		public String getObjectName() {
			return objectName;
		}

		public void setObjectName(String objectName) {
			this.objectName = objectName;
		}

		@Override
		public String toString() {
			return "CustomObj [name=" + objectName + "]";
		}
	}

}
