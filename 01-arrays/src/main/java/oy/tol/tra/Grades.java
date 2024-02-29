package oy.tol.tra;
import java.util.Arrays;;
/**
 * A simple array of student grades to be used in testing
 * misbehaving algorithm for reversing the array.
 */
public class Grades {
   
   private Integer [] grades = null;

   /**
    * A constructor for building IntArrays.
    * @param grades the plain Java integer array with numbers to add.
    */
   public Grades(Integer [] grades) {
      this.grades = new Integer [grades.length];
      for (int counter = 0; counter < grades.length; counter++) {
         this.grades[counter] = grades[counter];
         
      }
   }

   /**
    * The method to reverse the internal Java int array.
    */
   public void reverse() {
      /* TODO:
       1. Edit the test data files to see if the reverse() really works or not.
       2. Execute the IntArrayTests to see that some of them fail.
       3. Study the code below and try to find what is the issue.
       4. Use the debugger to see the execution and variable values if necessary.
       5. Fix the issue.
       6. Transform the algorithm to <strong>use</strong> the generic one from Algorithms.java, as instructed in the readme file.
      */
      int left = 0;
      int right = grades.length - 1;
      while (left < right) {
          int temp = grades[left];
          grades[left] = grades[right];
          grades[right] = temp;
          left++;
          right--;
      }
      
   }

   /**
    * Sorts the array to ascending order.
    */
    
    public static void insertionSort(Integer[] grades2) {
      if (grades2 == null || grades2.length <= 1) {
          return;
      }

      for (int i = 1; i < grades2.length; i++) {
          int current = grades2[i];
          int j = i - 1;

          while (j >= 0 && grades2[j] > current) {
              grades2[j + 1] = grades2[j];
              j--;
          }

          grades2[j + 1] = current;
      }
  }
   public void sort() {
      /* TODO:
       1. Edit the test data files to see if the sort() really works or not.
       2. Execute the IntArrayTests to see that some of them fail.
       3. Study the code below and try to find what is the issue.
       4. Use the debugger to see the execution and variable values if necessary.
       5. Fix the issue.
       6. Transform the algorithm to <strong>use</strong> the generic one from Algorithms.java as instructed in the readme file.
      */
      insertionSort(grades);

   }

   /**
    * Returns the plain Java int [] array for investigation.
    * @return The int array.
    */
   public Integer [] getArray() {
      return grades;
   }
}
