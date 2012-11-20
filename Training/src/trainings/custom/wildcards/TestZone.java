package trainings.custom.wildcards;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestZone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// use SomeAB and SomeABC
		HashSet<SomeAB<String>> hs1 = new HashSet<SomeAB<String>>();
		hs1.add(new SomeAB<String>());
		hs1.add(new SomeABC<String>());

		printSomeABC(hs1);
		
		System.out.println("--------------------------");
		
		HashSet<SomeBase<Integer>> hs2 = new HashSet<SomeBase<Integer>>();
		hs2.add(new SomeBase<Integer>());
		//hs2.add(new SomeAB<Integer>());
		//hs2.add(new SomeABC<Integer>());

		printSome(hs2);
	}
	
	public static void printSomeABC (Set<? extends SomeA<? extends Object>> s) {
		Iterator<SomeA<? extends Object>> iter = (Iterator<SomeA<? extends Object>>)s.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().getObjectInfo());
		}
	}
	
	// use with objects: SomeA and SomeBase
	public static void printSome(Set<? super SomeA<Integer>> s) {
		Iterator<AbstractSomeBase<Integer>> iter = (Iterator<AbstractSomeBase<Integer>>)s.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().getObjectInfo());
		}
	}

}
