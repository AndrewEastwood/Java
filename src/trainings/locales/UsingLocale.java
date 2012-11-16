package trainings.locales;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class UsingLocale {

	public UsingLocale() {
		// TODO Auto-generated constructor stub
	}

	
	public static void displayValues(ResourceBundle bundle) {
		System.out.println("message:" + bundle.getString("test"));
		System.out.println();
	}
	
	
	public static class Test {
		public static void main(String[] args) {
			Logger.getAnonymousLogger().log(new LogRecord(Level.INFO, "Hello"));
			
			ResourceBundle bundle1 = ResourceBundle.getBundle("TestBundle");
			displayValues(bundle1);

			Locale defaultLocale = Locale.getDefault();
			ResourceBundle bundle2 = ResourceBundle.getBundle("TestBundle", defaultLocale);
			displayValues(bundle2);

			Locale swedishLocale = new Locale("sv", "SE");
			ResourceBundle bundle3 = ResourceBundle.getBundle("TestBundle", swedishLocale);
			displayValues(bundle3);

			Locale nonexistentLocale = new Locale("xx", "XX");
			ResourceBundle bundle4 = ResourceBundle.getBundle("TestBundle", nonexistentLocale);
			displayValues(bundle4);
		}
	}
	
}
