package oy.tol.tra;

import java.util.Arrays;

public  class Algorithms{
    public static int  binarySearch2(int aValue,Integer[]arr,int from,int toIndex)
    {
      if(from<=toIndex)
      {
        int mid=from+(toIndex-from)/2;
        if(arr[mid]<aValue)
        {
            return binarySearch(aValue, arr, mid+1, toIndex);
        }
        else if(arr[mid]==aValue)
        {
            return mid;
        }
        else{
            return binarySearch(aValue, arr, from, mid-1);
        }
      }    
      return -1;      
    }
   
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
    
    
    public static  <T extends Comparable<T>> void sort(T[]arr)
    {
        QuickSort(arr, 0, arr.length-1);
    }
   
    
    public static void Quicksort1(Integer[]arr,int left,int right)
    {
        if(left>right)
        {
            return;
        }
       int temp=arr[left];
       int i=left;
       int j=right;
       while(i<j)
       {
        while(arr[j].compareTo(temp)>=0&&i<j)
        {
           j--;
        }
          
        while(arr[i].compareTo(temp)<=0&&i<j)
        {
            i++;
        }
        if(i<j)
        {
        int akk=arr[j];
        arr[j]=arr[i];
        arr[i]=akk;
        }
       }
       arr[left]=arr[i];
       arr[i]=temp;
       Quicksort1(arr,left,j-1);
       Quicksort1(arr,j+1,right);
    }
    


    private static <T extends Comparable<T>>  void QuickSort(T[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            QuickSort(arr, left, partitionIndex - 1);
            QuickSort(arr, partitionIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>>  int partition(T[] arr, int left, int right) {
        T pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if  (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    private static <T extends Comparable<T>>  void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  }