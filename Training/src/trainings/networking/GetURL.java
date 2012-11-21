package trainings.networking;

import java.io.*;
import java.net.URL;

import org.apache.log4j.Logger;

public class GetURL {

	private static Logger log = Logger.getLogger(trainings.networking.GetURL.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//args = new String[]{"http://www.google.com"};

		InputStream in = null;
		OutputStream out = null;
		log.info("Application Startup");
		try {
			if (args.length != 1 && args.length != 2)
				throw new IllegalArgumentException("Wrong argument count");

			URL url = new URL(args[0]);

			log.info("Opening stream to : " + args[0]);
			in = url.openStream();

			if (args.length == 2)
				out = new FileOutputStream(args[1]);
			else
				out = System.out;

			// read bytes
			byte[] buffer = new byte[1024 * 4];
			int read_bytes = 0;

			log.info("Reading Data from : " + args[0]);
			while ((read_bytes = in.read(buffer)) != -1) {
				out.write(buffer, 0, read_bytes);
			}

		} catch (Exception e) {
			// TODO: handle exception
			log.error(e);
		}
		finally {
			try{
				log.info("Attempting to close stream : " + args[0]);
				in.close();
				out.close();
			}catch(Exception ex){
				log.error(ex);
				//log.log(Priority.INFO, ex);
			}
		}

		log.info("Application End");
	}

}
