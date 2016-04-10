package crnell.dp;

/*
 * Start time: 6:26
 * End time:  7:20
 *  * A job has three parameters(start time, end time , value)
 * The program should schedule in a way that leads to max value 
 * Eg:
 * start =  { 1,3,5,6,8,8};
 finish = { 3,4,7,9,10,10};
 value =  { 5, 3,5,5,1,2  }
 max value: 11
 Assume the array is sorted by finish time.

 Psuedo Code:

 lets consider the last element
 1) Include it in the job scheduling
 a) find the first non conflicting job: b and add the current value to the value until job b 
 2) Donot include it in the job scheudling 
 solution is the value of the last job
 3) Just include it
 Take the max of both

 initial state 
 wats the value at 0 
 */
public class IntervalScheulding {

	public static void main(String[] args) {
		int[] start = { 1, 3, 5, 6, 7, 8 };
		int[] finish = { 3, 4, 7, 9, 7, 10 };
		int[] value = { 5, 3, 5, 5, 1, 2 };
		IntervalScheulding.printSchedule(start, finish, value);
		int[] start1 = { 1, 4, 5, 6, 7, 8 };
		int[] finish1 = { 3, 5, 7, 9, 8, 10 };
		int[] value1 = { 5, 10, 5, 5, 1, 2 };

		IntervalScheulding.printSchedule(start1, finish1, value1);
	}

	private static void printSchedule(int[] start, int[] finish, int[] value) {

		int[] totalValue = new int[finish.length];
		totalValue[0] = value[0];
		// next element
		int next = 1, prev = 0;
		int preTotal = totalValue[0];
		while (next <= finish.length - 1) {
			prev = next - 1;
			// Find the first non conflicting interval
			while (prev >= 0 && start[next] <= finish[prev]) {
				prev--;
			}
			// If none found, then we just have one choice pick the last one
			if (prev < 0) {
				preTotal = totalValue[next - 1];
			} else {
				preTotal = Math.max(totalValue[next - 1], totalValue[prev]
						+ value[next]);
			}
			totalValue[next] = Math.max(preTotal, value[next]);
			next = next + 1;

		}
		System.out.println("Total Value " + totalValue[finish.length - 1]);
	}
}
