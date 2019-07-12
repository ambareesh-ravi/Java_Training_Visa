import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
			Future<Integer> f1 = service.submit(new Sumer(1,100));
			Future<Integer> f2 = service.submit(new Sumer(900,1300));
			
			try {
				System.out.println(f1.get());
				System.out.println(f2.get());
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		service.shutdown();
	}

}
