package trainings.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class IteratorHashtableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable<Integer, String> data = new Hashtable<Integer, String>();

		data.put(new Integer(1), "one");
		data.put(new Integer(2), "two");
		data.put(new Integer(4), "four");
		data.put(new Integer(3), "three");

		Set<Entry<Integer, String>> set = data.entrySet();

		Iterator<Entry<Integer, String>> iter = set.iterator();

		System.out.println("Iterating over Hashtable in Java");

		while (iter.hasNext()) {
			Entry<Integer, String> en = iter.next();
			if (en.getKey() == 3)
				iter.remove();
			else
				System.out.println("Key: " + en.getKey() + ";   Value: "
						+ en.getValue());
		}
		// ----------------------------------------------
		// the source above is copied from
		// http://javarevisited.blogspot.com/2011/10/java-iterator-tutorial-example-list.html

		// self made testing
		// concurrent hash map testing

		ConcurrentHashMap<Integer, String> concurrHM = new ConcurrentHashMap<Integer, String>();
		concurrHM.put(new Integer(3), "three");
		concurrHM.put(new Integer(9), "nine");
		concurrHM.put(new Integer(5), "five");

		// print values with enumerator
		Enumeration<String> elemsOne = concurrHM.elements();
		while (elemsOne.hasMoreElements())
			System.out.println("[test 1] ConcurrentHashMap value is = "
					+ elemsOne.nextElement());

		// print values with collection
		Collection<String> collectionTwo = concurrHM.values();
		Iterator<String> iteratorTwo = collectionTwo.iterator();
		while (iteratorTwo.hasNext()) {
			System.out.println("[test 2] ConcurrentHashMap value is = "
					+ iteratorTwo.next());
		}

		// adding new items using collection
		ArrayList<String> arrayOne = new ArrayList<String>();
		arrayOne.addAll(collectionTwo);
		arrayOne.add("TROLOLO");
		for (int i = 0; i < arrayOne.size(); i++) {
			System.out
					.println("[test 3] ArrayList<String> by Collectiomn of ConcurrentHashMap value is = "
							+ arrayOne.get(i));
		}
		
		// try to update ConcurrentHashMap
		Map<Integer, String> m1 = new HashMap<Integer, String>() {
			{
				put(new Integer(111), "Startup Test");
			}
		};
		concurrHM.putAll(m1);
		for (Iterator<String> iterator = concurrHM.values().iterator(); iterator.hasNext();)
			System.out.println("[test 4] Updated ConcurrentHashMap value = " + iterator.next());

	}

}
