package algo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Merge {
	/*
	 * Complete the function below.
	 */

	/* Write your custom functions here */
	static void mergeArray(int[] a, int[] b, int M) {

		// Copy first array to second half of array b
		for (int i = 0; i < M; i++) {
			b[M + i] = a[i];
		}

		int i = 0;
		int j = M;
		int k = 0;
		while (k < M) {
			if (b[i] < b[j]) {
				a[k++] = b[i++];
			} else {
				a[k++] = b[j++];
			}
		}
		k = M;
		while (i < M && j < 2 * M) {
			if (b[i] < b[j]) {
				b[k++] = b[i++];
			} else {
				b[k++] = b[j++];
			}
		}
		while (i < M) {
			b[k++] = b[i++];
		}

		for (i = 0; i < M; i++) {
			b[i] = a[i];
		}
	}
}
