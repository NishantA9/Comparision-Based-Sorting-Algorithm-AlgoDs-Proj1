package algorithm;

import java.util.Arrays; 
import java.io.FileWriter; 
import java.io.IOException; 
public class calTime { 
 public static void Sorting(int[] randArray,String opHead) { 
  Arrays.sort(randArray); 
  calcTime(randArray,opHead); 
 } 
 public static void revSorted(int[] randArray,String opHead) { 
  int[] revarraySortay= revSortedArr(randArray); 
  calcTime(revarraySortay,opHead); 
 } 
 public static void randSorted(int[] randArray,String opHead) { 
  int[] arr1=Arrays.copyOf(randArray, randArray.length); 
  calcTime(arr1,opHead); 
 } 
  private static int[] revSortedArr(int randarr[]) {   
   int arrIp[]= Arrays.copyOf(randarr,randarr.length); 
   int length = arrIp.length;  
         for (int i=1; i<length; i++)  
         {  
             int j = arrIp[i];  
             int k = i-1; 
             while (k>=0 && arrIp[k] < j)  
             {  
                 arrIp[k+1] = arrIp[k];  
                 k = k-1;  
             }  
             arrIp[k+1] = j;  
         }  
   return arrIp; 
  } 
  static void calcTime(int arrayInt[],String a) { 
   try { 
  FileWriter opFile = new FileWriter("C:\\Users\\firee\\OneDrive\\Desktop\\Project_1\\myOutput.txt",true); 
  opFile.write('\n'+a+'\n'); 
  int arraySort[] = Arrays.copyOf(arrayInt, arrayInt.length); 
  int arraySort1[] = Arrays.copyOf(arraySort, arraySort.length); 
  int arraySort2[] = Arrays.copyOf(arraySort, arraySort.length); 
  int arraySort3[] = Arrays.copyOf(arraySort, arraySort.length); 
  int arraySort4[] = Arrays.copyOf(arraySort, arraySort.length); 
 
  System.out.println("Array before the sorting algorithm: "+Arrays.toString(arraySort)); 
 
  //Insertion Sort Code
        long insertSortTimeStart = System.nanoTime(); 
        AllSortingAlgorithm.algoInsertionSort(arraySort); 
        long insertSortEndTime = System.nanoTime(); 
        System.out.println("------ Insertion Sort ------"); 
        System.out.println("The Execution Time for Insertion Sort is  "+'\t'+(insertSortEndTime-insertSortTimeStart)+ " nanoseconds"); 
        opFile.write("\n------ Insertion Sort ------ \n"); 
        opFile.write("The Execution Time for Insertion Sort is "+'\t'+(insertSortEndTime-insertSortTimeStart)+ " nanoseconds"+'\n'); 
        System.out.println("Ip Elements Sorted: "+Arrays.toString(arraySort)+'\n'); 
         
   // Merge Sort Code
        long  mergeSortTimeStart = System.nanoTime();      
        AllSortingAlgorithm.algoMergeSort(0, arraySort3.length-1,arraySort3);  
        long mergeSortEndTime = System.nanoTime(); 
        System.out.println("------ Merge Sort ------"); 
        System.out.println("The Execution Time for Merge Sort is "+'\t'+(mergeSortEndTime-mergeSortTimeStart)+ " nanoseconds"); 
        opFile.write("\n------ Merge Sort ------\n"); 
        opFile.write("\nThe Execution Time for Merge Sort is "+'\t'+(mergeSortEndTime-mergeSortTimeStart)+ " nanoseconds"+'\n'); 
        System.out.println("Ip Elements Sorted: "+Arrays.toString(arraySort3)+'\n');      
         
    // Heap Sort Code
        long heapSortTimeStart = System.nanoTime();      
        AllSortingAlgorithm.heapSortAlgo(arraySort4); 
        long heapSortEndTime = System.nanoTime(); 
        System.out.println("------ Heap Sorting ------"); 
        System.out.println("The Execution Time for Heap Sort is "+'\t'+(heapSortEndTime-heapSortTimeStart)+" nanoseconds");   
        opFile.write("\n------ Heap Sorting ------\n"); 
        opFile.write("\n The Execution Time for Heap Sort is"+'\t'+(heapSortEndTime-heapSortTimeStart)+ " nanoseconds"+'\n'); 
        System.out.println("Ip Elements Sorted: "+Arrays.toString(arraySort4)+"\n"); 
         
    // In-Place QuickSorting Code
        long inplacequickSortTimeStart = System.nanoTime(); 
        AllSortingAlgorithm.algoInPlaceQuickSort(0, arraySort2.length-1,arraySort2); 
        long inplacequickSortEndTime = System.nanoTime(); 
        System.out.println("------ Inplace Quick Sorting ------"); 
        System.out.println(" The Execution Time for Inplace Quick is "+'\t'+(inplacequickSortEndTime-inplacequickSortTimeStart)+ " nanoseconds"); 
        opFile.write("\n------ Inplace Quick Sorting ------\n"); 
        opFile.write("\nThe Execution Time for Inplace Quick is "+'\t'+(inplacequickSortEndTime-inplacequickSortTimeStart)+ " nanoseconds"+'\n'); 
        System.out.println("Ip Elements Sorted: "+Arrays.toString(arraySort2)+"\n"); 
         
    // Modified QuickSorting Code
        long modifiedquickSortTimeStart = System.nanoTime(); 
        AllSortingAlgorithm.algoModifiedQuickSort(0,arraySort1.length-1,arraySort1); 
        long modifiedquickSortEndTime = System.nanoTime(); 
        System.out.println("------ Modified Quick Sorting -------"); 
        System.out.println(" The Execution Time for Modified Quick Sort is "+'\t'+(modifiedquickSortEndTime-modifiedquickSortTimeStart)+ " nanoseconds"); 
        System.out.println("Ip Elements Sorted: "+Arrays.toString(arraySort1)); 
        opFile.write("\n------ Modified Quick Sorting ------\n"); 
        opFile.write("\nThe Execution Time for Modified Quick Sort is "+'\t'+(modifiedquickSortEndTime-modifiedquickSortTimeStart)+ " nanoseconds"+'\n'); 
        opFile.close(); 
   } 
   catch (IOException e) { 
        System.out.println("An Error occured, please check!!!"); 
        e.printStackTrace(); 
      } 
 }   
} 