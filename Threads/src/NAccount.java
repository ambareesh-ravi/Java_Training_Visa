import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NAccount {
	private double balance;
	private Lock ballock = new ReentrantLock(); //Another Lock is Read/Write Lock
	public NAccount(double balance) {
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
	public void deposit(String name, double amt) {
		try {
			ballock.lock();
		System.out.println(name + " trying to deposit " + amt);
		System.out.println(name + " getting balance");
		double bal = getBalance();
		System.out.println(name + " got balance : " + bal);
		bal += amt;
		System.out.println(name + " setting balance : " + bal);
		setBalance(bal);
		} finally {
			ballock.unlock();
		}
	}

	public void withdraw(String name, double amt) {
		try {
			ballock.lock();
		System.out.println(name + " trying to withdraw " + amt);
		System.out.println(name + " getting balance");
		double bal = getBalance();
		System.out.println(name + " got balance : " + bal);
		bal -= amt;
		System.out.println(name + " setting balance : " + bal);
		setBalance(bal);
		} finally {
			ballock.unlock();
		}
	}
}
