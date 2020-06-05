package synch;

public class ThreadedWorkerWithSync extends Thread {
	private ResourcesExploiter rExp;

	public ThreadedWorkerWithSync(ResourcesExploiter obj) {
		rExp = obj;
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		
		synchronized(rExp){
		for (int i = 0; i < 1000; i++) {
			rExp.exploit();
			System.out.println("Thread: " + threadName + " exploit resource: " + rExp.getRsc());
		}
		}
	}
}
