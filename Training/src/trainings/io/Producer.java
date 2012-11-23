package trainings.io;

import java.io.OutputStream;

public class Producer implements Runnable {
	OutputStream pouts;

	public Producer(OutputStream pouts) {
		this.pouts = pouts;
	}

	public void run() {
		int number;

		try {
			for (int n = 0; n < 5; n++) {
				number = (int) (n + 5);
				System.out.print("About to count " + number);
				pouts.write(number);
				System.out.print("\n");
				//Thread.sleep((long) (n * 1000 + Math.round(Math.random() * 100 + 1)));
			}
			pouts.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}