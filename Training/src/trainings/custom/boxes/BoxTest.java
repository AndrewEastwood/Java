package trainings.custom.boxes;

public class BoxTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BoxContainer<String> stringBoxes = new BoxContainer<String>();
		stringBoxes.putContent("Phone");
		stringBoxes.putContent("PC");
		stringBoxes.putContent("Table");
		stringBoxes.putContent("Mug");
		printBoxes(stringBoxes);
		
		
	}
	
	private static void printBoxes(BoxContainer<?> boxList) {
		while(!boxList.isEmpty())
			System.out.println(boxList.popContent());
	}

}
