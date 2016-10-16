function myFunction(a) {
    // write the body of your function here
   	
	if(a!== undefined && a.length >2)	
	{
		var high2 , max, min;
		max = Math.max(a[0],a[1],a[2]);
		high3 = a[0] * a[1] * a[2];	   
	   
	    min = Math.min(a[0],a[1],a[2]);
	    high2 = high3/ min;

		for(i=3;i<a.length;i++)
		{
		    high3 = Math.max(high2 * a[i] , high3, max*min*a[i]);
			high2= Math.max(max*a[i], high2, min*a[i]);
			max = Math.max(a[i],max);
			min= Math.min(a[i],min);
		}
	}
 	 return high3;

}

// run your function through some test cases here
// remember: debugging is half the battle!
console.log(myFunction([1, 10, -5, 1, -100]));
