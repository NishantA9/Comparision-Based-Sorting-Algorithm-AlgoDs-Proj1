package algorithm;

import java.util.Random;

public class AllSortingAlgorithm { 
	  
	 private static final Random randNums = new Random(); 
	 private static final int RANGE_OF_NUMS = 10000000; 
	  
	    public static int[] getIntRandNos(int arrSize) { 
	  int[] array = new int[arrSize]; 
	  for(int i = 0; i < array.length; i++) { 
	   array[i] = randNums.nextInt(RANGE_OF_NUMS); 
	  } 
	  return array; 
	 } 
	 //***** Insertion sort Code ***** 
	    static void algoInsertionSort(int randIpArray[]) {  
	        int n = randIpArray.length;  
	        for (int i=1; i<n; ++i)  
	        {  
	            int key = randIpArray[i];  
	            int j = i-1; 
	            while (j>=0 && randIpArray[j] > key)  
	            {  
	                randIpArray[j+1] = randIpArray[j];  
	                j = j-1;  
	            }  
	            randIpArray[j+1] = key;  
	        }  
	    }    
	    //*****  Merge sort Code ***** 
	    static void algoMergeSort(int left, int right,int arrayIP[])  
	    {  
	        if (left < right)  
	        {  
	            int middle = (left+right)/2; 
	            algoMergeSort(left, middle,arrayIP);  
	            algoMergeSort(middle+1, right,arrayIP);  
	            algoMerge(left, middle, right,arrayIP);  
	            
	        }  
	    } 
	  private static void algoMerge(int left, int middle, int right,int randIpArray[])  
	     {  
	         int m = middle - left + 1;  
	         int n = right - middle; 
	         int temp1[] = new int [m];  
	         int temp2[] = new int [n]; 
	         for (int i=0; i<m; i++)  
	             temp1[i] = randIpArray[left + i];  
	         for (int j=0; j<n; j++)  
	             temp2[j] = randIpArray[middle + 1+ j]; 
	         int i = 0, j = 0, key = left;  
	         while (i < m && j < n)  
	         {  
	             if (temp1[i] <= temp2[j])  
	             {  
	                 randIpArray[key] = temp1[i];  
	                 i++;  
	             }  
	             else 
	             {  
	                 randIpArray[key] = temp2[j];  
	                 j++;  
	             }  
	             key++;  
	         }  
	         while (i < m)  
	         {  
	             randIpArray[key] = temp1[i];  
	             i++;  
	             key++;  
	         }  
	         while (j < n)  
	         {  
	             randIpArray[key] = temp2[j];  
	             j++;  
	             key++;  
	         }  
	     }  
	   public static void heapifyOp(int a, int b,int randIpArray[]) 
	     { 
	         int big = b; 
	         int l = 2*b + 1; 
	         int r = 2*b + 2;   
	   
	         if (l < a && randIpArray[l] > randIpArray[big]) 
	             big = l; 
	         if (r < a && randIpArray[r] > randIpArray[big]) 
	             big = r; 
	         if (big != b) 
	         { 
	             int swapVal = randIpArray[b]; 
	             randIpArray[b] = randIpArray[big]; 
	             randIpArray[big] = swapVal; 
	   
	             heapifyOp( a, big,randIpArray); 
	         } 
	     } 
	     //*****  Heap sort Code ***** 
	     public static void heapSortAlgo(int randIpArray[]) 
	     { 
	         int n = randIpArray.length; 
	         for (int i = n / 2 - 1; i >= 0; i--) { 
	           heapifyOp( n, i,randIpArray); 
	         } 
	         for (int i=n-1; i>=0; i--) 
	         { 
	             int temp = randIpArray[0]; 
	             randIpArray[0] = randIpArray[i]; 
	             randIpArray[i] = temp; 
	             heapifyOp( i, 0,randIpArray); 
	         } 
	     } 
	     
	     //***** In-Place quick sort Code ***** 
	 static void algoInPlaceQuickSort( int leftint, int rightint,int randIpArray[]) { 
	  if(leftint >= rightint) 
	   return; 
	  final int intRandom = rightint - leftint + 1; 
	  int pivot = randNums.nextInt(intRandom) + leftint; 
	  int newPivot = algoInPlacePartition(leftint, rightint, pivot,randIpArray); 
	   
	  algoInPlaceQuickSort(leftint, newPivot-1,randIpArray); 
	  algoInPlaceQuickSort(newPivot+1, rightint,randIpArray); 
	 }  
	 private static int algoInPlacePartition(int leftint, int rightint, int pivot,int 
	randIpArray[]) { 
	  int pivotTemp = randIpArray[pivot]; 
	  swapVal( pivot, rightint,randIpArray); 
	  int temp = leftint; 
	  for(int i = leftint; i <= (rightint - 1); i++) { 
	          if(randIpArray[i] < pivotTemp) { 
	              swapVal( i, temp,randIpArray); 
	              temp++; 
	          } 
	      } 
	      swapVal( temp, rightint,randIpArray); 
	      return temp; 
	 } 
	 
	    //*****  Modified Quick Sort Code ***** 
	 static void algoModifiedQuickSort(int leftint, int rightint,int[] ipArr)  
	 {   
	  if(leftint + 15 <= rightint)  
	  { 
	   int pivot = getMedianVal(leftint, rightint,ipArr); 
	   int middle = getMiddleVal( leftint, rightint, pivot,ipArr); 
	   algoModifiedQuickSort(leftint, middle-1,ipArr ); 
	   algoModifiedQuickSort(middle+1, rightint,ipArr );   
	  } 
	  else  
	  { 
	   algoInsertionSort(ipArr); 
	  } 
	 }  
	 private static int getMiddleVal( int leftint, int rightint, int pivot,int[] 
	ipArr)  
	 { 
	  int i = leftint, j = rightint - 1; 
	  while(true)  
	  { 
	   while(ipArr[++i] < pivot); 
	   while(pivot < ipArr[--j]); 
	   if(i >= j) 
	    break; 
	   else 
	    swapVal(i, j,ipArr ); 
	  } 
	  swapVal(i, rightint-1,ipArr); 
	  return i; 
	 }  
	 private static int getMedianVal(int leftint, int rightint,int[] ipArr ) { 
	  int center = (leftint+rightint)/2; 
	  if(ipArr[center] < ipArr[leftint]) 
	   swapVal( center, leftint,ipArr); 
	  if(ipArr[rightint] < ipArr[leftint]) 
	   swapVal( rightint, leftint,ipArr); 
	  if(ipArr[rightint] < ipArr[center]) 
	   swapVal(rightint, center,ipArr ); 
	  swapVal( center, rightint-1,ipArr); 
	  return ipArr[rightint-1]; 
	 }  
	 private static void swapVal(int s, int t,int[] ipArr) { 
	  int temp = ipArr[s]; 
	  ipArr[s] = ipArr[t]; 
	  ipArr[t] = temp; 
	 } 
	}   