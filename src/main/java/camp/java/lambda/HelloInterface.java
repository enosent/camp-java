package camp.java.lambda;

@FunctionalInterface
public interface HelloInterface {
	
	public void sayHello(String message);
	
	default public void empty(String msg){
		System.out.println("!" + msg);
	}
	
}