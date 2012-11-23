package trainings.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class JavaPipeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pipes setup is completed
		PipedInputStream pins = new PipedInputStream();
		PipedOutputStream pouts = null;
		try {
			pouts = new PipedOutputStream(pins);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// constructing the threads
		Producer producer = new Producer(pouts);
		Thread thread1 = new Thread(producer);
		Thread thread2 = new Thread(new Consumer(pins, "A"));
		Thread thread3 = new Thread(new Consumer(pins, "B"));
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
