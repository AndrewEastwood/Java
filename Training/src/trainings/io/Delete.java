package trainings.io;

import java.io.*;

public class Delete {
	public static void main(String[] args) {
		
		try {
			delete(args[0]);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void delete(String fname) {
		File f = new File(fname);

		System.out.println(f.getAbsoluteFile());
		
		if (!f.exists()) fail("file does not exists: " + fname);
		if (!f.canWrite()) fail("file protected: " + fname);
		
		if (f.isDirectory()) {
			String[] dirFiles = f.list();
			if (dirFiles.length > 0)
				fail("Directory is not empty");
		}
			
		boolean success = f.delete();
		
		if (!success) fail("Can't remove file");
			
	}
	
	protected static void fail (String message) throws IllegalArgumentException {
		throw new IllegalArgumentException(message);
	}
}
