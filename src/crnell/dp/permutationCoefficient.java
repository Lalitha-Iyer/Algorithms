package crnell.dp;

/*P(n, k) = P(n-1, k) + k* P(n-1, k-1)   */

public class permutationCoefficient {

	static int permutationCoeff(int n, int k) {
		int[][] solutions = new int[n + 1][k + 1];
		int i, j;
		for (i = 0; i <= k; i++) {
			solutions[0][i] = 0;
		}
		for (i = 0; i <= n; i++) {
			solutions[i][0] = 1;
		}
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= Math.min(i, k); j++) {
				solutions[i][j] = solutions[i - 1][j]
						+ (j * solutions[i - 1][j - 1]);
			}
		}
		return solutions[n][k];

	}

	public static void main(String[] args) {
		System.out.println(permutationCoeff(10, 2));
		System.out.println(permutationCoeff(10, 3));
		System.out.println(permutationCoeff(10, 0));
		System.out.println(permutationCoeff(10, 1));

	}
}
