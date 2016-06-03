package com.demo.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ArrayUtils {
    private ArrayUtils() {        
    }
    
	public static List<Integer> convertIntArrayToIntegerList(int... intArr) {
		if (intArr == null) {
			return null;
		}

		List<Integer> list = new ArrayList<Integer>(intArr.length);
		for (int i : intArr) {
			list.add(Integer.valueOf(i));
		}
		return list;
	}

	public static Set<Short> convertShortArrayToShortSet(short... shortArr) {
		if (shortArr == null) {
			return null;
		}

		Set<Short> set = new HashSet<Short>(shortArr.length);
		for (short val : shortArr) {
			set.add(Short.valueOf(val));
		}
		return set;
	}

	public static Set<Integer> convertntArrayToIntegerSet(int... intArr) {
		if (intArr == null) {
			return null;
		}

		Set<Integer> set = new HashSet<Integer>(intArr.length);
		for (int i : intArr) {
			set.add(Integer.valueOf(i));
		}
		return set;
	}
	
    /**
     * Check if array contains specified value
     * @param array
     * @param value
     * @return
     */
    public static <T> int indexOfArray(T[] array, T value) {
    	int index = -1;
        if (array == null || array.length == 0) {
            return index;
        }
        
        int len = array.length;
        for (int i = 0; i < len && index == -1; i++) {
        	T item = array[i];
        	if (item == value || (item != null && item.equals(value))) {
        		index = i;
        	}
        }
        
        return index;
    }

    public static int indexOfArray(float [] array, float value) {
    	int index = -1;
        if (array == null || array.length == 0) {
            return index;
        }
        
        int len = array.length;
		for (int i=0; i < len; i++) {
			if (array[i] == value) {
				index = i;
				break;
			}
		}
        return index;
    }

    public static int indexOfArray(byte[] array, byte value) {
    	int index = -1;
        if (array == null || array.length == 0) {
            return index;
        }
        
        int len = array.length;
		for (int i=0; i < len; i++) {
			if (array[i] == value) {
				index = i;
				break;
			}
		}
        return index;
    }
    
    public static int indexOfArray(int[] array, int value) {
    	int index = -1;
        if (array == null || array.length == 0) {
            return index;
        }
        
        int len = array.length;
		for (int i=0; i < len; i++) {
			if (array[i] == value) {
				index = i;
				break;
			}
		}
        return index;
    }
    
    public static void main(String[] args) {
    	int[] intArr = new int[2];
    	intArr[0] = 1;
    	intArr[1] = 2;
    	
		Integer[] arr = new Integer[2];
		arr[0] = null;
		arr[1] = 2;
		System.out.println(arr);
		System.out.println(indexOfArray(arr, null));
		System.out.println(indexOfArray(intArr, 2));
				
	}
    
}
