package multiple_threads;

public class TestMultiThreads {

	public static void main(String[] args) {
	
		MultiThreadDemo T1 = new MultiThreadDemo ("Thread-1");
		T1.start();
						
		MultiThreadDemo T2 = new MultiThreadDemo ("Thread-2");
		T2.start();
		
	}

}
