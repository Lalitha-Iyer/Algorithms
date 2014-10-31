package algo;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
   public  int getMaxNights(int[] input)
    {
       if(input==null)
       {
           return 0;
       }
       if(input.length == 1)
       {
         return input[0];
       }
       if(input.length == 2)
       {
           return max( input[1],input[0]);
       }  
       int result =0 ;

      //Intitliation
       int prevResult = max( input[1],input[0]);
       int prevResult2 = input[0];
       int tmp=0;
       for(int i =2;i<input.length;i++)
       {
         tmp = prevResult; 
         result = max(input[i]+prevResult2, prevResult );        
         prevResult = result;
         prevResult2 = tmp;
       }  
     
       return result;
 
    }  
  
    public int max(int i, int j)
    {
       if(i<j)
         return j;
      else
        return i;
    }
      
  
  public static void main(String[] args) {
/*   [5, 1, 2, 5] = 10
[4, 9, 6] = 10
[4, 11, 6] = 11
[4, 10, 3, 1, 5] = 15 
*/
    
    int[] in = {4, 10, 3, 1, 5};
    Solution s = new Solution();
    System.out.println(s.getMaxNights(in));
         
  }
}
