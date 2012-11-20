package trainings.custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyGenericTestsV1 {

	public static void main(String[] args) {
		
		List<MyGenericTwo> listOfGenTwo = new ArrayList<MyGenericTwo>();
		List<MyGenericOne> listOfGenOne = new ArrayList<MyGenericOne>();
		
		listOfGenOne.add(new MyGenericOne("String val 1 a"));
		listOfGenOne.add(new MyGenericOne("String val 2 b"));
		listOfGenOne.add(new MyGenericOne("String val 3 c"));
		
		listOfGenTwo.add(new MyGenericTwo(1));
		listOfGenTwo.add(new MyGenericTwo(2));
		listOfGenTwo.add(new MyGenericTwo(3));
		
		showAllGenericValues(listOfGenOne);
		showAllGenericValues(listOfGenTwo);

	}
	
	
	public static void showAllGenericValues(List<? extends MyGenericBase> list) {
		Iterator<MyGenericBase> iter = (Iterator<MyGenericBase>) list.iterator();
		for(;iter.hasNext();)
			System.out.println("Value is " + iter.next().getValue());
	}
}
