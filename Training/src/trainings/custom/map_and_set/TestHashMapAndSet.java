package trainings.custom.map_and_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMapAndSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, String> hashM = new HashMap<String, String>(4);
		// adding elements
		hashM.put("a", "item one");
		hashM.put("b", "item two");
		hashM.put("c", "duplicate");
		hashM.put("d", "duplicate");

		// String[] vals = new String[hashM.size()];
		// hashM.values().toArray(vals);
		printSet(hashM.entrySet());
		
		System.out.println("-------------------------------------------");

		HashSet<String> hashS = new HashSet<String>(3);

		hashS.add("One");
		hashS.add("Two");
		hashS.add("Duplicate");
		hashS.add("Duplicate");

		printSet(hashS);


		/* RESULT:
		 * 
		 * Entry: duplicate with key d
		 * Entry: item two with key b
		 * Entry: duplicate with key c
		 * Entry: item one with key a
		 * -------------------------------------------
		 * String: One
		 * String: Duplicate
		 * String: Two
		 */
		
	}
	

	public static void printSet(Set<?> setObj) {
		// System.out.println(setObj.getClass());
		Iterator<?> iter = setObj.iterator();
		while (iter.hasNext()) {
			Object item = iter.next();

			if (item.getClass().getSimpleName().toLowerCase().equals("entry")) {
				Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) item;
				System.out.println("Entry: " + entry.getValue() + " with key "
						+ entry.getKey());
			} else if (item.getClass().getSimpleName().toLowerCase()
					.equals("string"))
				System.out.println("String: " + item);

		}
	}

}
