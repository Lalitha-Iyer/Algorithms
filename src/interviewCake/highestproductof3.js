function myFunction(a) {
    // write the body of your function here
   	
	if(a!== undefined && a.length >2)	
	{
		var high2 , max, min;
		max = Math.max(a[0],a[1],a[2]);
		high3 = a[0] * a[1] * a[2];	   
	   
	    min = Math.min(a[0],a[1],a[2]);
	    high2 = high3/ min;        
        low2 = high3/max;

		for(i=3;i<a.length;i++)
		{
		    high3 = Math.max(high2 * a[i] , high3, max*min*a[i], low2 * a[i]);
			high2= Math.max(max*a[i], high2);
			max = Math.max(a[i],max);
			min= Math.min(a[i],min);
            low2 = Math.min(low2, min*a[i]);
		}
	}
 	 return high3;

}

// run your function through some test cases here
// remember: debugging is half the battle!
console.log(myFunction([ -10,-2,1,-10,-10]));
console.log(myFunction([1, 10, -5, 1, -100]));
console.log(myFunction([1, 10, -5, 1, -100]));
