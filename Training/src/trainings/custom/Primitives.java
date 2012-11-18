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

		// Logger lg = Logger.getLogger("A");
		// lg.info("works");

		log.debug("Hello this is an debug message");
		log.info("Hello this is an info message");

		System.out.println(A);
		System.out.println(B);

	}

	// passing by references
	public static void transformStr(String s) {
		s = "asdfghjkl" + s;
	}

}
