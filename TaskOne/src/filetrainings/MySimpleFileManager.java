package filetrainings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySimpleFileManager {

	public String getFileContent(String fileName) throws FileNotFoundException {
		return getFileContent(fileName, false);
	}

	public String getFileContent(String fileName, boolean revertEachLine)
			throws FileNotFoundException {
		File f = new File(fileName);
		if (f.isDirectory())
			throw new IllegalArgumentException(
					"Can't read content from directory. Argument passed: "
							+ fileName);

		if (!f.exists())
			throw new FileNotFoundException("No such fileL: " + fileName);

		BufferedReader buffReader = new BufferedReader(new FileReader(f));
		StringBuilder fileContent = new StringBuilder();
		try {
			String ln = "";

			while ((ln = buffReader.readLine()) != null) {
				if (revertEachLine)
					fileContent.append(revertTextBlock(ln));
				else
					fileContent.append(ln);
				fileContent.append(System.getProperty("line.separator"));
			}
				

		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				buffReader.close();
			} catch (IOException e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
			}
		}

		return fileContent.toString();
	}

	public void writeContentIntoFile(String fileName, String data)
			throws IOException {
		File f = new File(fileName);
		if (f.isDirectory())
			throw new IllegalArgumentException(
					"Can't write file content into directory. Argument passed: "
							+ fileName);

		FileWriter fWriter = new FileWriter(f);
		try {
			fWriter.write(data);
		} catch (IOException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				fWriter.close();
			} catch (IOException e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/*
	 * get file info:
	 * 0 - file name with extension
	 * 1 - file name only
	 * 2 - extension only
	 */
	public String[] getFileInfo(File f)
			throws IllegalAccessException {

		if (f.isDirectory())
			throw new IllegalAccessException("Directory name passed: "
					+ f.getName());

		String fName = f.getName();

		if (fName.length() == 1)
			throw new IllegalAccessException("Wrong File Name: " + fName);

		int lastDotPos = fName.lastIndexOf('.');
		if (lastDotPos < 0)
			return new String[3];
		
		return new String[] {
				fName,
				fName.substring(0, lastDotPos),
				fName.substring(lastDotPos + 1)
		};
	}
	
	public File getNewFileAndKeepExtension(String fileName) throws IllegalAccessException {
		File f = new File(fileName);
		String[] fileInfo = getFileInfo(f);
		StringBuilder newFileName = new StringBuilder();
		newFileName.append(f.getParent());
		newFileName.append(File.separator);
		newFileName.append(fileInfo[1]); // file name without extension
		newFileName.append('_');
		newFileName.append(Math.round(Math.random() * 12345 + 1));
		newFileName.append('.');
		newFileName.append(fileInfo[2]); // append extension
		return new File(newFileName.toString());
	}

	public String revertTextBlock(String text) {
		StringBuilder revTextLine = new StringBuilder(text);
		char tmp = '\0';
		int strLen = revTextLine.length();
		for (int i = 0, j = strLen - 1; i < strLen / 2; i++, j--) {
			tmp = revTextLine.charAt(i);
			revTextLine.setCharAt(i, revTextLine.charAt(j));
			revTextLine.setCharAt(j, tmp);
		}
		return revTextLine.toString();
	}

}
