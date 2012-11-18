package trainings.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadDemo extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++)
			compute("Demo");
	}

	public static void main(String[] args) {
		ThreadDemo th1 = new ThreadDemo();

		Thread th2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++)
					compute("Runnable");
			}
		});
		
		
		th1.start();
		

		for (int i = 0; i < 5; i++)
			compute("Main");
		
		th2.start();
		
		
	}

	static ThreadLocal<Integer> numCalls = new ThreadLocal<Integer>();

	static synchronized void compute(String caller) {
		Integer n = numCalls.get();
		if (n == null)
			n = new Integer(1);
		else
			n = new Integer(n.intValue() + 1);
		numCalls.set(n);

		for (int i = 0, j = 0; i < 10000; i++)
			System.out.println(String.format("from %s = [%d]", caller, j++));

		try {
			Thread.sleep((int) Math.random() * 100 + 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			Logger.getAnonymousLogger().log(Level.WARNING, e.getMessage());
		}
		Thread.yield();
	}
}
