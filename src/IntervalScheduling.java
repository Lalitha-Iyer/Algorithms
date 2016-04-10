import java.util.*;


public class IntervalScheduling {

	Set<Interval> intervalSet = new HashSet<Interval>();

	
	public IntervalScheduling()
	{
		Interval one = new Interval(0,2);
		intervalSet.add(one);
		
		Interval second = new Interval(0,3);
		intervalSet.add(second);
	}
	
	private class Interval
	{
		int start;
		int end;
		
		Interval(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	
	
}
