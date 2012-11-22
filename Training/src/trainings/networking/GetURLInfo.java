package trainings.networking;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.apache.log4j.Logger;

public class GetURLInfo {

	private static Logger log = Logger.getLogger(GetURLInfo.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//log.trace("TRACE");
		//log.debug("DEBUG");
		//log.info("INFO");
		//log.warn("WARN");
		//log.error("ERROR");
		//log.fatal("FATAL\n--------------------------------------");
		
		//return;

		try {
			printUrlInfo("http://narod.yandex.ru/");
		} catch (MalformedURLException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}

		log.debug("--------------------------------------");
	}
	
	public static void printUrlInfo(String url) throws MalformedURLException, IOException {
		
		URLConnection urlConn = new URL(url).openConnection();

		log.info("Attempt to connect");
		urlConn.connect();
		log.info("Connected to " + url);
		
		// ---------------------
		log.info("Content type: " + urlConn.getContentType());
		log.info("Length: " + urlConn.getContentLength());
		log.info("Encoding: " + urlConn.getContentEncoding());
		log.info("Last Modified: " + new Date(urlConn.getLastModified()));
		
		
		if (urlConn instanceof HttpURLConnection) {
			HttpURLConnection httpUC = (HttpURLConnection)urlConn;
			
			log.info("Request: " + httpUC.getRequestMethod());
			log.info("responce: " + httpUC.getResponseCode());
		}
		
	}

}
