
public class NAccountClient {

	public static void main(String[] args) {
		NAccount account = new NAccount(5000);
		NTransactionThread t1 = new NTransactionThread(account, TransactionType.DEBIT, "Ambareesh", 6000);
		NTransactionThread t2 = new NTransactionThread(account, TransactionType.CREDIT, "Gokul Anand", 3500);
		NTransactionThread t3 = new NTransactionThread(account, TransactionType.CREDIT, "Lidwin", 6000);
		
		
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t2.start();
		t3.start();

		try {
			//join is used to tell the caller thread(main) to wait until all the threads finishes executing
			t1.join(); t2.join(); t3.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final Balance "+ account.getBalance());
	}

}
