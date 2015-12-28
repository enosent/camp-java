package camp.java.util;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * 코드의 실행 시간을 편하게 체크할 수 있게 만든 클래스
 *
 * @param <T> 코드의 리턴 타입
 * http://pastebin.com/8bMv1r7M
 */
public class TimeChecker<T> {
	/**
	 * 특정 코드에 대한 TimeChecker 객체를 만든다. 실행하지는 않는다.
	 *
	 * @param supplier 실행할 코드 (Java 8 lambda expression 권장)
	 * @param <T>      코드의 리턴 타입
	 * @return TimeChecker 객체
	 */
	public static <T> TimeChecker<T> create(Supplier<T> supplier) {
		return new TimeChecker<T>(supplier);
	}

	/**
	 * 특정 코드에 대한 TimeChecker 객체를 만들어 실행한다.
	 *
	 * @param supplier 실행할 코드 (Java 8 lambda expression 권장)
	 * @param <T>      코드의 리턴 타입
	 * @return TimeChecker 객체
	 */
	public static <T> TimeChecker<T> execute(Supplier<T> supplier) {
		TimeChecker<T> tc = create(supplier);
		tc.execute();
		return tc;
	}

	private Supplier<T> supplier;

	private Optional<T> result = Optional.empty();

	private long timeNanoseconds;

	/**
	 * 특정 코드에 대한 TimeChecker 객체 생성자
	 *
	 * @param supplier 실행할 코드 (Java 8 lambda expression 권장)
	 */
	public TimeChecker(Supplier<T> supplier) {
		this.supplier = supplier;
	}

	/**
	 * 코드를 실행하고 소요시간을 측정한다. (System.nanoTime() 활용)
	 */
	public void execute() {
		long start = System.nanoTime();
		T res = supplier.get();
		timeNanoseconds = System.nanoTime() - start;
		result = Optional.of(res);
	}

	/**
	 * 실행한 코드의 리턴 값을 받는다. 아직 실행하지 않는 등의 이유로
	 * 리턴 값이 없으면 NoSuchElementException을 발생시킨다.
	 *
	 * @return 리턴 값
	 */
	public T getResult() {
		return result.get();
	}

	/**
	 * 코드의 실행 소요 시간을 nanoseconds 단위로 리턴한다.
	 *
	 * @return 코드의 실행 소요 시간 (nanoseconds)
	 */
	public long getTimeNanoseconds() {
		return timeNanoseconds;
	}
}