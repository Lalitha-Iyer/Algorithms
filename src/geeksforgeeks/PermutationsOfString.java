package geeksforgeeks;

/*
 * start time : 9 :05
 * end time: 
 * input : ABC
 * output :  ABC, ACB, BAC, BCA, CAB, CBA
 * a
 * 
 */
public class PermutationsOfString {

	static int c = 0;

	static char[] swap(char[] in, int i, int j) {
		char temp = in[i];
		in[i] = in[j];
		in[j] = temp;
		return in;
	}

	static void permute(char[] in, char[] out, int start) {
		if (start == in.length) {
			System.out.println(new String(out));
			c++;
			return;
		}
		for (int i = start; i < in.length; i++) {
			in = swap(in, start, i);
			out[start] = in[start];
			permute(in, out, start + 1);
			in = swap(in, start, i);
		}
	}

	static void permute(String in) {
		char[] out = new char[in.length()];
		permute(in.toCharArray(), out, 0);
	}

	public static void main(String[] args) {
		permute("yuiv");
		System.out.print(c);
	}
}
