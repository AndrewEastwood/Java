package trainings.basic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextReverse {

	public TextReverse() { }
	
	public void ReadTextAndShowReversed () throws IOException {
		StringBuffer buff = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(;;) {
			System.out.print("Type Text > ");
			String line = br.readLine();
			if (line.isEmpty() || line.equals("quit"))
				break;
			buff.append(line);
			for (int i = 0; i < buff.length(); i++ )
				buff.setCharAt(i, rot13(buff.charAt(i)));
			System.out.println("Rot13     > " + buff.toString());
			buff.delete(0, buff.length());
		}
	}
	
	public static char rot13 (char c) {
		if ((c > 'A') && (c < 'Z')) {
			c+=13;
			if (c > 'Z')
				c -= 26;
		}
		if ((c > 'a') && (c < 'z')) {
			c+=13;
			if (c > 'z')
				c -= 26;
		}
		return c;
	}
	
}
