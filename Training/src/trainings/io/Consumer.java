package trainings.io;

import java.io.InputStream;

public class Consumer implements Runnable {
	InputStream pins;
	String name;

	public Consumer(InputStream pins, String name) {
		this.pins = pins;
		this.name = name;
	}

	public void run() {
		int number;

		try {
			while ((number = pins.read()) != -1) {
				System.out.println(this.name + ": received " + (int) number);
				Thread.sleep((long) (1000 + Math.round(Math.random() * 100 + 1)));
			}
			System.out.println(this.name + ": Pipe closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}