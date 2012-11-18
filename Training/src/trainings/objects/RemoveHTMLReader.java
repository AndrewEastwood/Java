package trainings.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class RemoveHTMLReader extends FilterReader {

	boolean intag = false;

	public RemoveHTMLReader(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	public int read(char[] buf, int from, int len) throws IOException {
		int numchars = 0;

		while (numchars == 0) {
			numchars = in.read(buf, from, len);
			if (numchars == -1)
				return -1;

			int last = from;
			for (int i = from; i < from + numchars; i++) {
				if (!intag) {
					if (buf[i] == '<')
						intag = true;
					else
						buf[last++] = buf[i];

				} else if (buf[i] == '>')
					intag = false;
			}
			numchars = last - from;

		}

		return numchars;
	}

	public int read() {
		char buf[] = { '0' };
		int rez = 0;
		try {
			rez = read(buf, 0, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rez == -1)
			return -1;
		return buf[0];
	}

	public static class Test {
		public static void main(String[] args) {
			
			java.io.BufferedReader bRd = new BufferedReader(new java.io.InputStreamReader(System.in));
			System.out.println("Html File Name To Read Data > ");
			
			try {
				java.io.File f = new File(bRd.readLine());
				BufferedReader brr = new BufferedReader(new RemoveHTMLReader(
						new FileReader(f)));

				String ln;
				while ((ln = brr.readLine()) != null)
					System.out.println(ln);

				brr.close();
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}

		}
	}
}
