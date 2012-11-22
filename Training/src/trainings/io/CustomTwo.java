package trainings.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// base 
		FileInputStream fInStr = null;
		FileOutputStream fOutStr = null;
		
		try {
			fInStr = new FileInputStream("data/source.txt");
			fOutStr = new FileOutputStream("data/iotest_one.txt");
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
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

}
