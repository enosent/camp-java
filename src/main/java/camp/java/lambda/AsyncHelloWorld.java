package camp.java.lambda;

public class AsyncHelloWorld {

	public static class HelloWorld implements Runnable {

		@Override
		public void run() {
			System.out.println("Hello World");
		}
		
	}
	
	public static void main(String[] args) {
		new Thread(new HelloWorld()).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World");
				
			}
		}).start();
		
		new Thread(()-> System.out.println("Hello World")).start();
	}
}