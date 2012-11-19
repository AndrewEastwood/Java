package trainings.custom;

import java.util.*;


public class Exercise22 {
	private int i;

	Exercise22(int i) {
		this.i = i;
	}

	public String toString() {
		return "Exercise22 " + i;
	}

	public static void printArray(List<Exercise22> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	public static void main(String[] args) {
		List<Exercise22> linkedlist = new LinkedList<Exercise22>();
		for (int i = 0; i < 20; i++) {
			linkedlist.add(new Exercise22(i));
		}
		printArray(linkedlist);

		List<Exercise22> list = new LinkedList<Exercise22>(linkedlist.subList(8, 16));
		 System.out.println();
		 printArray(list);
		synchronized (linkedlist) {
			linkedlist.removeAll(list);
		}
		printArray(linkedlist);
	}
}
