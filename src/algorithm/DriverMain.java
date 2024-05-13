package algorithm;

import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Arrays; 
import java.util.Scanner; 
public class DriverMain { 
 public static void main(String[] args) { 
  try { 
  String charRand= "---------- The Following is Comparison-Based Sorting Algorithm for Random Numbers ----------"; 
  String charSort= "---------- The Following is Comparison-Based Sorting Algorithm for Sorted Numbers ----------"; 
  String charRevSort= "---------- The Following is Comparison-Based Sorting Algorithm for Reversely Sorted Numbers ----------"; 
     Scanner in = new Scanner(System.in);  
      
  FileWriter opFile = new FileWriter("myOutput.txt",true); 
   
        System.out.println("Enter the no of input size to be sorted: "); 
        int n = Integer.parseInt(in.nextLine()); 
        in.close(); 
         
        int randIpArray[]= AllSortingAlgorithm.getIntRandNos(n); 
        int randIpArray1[]= Arrays.copyOf(randIpArray, randIpArray.length); 
        int randIpArray2[]= Arrays.copyOf(randIpArray, randIpArray.length); 
         
        opFile.write("\n The Ip Size are:" + n); 
        opFile.flush(); 
        opFile.close(); 
         
        System.out.println( '\n' +" ------------- The Following is Comparison-Based Sorting Algorithm for Random Numbers -------------" + '\t' + '\n'); 
        
        calTime.randSorted(randIpArray,charRand); 
         
        System.out.println( '\n'  +"------------- The Following is Comparison-Based Sorting Algorithm for Sorted Numbers -------------" + '\n'); 
  calTime.Sorting(randIpArray1,charSort); 
   
        System.out.println( '\n'  + "------------- The Following is Comparison-Based Sorting Algorithm for Reversely Sorted Numbers -------------" + '\n'); 
        calTime.revSorted(randIpArray2,charRevSort);   
  } 
   catch (IOException exception) { 
        System.out.println("An Error occured, please check!!!"); 
        exception.printStackTrace(); 
      } 
   
 } 
} 