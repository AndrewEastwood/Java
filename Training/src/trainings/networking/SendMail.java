package trainings.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;

import exceptions.PrintWriter;

public class SendMail {

	private static Logger log = Logger.getRootLogger();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> _userMailCfg = new HashMap<String, String>();
		BufferedReader brr = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			System.out.print("Put mail host or leave blank > ");
			_userMailCfg.put("host", brr.readLine());
			System.out.print("From > ");
			_userMailCfg.put("from", brr.readLine());
			System.out.print("To > ");
			_userMailCfg.put("to", brr.readLine());
			System.out.print("Subject > ");
			_userMailCfg.put("subject", brr.readLine());
			System.out.print("Message (one line) > ");
			_userMailCfg.put("message", brr.readLine());

			URL u = new URL("mailto:" + _userMailCfg.get("to"));
			URLConnection uConn = u.openConnection();

			uConn.setDoInput(false);
			uConn.setDoOutput(true);

			log.info("Connectiong ...");
			System.out.flush();

			uConn.connect();

			java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(uConn.getOutputStream()));
			
			out.print("From: \""+_userMailCfg.get("from")+"\" ");
			out.print("<"+System.getProperty("user.name") + '@' + InetAddress.getLocalHost().getHostName() +">\n");
			out.print("To: " + _userMailCfg.get("to") + "\n");
			out.print("Subject: " + _userMailCfg.get("subject") + "\n");
			out.print("\n");
			out.print(_userMailCfg.get("message"));

			out.close();
			
			log.info("Message sent!");
			

		} catch (Exception e) {
			log.error(e);
		}

	}

}
