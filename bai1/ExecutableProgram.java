package synch;

public class ExecutableProgram {
	
	public static void main(String[] args) {
		
//		ResourcesExploiter resource = new ResourcesExploiter(0);
		ResourcesExploiterWithLock resource = new ResourcesExploiterWithLock(0);
		
//		ThreadedWorkerWithoutSync worker1 = new ThreadedWorkerWithoutSync(resource);
//		ThreadedWorkerWithoutSync worker2 = new ThreadedWorkerWithoutSync(resource);
//		ThreadedWorkerWithoutSync worker3 = new ThreadedWorkerWithoutSync(resource);
		
//		ThreadedWorkerWithSync worker1 = new ThreadedWorkerWithSync(resource);
//		ThreadedWorkerWithSync worker2 = new ThreadedWorkerWithSync(resource);
//		ThreadedWorkerWithSync worker3 = new ThreadedWorkerWithSync(resource);
		
		ThreadedWorkerWithLock worker1 = new ThreadedWorkerWithLock(resource);
		ThreadedWorkerWithLock worker2 = new ThreadedWorkerWithLock(resource);
		ThreadedWorkerWithLock worker3 = new ThreadedWorkerWithLock(resource);
		
		worker1.start();
		worker2.start();
		worker3.start();
		
		try {
			worker1.join();
			worker2.join();
			worker3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("The value of resource: " + resource.getRsc());
	}

}
