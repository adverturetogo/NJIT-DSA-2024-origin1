package oy.tol.tra;

import java.util.Arrays;

public  class Algorithms{
    public static int  binarySearch(int aValue,Integer[]arr,int from,int toIndex)
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
    public static int  binarySearch(String aValue,String[]arr,int from,int toIndex)
    {
       if(toIndex>=from)
       {
        int mid=from+(toIndex-from)/2;
        if(arr[mid]==aValue)
        {
            return mid;
        }
        if(arr[mid].compareTo(aValue)>0)
        {
            return binarySearch(aValue, arr, from, mid-1);
        }
        else{
            return binarySearch(aValue, arr, mid+1, toIndex);
        }
       }
       return -1;
    }
    
    public static  void sort(Integer[]arr)
    {
        Quicksort(arr, 0, arr.length-1);
    }
    public static  void sort(String[]arr)
    {
        Quicksort(arr, 0, arr.length-1);
    }
    public static void Quicksort(String[]arr,int left,int right)
    {
        if(left>right)
        {
            return;
        }
       String temp=arr[left];
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
        String akk=arr[j];
        arr[j]=arr[i];
        arr[i]=akk;
        }
       }
       arr[left]=arr[i];
       arr[i]=temp;
       Quicksort(arr,left,j-1);
       Quicksort(arr,j+1,right);
    }
    public static void Quicksort(Integer[]arr,int left,int right)
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
       Quicksort(arr,left,j-1);
       Quicksort(arr,j+1,right);
    }
    
  }