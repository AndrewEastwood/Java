package trainings.custom;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Maps {


	public static void main(String[] args) {
		
		TreeMap<String, String> tm1 = new TreeMap<String, String>();
		tm1.put("a", "1");
		tm1.put("x", "2");
		tm1.put("c", "3");
		for (int i = 0;i<tm1.size();i++)
			System.out.println(tm1.values().toArray()[i]);
		// sorts using custom
		//-----------------------------------
		System.out.println("------------------------------------");
		TreeMap<String, String> tm2rew = new TreeMap<String, String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return -o1.compareTo(o2);
			}
			
		});
		tm2rew.put("a", "1");
		tm2rew.put("x", "2");
		tm2rew.put("c", "3");
		for (int i = 0;i<tm2rew.size();i++)
			System.out.println(tm2rew.values().toArray()[i]);
		// try different methods
		System.out.println("------------------------------------ [using TreeMap.headMap() and set to MAP]");
		
		Map<String, String> hm1 = tm1.headMap("x");
		for (int i = 0;i<hm1.size();i++)
			System.out.println(hm1.values().toArray()[i]);
		
		
		
	}
	
}
