package camp.java.stream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStreamMain {

	public static final String FILE_NAME = "logstash_temp_log.csv";

	public static final String LOG_FILE = System.getProperty("user.home") + File.separator + FILE_NAME;
	
	public static void main(String[] args) throws IOException {
		
		Files.lines(Paths.get(LOG_FILE))
			.map(text -> {
				String[] words = text.split(",");
				String txt = words[0]	;
				return txt;
			})
			.distinct()
			.limit(100)
			.sorted()
			.forEach(System.out::println);
	}
}
