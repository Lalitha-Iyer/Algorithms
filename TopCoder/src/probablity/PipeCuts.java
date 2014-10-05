package probablity;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=3994&rd=6532
 *
 */
public class PipeCuts {

	static int pipeLength = 100;

	public static double probablity(int[] weldLocations, int length) {

		int totalCount = 0;
		int eventCount = 0;

		for (int i = 0; i < weldLocations.length; i++) {
			for (int j = i + 1; j < weldLocations.length; j++) {
				System.out.println(weldLocations[i] + " " + weldLocations[j]);
				totalCount++;
				if (Math.abs(weldLocations[i] - weldLocations[j]) > length
						|| weldLocations[i] > length
						|| pipeLength - weldLocations[j] > length
				) {
					eventCount++;
					System.out.println("Success" + weldLocations[i] + " "
							+ weldLocations[j]);
				}
			}
		}
		System.out.println("Total Count" + totalCount);
		System.out.println("Event Count" + eventCount);
		return (double) eventCount / totalCount;
	}

	public static void main(String[] args) {
		int[] num = { 25, 50, 75 };
		double count = probablity(num, 24);
		System.out.print(count);
	}

}
