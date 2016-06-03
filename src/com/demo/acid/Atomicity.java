package com.demo.acid;

import com.demo.acid.entity.ExceptionA;
import com.demo.acid.entity.ExceptionB;
import com.demo.acid.entity.ThreadA;
import com.demo.acid.entity.ThreadB;

/**
 * Tinh nguyen to CSDL
 * Hoac toan bo hanh dong cua giao dich duoc thuc hien
 * Hoac khong co hanh dong nao thuc hien
 * 
 */
public class Atomicity {

	public static void main(String[] args) {
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		
		processThread (a, b);
	}

//	T: Read(A,t1); 
//	If t1 > 500 { 
//	  Read(B,t2); 
//	  t2:=t2+500; stop 
//		 Write(B,t2); 
//		 t1:=t1-500; 
//		 Write(A,t1); 
//	}

	private static void processThread(ThreadA a, ThreadB b) {
		System.out.println(b.getValue());
		System.out.println(a.getValue());
		int delta = 500;
		
		int t1, t2;
		
		t1 = a.getValue();						//Read(A, t1)
		try {
			if (t1 > delta) {					//IF (t1 > 500) {
				t2 = b.getValue(); 				//	Read(B,t2);
				int temp = t2 + delta;			//	t2 := t2 + 500; 
				b.setValue(temp);				//	Write(B,t2);
				
				temp = t1 - delta; 				//	t1 := t1 - 500; <== Exception
				a.setValue(temp);				//	Write(A, t1);
												//}
			}
 		} catch (ExceptionB e) {
 			//roll back threadB
 			System.out.println("roll back threadB");
 			b.resetValue(b.getValue() - delta);
 		} catch (ExceptionA e) {
 			//roll back ThreadA
 			System.out.println("roll back threadA");
 			a.resetValue(a.getValue() + delta);
 			b.resetValue(b.getValue() - delta);
 		} finally {
 			//close connection
 		}
		System.out.println(b.getValue());
		System.out.println(a.getValue());
	}
}
