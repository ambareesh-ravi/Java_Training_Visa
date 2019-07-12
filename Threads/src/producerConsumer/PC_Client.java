package producerConsumer;

public class PC_Client {

	public static void main(String[] args) {

		Resource r = new Resource();
		PC_Transaction producer = new PC_Transaction(r,"P");
		PC_Transaction consumer = new PC_Transaction(r,"C");
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Process Terminated");
	}

}
