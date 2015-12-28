package camp.java.lambda;

public class HelloMain {

	public static void main(String[] args) {
		
		doWork(new HelloInterface() {
			@Override
			public void sayHello(String message) {
				System.out.println("Hello, " + message);
			}
		});
		
		doWork( (msg) -> System.out.println("Hello, " + msg) );

	}
	
	public static void doWork(HelloInterface hello) {
		hello.sayHello("Java");
	}
	
}