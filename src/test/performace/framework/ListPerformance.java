package test.performace.framework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListPerformance {
	static int reps = 1000;
	static Random rand = new Random();
	static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
	static List<Test<LinkedList<Integer>>> qTests = new ArrayList<Test<LinkedList<Integer>>>();

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		new Test<List<Integer>>("add") {

			@Override
			int test(List<Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
	
	static {
		// add values to list
		tests.add(new Test<List<Integer>>("add") {
			
			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int listSize = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					for (int j = 0; j < listSize; j++)
						list.add(j);
				}
				return loops * listSize;
			}
		});
		
		// get values from list
		tests.add(new Test<List<Integer>>("get") {
			
			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for (int i = 0; i < loops; i++)
					list.get(rand.nextInt(listSize));
				return loops;
			}
		});
		
		// set values to list
		tests.add(new Test<List<Integer>>("set") {
			
			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops * reps;
				int listSize = list.size();
				for (int i = 0; i < loops; i++)
					list.set(rand.nextInt(listSize), 47);
				return loops;
			}
		});
		
		// interadd values from list
		tests.add(new Test<List<Integer>>("iteradd") {
			
			@Override
			int test(List<Integer> list, TestParam tp) {
				final int LOOPS = 1000000;
				int half = list.size() / 2;
				ListIterator<Integer> it = list.listIterator(half);
				for (int i = 0; i < LOOPS; i++)
					it.add(47);
				return LOOPS;
			}
		});
		
		// insert values to list
		tests.add(new Test<List<Integer>>("insert") {
			
			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops;
				for (int i = 0; i < loops; i++)
					list.add(5, 47); // Minimize random access cost
				return loops;
			}
		});
		
		// remove values from list
		tests.add(new Test<List<Integer>>("remove") {
			
			@Override
			int test(List<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
//					list.addAll(new CountingIntegerList(size));
					while (list.size() > 5)
						list.remove(5); // Minimize random access cost
				}
				return loops * size;
			}
		});
	}
}
