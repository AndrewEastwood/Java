package trainings.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.SequenceInputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class CustomTwo {

	private static String _sourceDir = "data/";
	private static String _sourceFile = _sourceDir + "source.txt";

	public static class TestConfigObject implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String _id;
		private String _name;
		private double _price;

		public TestConfigObject(String name) {
			this._name = name;
			MessageDigest md5;
			try {
				md5 = MessageDigest.getInstance("MD5");
				md5.update(name.getBytes());
				this._id = new BigInteger(1, md5.digest()).toString(16);
				System.out.println("MD5: " + this._id);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this._id = String.valueOf(name.hashCode());
			}

		}

		public TestConfigObject(String name, double price) {
			this(name);
			this._price = price;
		}

		/**
		 * @return the _id
		 */
		public String get_id() {
			return _id;
		}

		/**
		 * @return the _name
		 */
		public String get_name() {
			return _name;
		}

		/**
		 * @param _name
		 *            the _name to set
		 */
		public void set_name(String _name) {
			this._name = _name;
		}

		/**
		 * @return the _price
		 */
		public double get_price() {
			return _price;
		}

		/**
		 * @param _price
		 *            the _price to set
		 */
		public void set_price(double _price) {
			this._price = _price;
		}

		public String toString() {
			return "[TestConfigObject(" + this._id + ")] {" + this.get_name()
					+ "" + this.get_price() + "}";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * try { testIoSix(); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		// testIoSeven();
		// testIoEight();
		testIoTen();

	}

	private static void testIoTen() {
		ArrayList<TestConfigObject> _objects = new ArrayList<CustomTwo.TestConfigObject>();
		TestConfigObject objA = new TestConfigObject("ProductOne", 100.01);
		TestConfigObject objB = new TestConfigObject("ProductTwo", 111.11);
		TestConfigObject objC = new TestConfigObject("ProductThree", 123.45);
		_objects.add(objA);
		_objects.add(objB);
		_objects.add(objC);

		ObjectOutputStream objOutStr = null;
		try {
			objOutStr = new ObjectOutputStream(new FileOutputStream(_sourceDir
					+ "io_test_ten.dat"));
			TestConfigObject[] _objToSave = new TestConfigObject[_objects
					.size()];
			_objects.toArray(_objToSave);
			objOutStr.writeObject(_objToSave);
			System.out.println("All object have been written succesfully");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (objOutStr != null)
				try {
					objOutStr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		// now let's read all of them
		ObjectInputStream objInStr = null;
		TestConfigObject[] _readObjects = null;

		try {
			objInStr = new ObjectInputStream(new FileInputStream(_sourceDir
					+ "io_test_ten.dat"));
			_readObjects = (TestConfigObject[]) objInStr.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (objInStr != null)
				try {
					objInStr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		for (int i = 0; i < _readObjects.length; i++)
			System.out.println(_readObjects[i]);

	}

	private static void testIoNine() {
		BufferedReader buffRdr = null;
		try {
			buffRdr = new BufferedReader(new FileReader(_sourceFile));

			String line = "";
			while ((line = buffRdr.readLine()) != null)
				System.out.println(line);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (buffRdr != null)
				try {
					buffRdr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	private static void testIoEight() {
		DataOutputStream dOutStr = null;
		try {
			dOutStr = new DataOutputStream(new FileOutputStream(_sourceDir
					+ "io_test_eight.txt"));

			dOutStr.writeDouble(1.234);
			dOutStr.writeBoolean(true);
			dOutStr.writeChar('0');
			dOutStr.writeDouble(9.876);
			dOutStr.writeLong(123456789);
			dOutStr.writeUTF("ТРОЛОЛО...ТЕСТ");
			dOutStr.writeLong(123456789);
			dOutStr.writeBoolean(false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dOutStr != null)
				try {
					dOutStr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		// now try to read data
		DataInputStream dInStr = null;

		ArrayList<Object> readItems = new ArrayList<Object>();

		try {
			dInStr = new DataInputStream(new FileInputStream(_sourceDir
					+ "io_test_eight.txt"));

			// readItems.add(dInStr.readDouble());
			// readItems.add(dInStr.readBoolean());
			// readItems.add(dInStr.readChar());
			// readItems.add(dInStr.readDouble());
			// readItems.add(dInStr.readLong());
			// readItems.add(dInStr.readUTF());
			// readItems.add(dInStr.readLong());
			// readItems.add(dInStr.readBoolean());

			// shuffled
			// will read the same data but convert to requested type
			readItems.add(dInStr.readDouble());
			readItems.add(dInStr.readBoolean());
			readItems.add(dInStr.readChar());

			// render read items
			Iterator<Object> iterOne = readItems.iterator();
			while (iterOne.hasNext())
				System.out.println("[1] Readed item: " + iterOne.next());
			System.out.println("--------------------------------------");
			// using list iterator
			ListIterator<Object> iterTwo = readItems.listIterator();
			while (iterTwo.hasNext())
				System.out.println("[2] Readed item: " + iterTwo.next());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dInStr != null)
				try {
					dInStr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	private static void testIoSeven() {
		Console c = System.console();
		c.flush();
		c.printf("Type Your Name: ");
		String name = c.readLine();
		c.printf("Type Your Password: ");
		char[] pwd = c.readPassword();
		if (Arrays.equals(pwd, new char[] { '1', '2', '3' }))
			c.printf("Hello %s!%n", name);
		else
			c.printf("Wrong Password!%n");
		Arrays.fill(pwd, '\0');
		c.flush();
	}

	private static void testIoSix() throws Exception {
		/*
		 * StringWriter strWrt1 = new StringWriter(); StringWriter strWrt2 = new
		 * StringWriter(); StringWriter strWrt3 = new StringWriter(); // write
		 * data for (int i = 0; i < 10; i++) { strWrt1.write(i);
		 * strWrt2.write(10 + i); strWrt3.write(100 + i); }
		 */

		FileInputStream fRdr1 = new FileInputStream(_sourceDir
				+ "io_test_one.txt");
		FileInputStream fRdr2 = new FileInputStream(_sourceDir
				+ "io_test_two.txt");
		FileInputStream fRdr3 = new FileInputStream(_sourceDir
				+ "io_test_three.txt");
		// get list
		Vector<FileInputStream> items = new Vector<FileInputStream>();
		items.add(fRdr1);
		items.add(fRdr2);
		items.add(fRdr3);
		// create common file
		BufferedOutputStream fWrt = new BufferedOutputStream(
				new FileOutputStream(_sourceDir + "io_test_common.txt", true));

		// sequence reader
		SequenceInputStream sqInStr = new SequenceInputStream(items.elements());
		byte[] buffer = new byte[4 * 1024];
		int bytes_readed = 0;
		while ((bytes_readed = sqInStr.read(buffer)) != -1)
			fWrt.write(buffer, 0, bytes_readed);

		fWrt.flush();

		fRdr1.close();
		fRdr2.close();
		fRdr3.close();
		fWrt.close();
	}

	private static void testIoFive() {
		StringWriter strWrt = new StringWriter();
		strWrt.write("olololo:");
		strWrt.write(49);
		try {
			strWrt.write(new char[] { ':', 'A', 'B', 'C' });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// display stream
		System.out.println(strWrt.toString());
		// read stream
		StringReader strRdr = new StringReader(strWrt.toString());
		int readedChar;
		try {
			while (true) {
				readedChar = strRdr.read();
				// System.out.println(readedChar);
				if (readedChar == -1)
					break;
				System.out.println("> char: " + (char) readedChar);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// using FileInputStream, FileOutputStream
	private static void testIoOne() {
		// base
		FileInputStream fInStr = null;
		FileOutputStream fOutStr = null;

		try {
			fInStr = new FileInputStream(_sourceFile);
			fOutStr = new FileOutputStream(_sourceDir + "io_test_one.txt");

			byte[] buffer = new byte[1024 * 10];
			int read_bytes = 0;
			while ((read_bytes = fInStr.read(buffer)) != -1) {
				fOutStr.write(buffer, 0, read_bytes);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fInStr != null)
				try {
					fInStr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (fOutStr != null)
				try {
					fOutStr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	// using: FileReader, FileWriter
	private static void testIoTwo() {
		FileReader fRead = null;
		FileWriter fWriter = null;

		try {
			fRead = new FileReader(_sourceFile);
			fWriter = new FileWriter(_sourceDir + "io_test_two.txt");

			char[] buffer = new char[1024 * 4];
			int readed_bytes = 0;

			while ((readed_bytes = fRead.read(buffer)) != -1)
				fWriter.write(String.valueOf(buffer));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fRead != null)
				try {
					fRead.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (fWriter != null)
				try {
					fWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	// using bridges:
	// InputStreamReader(InputStream in)
	// OutputStreamWriter(OutputStream out)
	private static void testIoThree() {
		InputStreamReader inStrRdr = null;
		OutputStreamWriter outStrWrt = null;
		try {

			inStrRdr = new InputStreamReader(new FileInputStream(_sourceFile));
			outStrWrt = new OutputStreamWriter(new FileOutputStream(_sourceDir
					+ "io_test_three.txt"));

			char[] buffer = new char[1024 * 4];
			int readed_chars = 0;
			while ((readed_chars = inStrRdr.read(buffer)) != -1)
				outStrWrt.write(String.valueOf(buffer));

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			if (inStrRdr != null)
				try {
					inStrRdr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (outStrWrt != null)
				try {
					outStrWrt.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	private static void testIoFour() {
		BufferedReader buffRdr = null;
		PrintWriter prnWrt = null;
		try {
			buffRdr = new BufferedReader(new FileReader(_sourceFile));
			prnWrt = new PrintWriter(_sourceDir + "io_test_four.txt");
			String ln = "";
			while ((ln = buffRdr.readLine()) != null)
				prnWrt.println(ln);

		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (buffRdr != null)
				try {
					buffRdr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (prnWrt != null)
				prnWrt.close();
		}

	}

}
