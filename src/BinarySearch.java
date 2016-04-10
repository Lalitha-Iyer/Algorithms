public class BinarySearch {

	static boolean search(int[] in, int key) {

		int h = -1;
		int k = in.length;
		int mid;
		while (h != k - 1) {
			mid = h + k / 2;
			if (in[mid] == key)
				return true;
			else if (in[mid] < key) {
				h = mid;
			} else
				k = mid;
		}
		return false;
	}

	public static void main(String[] args) {

		int[] k = { 1, 6, 8, 8, 9, 6 };
		System.out.println(search(k, 3));
		System.out.println(search(k, 6));

	}

}
