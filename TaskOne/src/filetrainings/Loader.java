package filetrainings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Loader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			//if (args.length != 1 || args.length != 2)
			//	throw new IllegalAccessException("Wrong argument count. You must use the following format: [fileNameToRead [fileNameToSave]]");

			MySimpleFileManager simplMgr = new MySimpleFileManager();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sourceName = "";
			String destinationName = "";
			
			// read input params
			System.out.println("Revert File content and save into file");
			System.out.print("File name with content: ");
			sourceName = reader.readLine();
			System.out.print("File name to save content (leave empty to use random name): ");
			destinationName = reader.readLine();

			if (sourceName.length() == 0)
				throw new IllegalAccessException("Provided file name is empty");

			// get reverted file content
			String data = simplMgr.getFileContent(sourceName, true);
			String fileNameToSave = "";
			// choose file name to save
			if (destinationName.length() == 0)
				fileNameToSave = simplMgr.getNewFileAndKeepExtension(sourceName).getPath();
			else
				fileNameToSave = destinationName;
			// save data
			simplMgr.writeContentIntoFile(fileNameToSave, data);

			System.out.println("***** Saved into the file: " + fileNameToSave);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
