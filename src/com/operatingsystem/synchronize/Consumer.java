package com.operatingsystem.synchronize;

import static com.operatingsystem.synchronize.AlgorithmUtils.*;

public class Consumer implements Runnable {
	private Algorithm algorithm;
	private Bool key; 
	private CubbyHole cubbyhole;
	
	private int number;
	private int nLoop = 20;

	public Consumer(CubbyHole c, int number) {
		this.cubbyhole = c;
		this.number = number;
		this.algorithm = Algorithm.Swap;
		this.key = new Bool(true);
	}

	public Consumer(CubbyHole c, int number, Algorithm algorithm) {
		this(c, number);
		this.algorithm = algorithm;
	}

	public void run() {
		Number value = 0;
		int i = 0;
		while (i++ < nLoop) {
			startAlgorithm();

			value = cubbyhole.getData();
			if (value instanceof Integer)
				System.out.format("Consumer #%d got: %d\n", this.number, value);
			else
				System.out.format("Consumer #%d got: %f\n", this.number, value);

			endAlgorithm();
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}

	private void endAlgorithm() {
		switch (algorithm) {
		case Dekker:
			// 1. ------------- Dekker
			cubbyhole.turn = 1;
			cubbyhole.customerFlag = false;
			break;
		case TestAndSet:
			// 2. ------------- TestAndSet
			Lock.bool = false;
			break;
		case JavaLibrary:
			// TODO
			break;
		default:
			// 3. -------------
			Lock.bool = false;
			break;
		}
	}

	private void startAlgorithm() {
		switch (algorithm) {
		case Dekker:
			// 1. ------------ Dekker
			while (cubbyhole.providerFlag == true) {
				if (cubbyhole.turn == 1) {
					cubbyhole.customerFlag = false;
					while (cubbyhole.turn == 1)
						;
					cubbyhole.customerFlag = true;
				}
			}
			// while (Dekker(cubbyhole, 1));
			break;
		case TestAndSet:
			// 2. ------------ TestAndSet
			while (TestAndSet(Lock))
				;
			break;
		default:
			// 3. ------------
			key.bool = true;
			while (key.bool == true) {
				Swap(Lock, key);
			}
			break;
		}
	}
}
