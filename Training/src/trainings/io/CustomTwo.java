package trainings.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CustomTwo {

	private static String _sourceDir = "data/";
	private static String _sourceFile = _sourceDir + "source.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testIoFour();

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
