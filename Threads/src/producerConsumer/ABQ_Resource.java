package producerConsumer;

public class ABQ_Resource {

	private int data;
	private boolean flag = false;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public synchronized void sendData(int number) {
		while (true) {
			if (flag == false) {
				setData(number);
				flag= true;
				notify();
				return;
			} else {
				try {
					wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void receiveData() {
		int count=0;
		while (true) {
			if (flag == true) {
				count = 0;
				int d = getData();
				System.out.println(d);
				try {
					wait(1000); // To simulate the network delay
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				flag = false;
				notify();
			} else {
				try {
					wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			count++;
			if(count==3)
					return;
		}
	}

}
