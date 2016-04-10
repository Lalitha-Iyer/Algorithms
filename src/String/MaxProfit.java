package String;

import java.util.List;

public class MaxProfit {

	/*
	 * edge cases 
	 * all equal
	 * decreasing
	 */
	int getMaxProfit(int[] stockprices) {
		int maxProfit = Integer.MIN_VALUE;
		int minSoFar = stockprices[0];
		int tempProfit;
		for (int price : stockprices) {
			tempProfit = price - minSoFar;
			maxProfit = Math.max(maxProfit, tempProfit);
			minSoFar = Math.min(price, minSoFar);
		}
		return maxProfit;
	}
	
	/*
	 * Write a function getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.
	 *   [2, 7, 3, 4]
	 *   [84, 12, 56, 42]
	 *   [7*3*4, 1*3*4, 2*7*4, 2*7*3]
	 */

	int getMaxThreeProduct(int[] val)
	 {
		int maxProdcutOfThree= 1;
		int maxProductOfTwo = val[0]*val[1];
		int minProductOfTwo = val[0]*val[1] ;
		int high =Math.max(val[0], val[1]); int low = Math.min(val[0], val[1]);
		
		for(int i = 2; i <val.length ;i++ )
		{
			if( val[i] >high)
			{
				maxProdcutOfThree = val[i] * maxProductOfTwo;
				maxProductOfTwo = val [i]  * high;
				high = val[i];
			}
		}
		 return 0;
	 }


}
