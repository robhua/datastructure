package com.operatingsystem.synchronize;

/**
 * Some algorithm used in concurrent programming.
 * @author HungHM5
 */
public enum Algorithm {
	Dekker(1), TestAndSet(2), Swap(3), JavaLibrary(4);

	private int index;

	private Algorithm(int index) {
		this.index = index;
	}

	public int getAlgorithm() {
		return index;
	}
}
