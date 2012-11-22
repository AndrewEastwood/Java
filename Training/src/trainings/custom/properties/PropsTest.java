package trainings.custom.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File dirToStore = new File("data");
		
		Properties propToSave = new Properties();
		
		propToSave.setProperty("my.prop.one", "1");
		propToSave.setProperty("my.prop.two", "2");
		
		try {
			
			if (!dirToStore.exists())
				dirToStore.mkdir();
			propToSave.store(new FileOutputStream(dirToStore + "/myprops.properties"), "properties test one");
			
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getRootLogger().error(e);
		}
		
		
		//------------- read all of them
		

		Properties propToRead = new Properties();
		
		try{
			
			if (!dirToStore.exists())
				throw new java.io.FileNotFoundException("Can't find directory: '" + dirToStore + "'");
			
			propToRead.load(new FileInputStream(dirToStore + "/myprops.properties"));
			
			// show them
			for(Iterator<java.util.Map.Entry<Object, Object>> iep= propToRead.entrySet().iterator();iep.hasNext();)
			{
				Map.Entry<Object, Object> item = iep.next();
				System.out.println("Property Content: " + item.getKey() + " => " + item.getValue());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getRootLogger().error(e);
		}

	}

}
