package com.operatingsystem.synchronize;

public class PCMain {
	public static final byte[] STORE_TYPES = new byte[] { 0x0, 0x1, 0x2, 0x3 };
	public static final Algorithm[] ALGORITHM_TYPES = { Algorithm.Dekker,
			Algorithm.TestAndSet, Algorithm.Swap, Algorithm.JavaLibrary };

//	public static void main(String[] args) {
//		byte storeType = STORE_TYPES[0];
//		Algorithm algorithm = ALGORITHM_TYPES[0];
//		
//		CubbyHole cubbyHole = CubbyHole.getInstance();
//		cubbyHole.setStoreType(storeType);
//		Producer p1 = new Producer(cubbyHole, 1, algorithm);
//		Consumer c2 = new Consumer(cubbyHole, 2, algorithm);
//		
//		Thread t1 = new Thread(p1);
//		Thread t2 = new Thread(c2);
//		
//		t1.start();
//		t2.start();
//	}
	public static void main(String[] args) {
		System.out.println(random(500));
	}

	static int random(int n) {
	    return (int) Math.round( n * Math.random() - 0.5 ) ;
	  }
}