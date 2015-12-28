package camp.java.stream;

import java.util.stream.LongStream;

import camp.java.util.TimeChecker;

// [원문] http://purluno.egloos.com/m/3006282
// [소스] http://pastebin.com/iRzzDy2F
public class StreamPerformanceMain {
	
	public static void main(String[] args) {
		System.err.println("running parallel operations...");
		
		TimeChecker<Long> tcParallel = TimeChecker.execute(() ->
			LongStream.rangeClosed(1, 10_000_000_000L).parallel()
					.filter(i -> i % 3 == 0 || i % 5 == 0)
					.sum()
				);
		
		System.err.println("running serial operations...");
		
		TimeChecker<Long> tcSerial = TimeChecker.execute(() ->
			LongStream.rangeClosed(1, 10_000_000_000L)
					.filter(i -> i % 3 == 0 || i % 5 == 0)
					.sum()
				);
		
		System.out.println("tcParallel:");
		System.out.printf("result: %d\n", tcParallel.getResult());
		System.out.printf("elapsed time: %,d ms\n", tcParallel.getTimeNanoseconds() / 1_000_000);
		System.out.println();
		
		System.out.println("tcSerial:");
		System.out.printf("result: %d\n", tcSerial.getResult());
		System.out.printf("elapsed time: %,d ms\n", tcSerial.getTimeNanoseconds() / 1_000_000);
		
		System.err.println("running for-loop operations...");
		
		long start = System.nanoTime();
		long sum = 0l;
		for(long i = 1; i <= 10_000_000_000L; i++) {
			if(i%3 == 0 || i%5 == 0) {
				sum += i;
			}
		}
		long timeNanoseconds = System.nanoTime() - start;
		
		System.out.println("for-loop:");
		System.out.printf("result: %d\n", sum);
		System.out.printf("elapsed time: %,d ms\n", timeNanoseconds / 1_000_000);
	}
}