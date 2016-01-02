package camp.java.data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Data {

	private String name;
	private int weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Data() {}
	public Data(String name, int weight) {
		setName(name);
		setWeight(weight);
	}
	
	public List<Data> init(boolean nullable) {
		if(nullable) {
			return null;
		} else {
			List<Data> datas = IntStream.rangeClosed(1, 10000).mapToObj(i -> new Data("name-"+i, i)).collect(Collectors.toList());
			return datas;
		}
	}
	
	public void run() {
		System.out.println(getName() + " (" + getWeight() + ")");
	}
	
	public static Data empty() {
		return new Data("empty", 0);
	}
	
	@Override
	public String toString() {
		return "# " + name + " (" + weight +")";
	}
}