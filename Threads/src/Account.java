
public class Account {
	private double balance;
	public Account(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		try {
			Thread.sleep((long) (Math.random() * 2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return balance;
	}

	private void setBalance(double balance) {
		try {
			Thread.sleep((long) (Math.random() * 2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.balance = balance;
	}

	// put SYNCHRONIZED keyword to lock the object when this function is executed. 
	// It will not allow to execute any synchronized fn when this is executed. Acquires Critical Section LOCK.
	//For Locking the object (Synchronizing Blocks) :
	//		synchronize(Object ob) {			}
	//		synchronize(Class c)	{			}. For static functions.
	public synchronized void deposit(String name, double amt) {
		System.out.println(name + " trying to deposit " + amt);
		System.out.println(name + " getting balance");
		double bal = getBalance();
		System.out.println(name + " got balance : " + bal);
		bal += amt;
		System.out.println(name + " setting balance : " + bal);
		setBalance(bal);
		notifyAll();//All of them. notify() means one of them. (Object methods). To notify all that the lock will be released. 
		//In scenarios when Ambareesh waits for 15 seconds for insufficient balance but other thread has debited the money. 
	}

	public synchronized void withdraw(String name, double amt) {
		System.out.println(name + " trying to withdraw " + amt);
		int count = 0;
		while(amt > getBalance())
		{
			count++;
			if(count>3)
			{
				System.out.println("Transaction Failed!");
				return;
			}
			System.out.println("Insufficient Balance");
			try {
				wait(5000);// If no synchronized is used, then RunTime Exception because wait should be called only if the fn is synchronized 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(name + " getting balance");
		double bal = getBalance();
		System.out.println(name + " got balance : " + bal);
		bal -= amt;
		System.out.println(name + " setting balance : " + bal);
		setBalance(bal);
	}
}
