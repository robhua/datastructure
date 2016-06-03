package com.operatingsystem.synchronize;

/**
 * Dokker's algorithm, TestAndSet's algorithm, Swap's algorithm
 * @author HungHM5
 *
 */
final public class AlgorithmUtils {
	/**
	 * Variable status
	 * lock = true  --> locked
	 * lock = false --> free
	 */
	static Bool Lock = new Bool();
	
	/**
	 * TestAndSet's algorithm will test and change value of a word
	 * @return
	 */
	static boolean TestAndSet(Bool target) {
		boolean rv = target.bool;
		target.bool = true;
		
		return rv;
	}
	
	/**
	 * Swap's algorithm will swap value of two word
	 */
	static void Swap(Bool a, Bool b){
		boolean temp = a.bool;
		a.bool = b.bool;
		b.bool = temp;
	}

	/**
	 * Dekker's algorithm use a single @turn shared variable
	 * 
	 * @param cubbyHole
	 * @param turn
	 *            a single shared variable
	 * @return
	 */
	//TODO need to check procedure Dekker's algorithm. Is it validate?
	static boolean  Dekker(CubbyHole cubbyHole, int turn) {
		if (turn == 1) {
			if (cubbyHole.providerFlag == true) {
				if (cubbyHole.turn == 1) {
					cubbyHole.customerFlag = false;

					while (cubbyHole.turn == 1)
						;

					cubbyHole.customerFlag = true;
					return true;
				}
			}

			return false;
		}
		else 
		{
			if (cubbyHole.customerFlag == true) {
				if (cubbyHole.turn == 2) {
					cubbyHole.providerFlag = false;

					while (cubbyHole.turn == 2)
						;

					cubbyHole.providerFlag = true;
					return true;
				}
			}

			return false;			
		}
	}
	
	/**
	 * Dekker's algorithm version2
	 * @param cubbyHole 
	 * @return
	 */
	boolean DekkerP2(CubbyHole cubbyHole) {
		if (cubbyHole.customerFlag == true) {
			if (cubbyHole.turn == 2) {
				cubbyHole.providerFlag = false;

				while (cubbyHole.turn == 2)
					;

				cubbyHole.providerFlag = true;
			}
		}

		return false;
	}
}

final class Bool {
	protected boolean bool;
	
	public Bool(){
		this.bool = false;
	}
	
	public Bool(boolean bool) {
		this.bool = bool;
	}
}
