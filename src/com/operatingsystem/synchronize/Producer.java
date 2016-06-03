package com.operatingsystem.synchronize;

import static com.operatingsystem.synchronize.AlgorithmUtils.*;

public class Producer implements Runnable {
	private Algorithm algorithm;
	private Bool key;
	private CubbyHole cubbyhole;
	private int number;
	private int nLoop = 10;
	
	public Producer(CubbyHole c, int number) {
		this.cubbyhole = c;
		this.number = number;
		this.algorithm = Algorithm.Swap;
		key = new Bool(true);
	}

	public Producer(CubbyHole c, int number, Algorithm algorithm) {
		this(c, number);
		this.algorithm = algorithm;
	}

	public void run() {
		int i = 0; 
		
		while (i++ < nLoop) {
			startAlgorithm();
			
			cubbyhole.putData(i);
			System.out.format("Producer #%d put: %d\n", this.number, i);
			
			endAlgorithm();
			// ------------------------------------------------------
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	private void endAlgorithm() {
		switch (algorithm) {
		case Dekker:
			// 1. ----------
			cubbyhole.turn = 2;
			cubbyhole.providerFlag = false;
			break;
		case TestAndSet:
			// 2. ----------- TestAndSet
			Lock.bool = false;
			break;
		case JavaLibrary:
			//TODO
			break;
		default:
			// 3. ------------
			Lock.bool = false;
			break;
		}
	}

	private void startAlgorithm() {
		switch (algorithm) {
		case Dekker:
			// 1. --------
			while (cubbyhole.customerFlag == true) {
				if (cubbyhole.turn == 2) {
					cubbyhole.providerFlag = false;
					while (cubbyhole.turn == 2)
						;
					cubbyhole.providerFlag = true;
				}
			}
			// while (Dekker(cubbyhole, 2));
			break;
		case TestAndSet:
			// 2. -------- TestAndSet
			while (TestAndSet(Lock))
				;
			break;

		default:
			// 3. ------------
			key.bool = true;
			while (key.bool == true) {
				Swap(Lock, key);
				break;
			}
		}
	}
}
