package camp.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.java.data.Data;

public class StreamTestMain {

	public static void main(String[] args) {
		List<Data> list = new Data().init(false);
		
		list.stream().filter(data -> "name-10000".equals(data.getName()))
			.findFirst()
			.ifPresent(data -> data.run());
		

		Data data2 = list.stream().filter(data -> "name-10001".equals(data.getName()))
			.findFirst()
			.orElseGet(() -> Data.empty());
		
		data2.run();
		
		List<String> collect = list.stream().map(data -> data.getName())
			.collect(Collectors.toList());
		collect.forEach(System.out::println);
	}
}
