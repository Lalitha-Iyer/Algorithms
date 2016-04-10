/*
 * start time: 5:42
 * end time:   6:15
 */
/*
 * Assumptions both arrays sorted by finish time.
 * Psudeo code
 * 	
 * pick first element
 * while there exist some non conflicting element
 * getNext non conflicting element
 * Fixed priority
 */

public class IntervalScheudlingGreedy {

	static void printSchedule(int[] start, int[] finish) {
		System.out.println();
		System.out.println("Scheulding ..");
		int i = 0;
		System.out.print("\t" + i);
		int j = i + 1;
		while (i < finish.length - 2) {
			while (start[j] <= finish[i] && j < finish.length - 1) {
				j++;
			}
			if (start[j] <= finish[i])
				return;
			System.out.print("\t" + j);
			i = j;
			j = i + 1;
		}
	}

	static void printScheduleLI(int[] start, int[] finish) {
		System.out.println();
		System.out.println("Scheulding with LI .."+"\t");
		int lastJob = 0;
		for (int k = 0; k < finish.length; k++) {
			if (isValid(start[k], finish[lastJob], k)) {
				System.out.print( + k+"\t");
				lastJob = k;
			}

		}

	}

	private static boolean isValid(int i, int lastJob, int index) {
		// TODO Auto-generated method stub
		if ( lastJob < i || index == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int[] start = { 1, 3, 5, 6, 7, 8 };
		int[] finish = { 3, 4, 7, 9, 7, 10 };
		IntervalScheudlingGreedy.printSchedule(start, finish);
		IntervalScheudlingGreedy.printScheduleLI(start, finish);

		int[] start1 = { 1, 4, 5, 6, 7, 8 };
		int[] finish1 = { 3, 5, 7, 9, 8, 10 };

		IntervalScheudlingGreedy.printSchedule(start1, finish1);
		IntervalScheudlingGreedy.printScheduleLI(start1, finish1);

		int[] start2 = { 1, 3, 0, 5, 8, 5 };
		int[] finish2 = { 2, 4, 6, 7, 9, 9 };
		IntervalScheudlingGreedy.printSchedule(start2, finish2);
		IntervalScheudlingGreedy.printScheduleLI(start2, finish2);


	}

}
