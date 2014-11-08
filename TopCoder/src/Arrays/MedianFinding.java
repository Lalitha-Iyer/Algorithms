package Arrays;

/*
 * Question: There are 2 sorted arrays A and B of size n each.
 * Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n))
 */

public class MedianFinding {

	public static void main(String[] args) {
		int[] a1 = { 2, 4, 6, 7, 8 }, a2 = { 2, 3, 4, 8, 9 };

		System.out.println(getMedian(a1, a2));

	}

	private static int getMedian(int[] a1, int[] a2) {

		return getMedianHelper(a1, a2, 0, a1.length - 1, 0, a2.length - 1);
	}

	private static int getMedianHelper(int[] a1, int[] a2, int lb1, int ub1,
			int lb2, int ub2) {
		if (lb1 < 0 || ub1 > a1.length)
			return avg(a2, lb2, ub2);
		if (lb2 < 0 || ub2 > a2.length)
			return avg(a1, lb1, ub1);
		if (ub1 - lb1 == 0 && ub2 - lb2 == 0)
			return (a1[lb1] + a2[lb2]) / 2;

		int m1, m2;
		m1 = a1[lb1 + (ub1 - lb1) / 2];
		m2 = a2[lb2 + (ub2 - lb2) / 2];
		System.out.println("m1 " + m1);
		System.out.println("m2 " + m2);

		if (m1 == m2)
			return m1;
		if (m1 < m2)
			return getMedianHelper(a1, a2, (ub1 - lb1) / 2, ub1, lb2,
					(ub2 - lb2) / 2);
		if (m1 > m2)
			return getMedianHelper(a1, a2, lb1, (ub1 - lb1) / 2,
					(ub2 - lb2) / 2, ub2);

		return 0;

	}

	private static int avg(int[] a2, int lb2, int ub2) {
		// TODO Auto-generated method stub
		int result = 0;
		for (; lb2 < ub2; lb2++)
			result = result + a2[lb2];

		System.out.print("result");

		return result / (ub2 - lb2 + 1);
	}

}
