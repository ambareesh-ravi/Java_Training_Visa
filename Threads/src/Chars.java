
public class Chars implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.println(Thread.currentThread() + ":" + (char) i);
		}

	}

}
