package trainings.networking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class HttpMirror {

	private static Logger log = Logger.getRootLogger();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int port = 7445;

		try {

			ServerSocket ss = new ServerSocket(port);

			for (;;) {
				Socket client = ss.accept();

				BufferedReader brr = new BufferedReader(new InputStreamReader(
						client.getInputStream()));

				java.io.PrintWriter pWr = new PrintWriter(
						client.getOutputStream());

				pWr.print("HTTP/1.0 200 \n");

				// log.info(line);

				String line = "";
				while ((line = brr.readLine()) != null) {
					if (line.length() == 0)
						break;

					// detect request
					if (line.indexOf("GET") > -1) {
						String reqF = line.split(" ")[1].substring(1);
						//pWr.print("Requesting: " + reqF + "\n");

						// try to open file
						log.info("Attempt to open file: " + reqF);
						File f = new File(reqF);

						log.info(f.getAbsolutePath());
						
						if (f.exists() && !f.isDirectory()) {
							// read file

							String fExt = reqF.substring(reqF.lastIndexOf('.')+1).toLowerCase();

							if (fExt.equals("html"))
								pWr.print("Content-Type: text/html \n");

							java.io.BufferedReader bReader = new java.io.BufferedReader(new java.io.FileReader(f));

							String ln = "";
							while((ln = bReader.readLine()) != null)
								pWr.write(ln + "\n");

							bReader.close();

							log.info("File Exists");
						} else
							log.error("No file");
						// log.info(f);
					} else
						pWr.print("Content-Type: text/plain \n");

					pWr.write("some text\n");
					// pWr.print(line + "olololo\n");
				}

				pWr.print("\n");
				pWr.close();
				brr.close();
				client.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
