package trainings.custom;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class Collections {

	public static void main(String[] args) {
		
		CustomObjectOne cstOne = CustomObjectOne.getInstance();
		CustomObjectTwo cstTwo = CustomObjectTwo.getInstance();
		CustomObjectThree cstThree = new CustomObjectThree("THIRD CUSTOM OBJECT");
		
		// -------- HashMap
		HashMap<ICustomObject, String> customHM = new HashMap<ICustomObject, String>();
		
		customHM.put(cstOne, "aaa");
		customHM.put(cstTwo, null);
		customHM.put(cstThree, "3");
		
		String secondObjValue1 = customHM.get(cstTwo);
		System.out.println("The value of the second custom object is = " + secondObjValue1);
		
		// --------- Hashtable
		Hashtable<ICustomObject, String> customHT = new Hashtable<ICustomObject, String>();
		
		customHT.put(cstOne, "aaa");
		customHT.put(cstTwo, "ccc");
		customHT.put(cstThree, "333");

		String secondObjValue2 = customHT.get(cstTwo);
		System.out.println("The value of the second custom object is = " + secondObjValue2);
		
		// ----------- Map;
		
		
	}

}
