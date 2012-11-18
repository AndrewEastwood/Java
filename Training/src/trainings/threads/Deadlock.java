package trainings.threads;

public class Deadlock {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Object res1 = "resource 1";
		final Object res2 = "resource";
		
		Thread th1 = new Thread() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (res1) {
					
					System.out.println("Thread One Holds resource One");
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					synchronized (res2) {
						System.out.println("Thread One Holds resource Two");
					}
					
				}
				
			}
		};
		Thread th2 = new Thread() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (res2) {
					
					System.out.println("Thread One Holds resource Two");
					
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					synchronized (res1) {
						System.out.println("Thread One Holds resource One");
					}
					
				}
				
			}
		};
		
		th1.start();
		th2.start();

		
		System.out.println("END");
	}

}
