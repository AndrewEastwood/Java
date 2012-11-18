package trainings.threads;

import java.util.Comparator;
import java.util.TreeSet;

public class Timer {

	TreeSet tasks = new TreeSet(new TimerTaskComparator());
	
	
	static class TimerTaskComparator implements Comparator<TimerTask> {

		@Override
		public int compare(TimerTask o1, TimerTask o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
}
