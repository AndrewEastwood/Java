package trainings.custom.properties;

import java.util.Iterator;
import java.util.Map;

public class PropsSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// show all system properties
		for(Iterator<java.util.Map.Entry<Object, Object>> iep= System.getProperties().entrySet().iterator();iep.hasNext();)
		{
			Map.Entry<Object, Object> item = iep.next();
			System.out.println("System Property Content: " + item.getKey() + " => " + item.getValue());
		}
	}

}
