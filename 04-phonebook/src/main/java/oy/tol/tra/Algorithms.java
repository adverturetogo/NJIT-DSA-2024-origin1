package oy.tol.tra;
import java.util.function.Predicate;
import java.util.Comparator;


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
    
        public static <T> void sortWithComparator(T[] arr, Comparator<? super T> comparator) {
            int n = arr.length;
            boolean swapped;
    
            do {
                swapped = false;
                for (int i = 0; i < n - 1; i++) {
                    if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                        T temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        swapped = true;
                    }
                }
                n--;
            } while (swapped);
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
    public static  <T extends Comparable<T>> void fastSort(T[]arr)
        {
            QuickSort(arr, 0, arr.length-1);
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
    
    public static <T extends Comparable<T>> int partitionByRule(T[]arr,int count,Predicate<T> rule)
    
    {
        for(int i=0;i<count;i++)
        {
            if(rule.test(arr[i]))
            {
                for(int j=i;j<count;j++)
                {
                    if(!rule.test(arr[j]))
                    {
                        arr[j]=arr[i];
                        break;
                    }
                }
            }
        }
        for(int i=0;i<count;i++)
        {
            if(rule.test(arr[i]))
            {
                return i;
            }
        }
        return 0;
    }

    
    public static <T extends Comparable<T>>void mergeSort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        @SuppressWarnings("unchecked")
        T[] sorted = (T[]) new Object[arr.length];
        mergeSort1(arr, sorted, 0, arr.length - 1);
    }

    private static<T extends Comparable<T>> void mergeSort1(T[] arr, T[] sorted, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort1(arr, sorted, start, mid);
            mergeSort1(arr, sorted, mid + 1, end);
            merge(arr, sorted, start, mid, end);
        }
    }

    private static  <T extends Comparable<T>> void merge(T[] arr, T[] sorted, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                sorted[k++] = arr[i++];
            } else {
                sorted[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            sorted[k++] = arr[i++];
        }

        while (j <= end) {
            sorted[k++] = arr[j++];
        }

        for (k = start; k <= end; k++) {
            arr[k] = sorted[k];
        }
    }
  }