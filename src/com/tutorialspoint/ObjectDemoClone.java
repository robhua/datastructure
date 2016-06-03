package com.tutorialspoint;

import java.util.GregorianCalendar;

public class ObjectDemoClone {

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	public static void main(String[] args) {

		// create a gregorian calendar, which is an object
		GregorianCalendar cal = new GregorianCalendar();

		// clone object cal into object y
		GregorianCalendar y = (GregorianCalendar) cal.clone();

		System.out.println(cal != y);
		System.out.println(cal.equals(y));
		System.out.println(cal.getClass());
		System.out.println(cal.getClass() == y.getClass());
		// print both cal and y
		System.out.println("" + cal.getTime());
		System.out.println("" + y.getTime());
	}
}