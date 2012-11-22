package trainings.custom.properties;

import java.util.Enumeration;
import java.util.Properties;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class PropertyLister {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties props = new Properties();

		props.setProperty("a", "1");
		props.setProperty("b", "2");
		props.setProperty("c", "3");
		props.setProperty("d", "4");

		Enumeration enumer = props.propertyNames();
		while(enumer.hasMoreElements()) {
			Object pKey = enumer.nextElement();
			System.out.println(pKey + " => " + props.getProperty(pKey.toString()));
		}

	}

}
