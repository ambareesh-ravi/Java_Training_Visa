package producerConsumer;

public class PC_Transaction extends Thread {
	private Resource r;
	private String type;
	public PC_Transaction(Resource r, String type) {
		this.r = r;
		this.type = type;
	}
	
	@Override
	public void run() {
		if(type.equals("P")) {
			for (int i = 1; i <= 10; i++) {
				r.sendData(i);
			}
		}
		else {
			r.receiveData();
		}
	}

}
