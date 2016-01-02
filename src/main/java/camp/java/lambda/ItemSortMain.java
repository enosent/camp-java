package camp.java.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ItemSortMain {

	public static void main(String[] args) {
		Item[] items = new Item[]{
			new Item("test1",3),
			new Item("test2",1),
			new Item("test4",2)
		};
		
		System.out.println("# origin.");
		println(items);
		
		Arrays.sort(items, new Comparator<Item>() {

			@Override
			public int compare(Item item1, Item item2) {
				return item1.getWeight() - item2.getWeight();
			}
		});
		
		System.out.println("# comparator.");
		println(items);
		
		Arrays.sort(items, (Item item1, Item item2) -> {
			return item1.getWeight() - item2.getWeight();
		});
		
		System.out.println("# lambda-1.");
		println(items);
		
		Arrays.sort(items, (item1, item2) -> item1.getWeight() - item2.getWeight());
		
		System.out.println("# lambda-2.");
		println(items);
	}

	private static void println(Item[] items) {
		Stream.of(items).forEach(System.out::println);
		System.out.println();
	}
}

class Item {

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
	
	public Item(String name, int weight) {
		setName(name);
		setWeight(weight);
	}
	
	@Override
	public String toString() {
		return name + " (" + weight + ")";
	}
}