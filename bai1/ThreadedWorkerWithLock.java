package synch;

public class ThreadedWorkerWithLock extends Thread {
	private ResourcesExploiterWithLock rExp;

	ThreadedWorkerWithLock(ResourcesExploiterWithLock obj) {
		rExp = obj;
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		for (int i = 0; i < 1000; i++) {
			rExp.exploit();
			System.out.println("Thread: " + threadName + " exploit resource: " + rExp.getRsc());
		}

	}
}
