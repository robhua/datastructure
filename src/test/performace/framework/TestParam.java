package test.performace.framework;

public class TestParam {
	public final int size;
	public final int loops;

	public TestParam(int size, int loops) {
		this.size = size;
		this.loops = loops;
	}

	// Create an array of TestParam from a varargs sequence:
	public static TestParam[] array(int... values) {
		int size = values.length / 2;
		TestParam[] result = new TestParam[size];
		
		int n = 0;
		for (int i = 0; i < size; i++)
			result[i] = new TestParam(values[n++], values[n++]);
		return result;
	}

	// Convert a String array to a TestParam array:
	public static TestParam[] array(String[] values) {
		int[] vals = new int[values.length];
		for (int i = 0; i < vals.length; i++)
			vals[i] = Integer.decode(values[i]);
		return array(vals);
	}

	
	public static void main(String[] args) {
		int[] values = new int[] {1, 2, 5, 3, 4, 6, 2};
		TestParam[] params = array(values);
		for (TestParam testParam : params) {
			System.out.println(testParam);
		}
		
		int size = values.length / 2;
		int n = 0;
		for (int i = 0; i < size; i++) {
			System.out.printf("[%d, %d]", values[n++], values[n++]);
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "TestParam [size=" + size + ", loops=" + loops + "]";
	}
}
