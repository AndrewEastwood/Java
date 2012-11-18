package exceptions;

import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class PrintWriter {

	private int SIZE = 10;
	private ArrayList<Integer> _list = new ArrayList<Integer>(SIZE);

	public ArrayList<Integer> getList() {
		for (int i = 0; i < SIZE; i++)
			_list.add((int) Math.round((100 * Math.random())));

		return _list;
	}

	public <T> String arrayToString(T[] array, String delim, String fmt) {

		String _dataLine = "";
		
		for (int i = 0;i < array.length; i++) {
			String _ln = String.format(fmt, i, array[i]);
			System.out.println(_ln);
			_dataLine += _ln + delim;
		}
		
		return _dataLine.trim();
	}

	public static class Test {

		public static void main(String[] args) throws Exception {

			PrintWriter prn = new PrintWriter();
			ArrayList<Integer> _data = prn.getList();
			java.io.FileWriter _fWr;

			String _strData = prn.<Object> arrayToString(_data.toArray(), ",", "Value [%04d] = %d\n");
			
			java.io.BufferedReader bRd = new BufferedReader(new java.io.InputStreamReader(System.in));

			System.out.println("File Name To Write Data > ");

			java.io.File f = new File(bRd.readLine());
			
			try {

				System.out.println("File Path To Write Data = " + f.getAbsolutePath());

				if (f.isDirectory())
					throw new Exception("It's directory. Can't complete write operation.");

				
				_fWr = new FileWriter(f.getAbsolutePath());
				_fWr.write(_strData);
				_fWr.close();
				
				GZIPOutputStream gzip = new GZIPOutputStream((new java.io.FileOutputStream(f.getName() + ".gz")));
				
				System.out.flush();

				int count = 0;
				while (count < 20) {
					gzip.write(bRd.readLine().toString().getBytes());
					count++;
				}
				
				gzip.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Data Saved :) Fave Fun :)\nPress 'S' to view saved content something else to exit >");
			
			String answer = bRd.readLine();
			
			
			if (answer.equals("Y")) {

				
				// open and read file content
				java.io.FileReader frd = new FileReader(f);
				
				
				System.out.println("File Name To Write Data > ");
				char[] cbuf = new char[1024];
				int rdc = 0;
				char cc = '0';
				while ((rdc = frd.read(cbuf)) != -1) {
					for (char c : cbuf) {
						System.out.print(c);
					}
				}
				
				//java.io.InputStreamReader inFsRd = new InputStreamReader(fsIn);
				
				//java.io.BufferedInputStream bufReader = new BufferedInputStream(fsIn);

			}
			
		}

	}

}
