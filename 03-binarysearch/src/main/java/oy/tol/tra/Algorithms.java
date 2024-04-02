package oy.tol.tra;

import java.util.Arrays;

public  class Algorithms{
    public static <T extends Comparable<T>> int binarySearch(T target, T[] arr, int from, int toIndex) {
        if (from <= toIndex) {
            int mid = from + (toIndex - from) / 2;
    
            int compareResult =  arr[mid].compareTo(target);
            
            if (compareResult < 0) {
                return binarySearch(target, arr, mid + 1, toIndex);
            } else if (compareResult == 0) {
                return mid; // return mid
            } else {
                return binarySearch(target, arr, from, mid - 1);
            }
        }
        
        return -1;
    }
    public static <T extends Comparable<T>> void sort(T [] array) {
        if (array == null || array.length <= 1) {
            return;
        }
  
        for (int i = 1; i < array.length; i++) {
            T current = array[i];
            int j = i - 1;
  
            while (j >= 0 && array[j] .compareTo(current) >0) {
                array[j + 1] = array[j];
                j--;
            }
  
            array[j + 1] = current;
        }
    }
     // ...
     public static <T> void reverse(T [] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
     }
}
  }