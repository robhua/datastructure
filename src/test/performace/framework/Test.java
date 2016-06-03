package test.performace.framework;

public abstract class Test<T> {
	public String name;

	public Test(String name) {
		this.name = name;
	}

	// Override this Template Method for different tests.
	// Returns actual number of repetitions of test.
	abstract int test(T container, TestParam tp);
}
