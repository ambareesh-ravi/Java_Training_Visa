
public class ThreadExample {

	public static void main(String[] args) {
		Numbers t1 = new Numbers(1,400);
		Numbers t2 = new Numbers(900,1200);
		Chars ch = new Chars();
		Thread t3 = new Thread();
		//Since t3 is created using Runnable interface(ch). When t3.start() is called, it internally calls the run method of Chars class.
		t3.start();
		t1.start();
		//Before starting t2 only you can change it as daemon thread 
		t2.setDaemon(true);
		t2.start();
		doTask();

	}

	private static void doTask() {
		Thread t = Thread.currentThread();
		System.out.println("Name "+t.getName());
		System.out.println("Priority "+t.getPriority());
		System.out.println("Thread Group name "+t.getThreadGroup().getName());
		/*
		 * JRE  waits for the status of the last NonDaemon thread before it terminates.
		 */
		System.out.println("Daemon "+t.isDaemon());
	}

}
