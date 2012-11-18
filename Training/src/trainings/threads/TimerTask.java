package trainings.threads;

public class TimerTask implements Runnable {
	boolean canceled = false;
	long nextTime = -1;
	long period;
	boolean fixedRate;

	protected TimerTask() {
	}

	public boolean cancel() {
		if (canceled) return false;
		canceled = true;
		if (nextTime == -1) return false;
		return true;
	}
	
	public long scheduledExecutionTime() { return nextTime; }
	
	void schedule (long nextTime, long period, boolean isFixed) {
		this.nextTime = nextTime;
		this.period = period;
		this.fixedRate = isFixed;
	}
	
	boolean reschedule () {
		if (period == 0 || canceled) return false;
		if (fixedRate) nextTime+=period;
		else
			nextTime = System.currentTimeMillis() + period;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

}
