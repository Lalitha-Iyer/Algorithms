package String;

import java.util.HashSet;
import java.util.Set;

//When touching a smart phone occasionally the wrong key is pressed
//Write a function that given a string , returns all nearby words
public class Permute {

	Set<String> nearByPermutation = new HashSet<String>();

	void nearByPermutation(char[] in, int start) {
		// char[] chars = s.toCharArray();
		char[] nearBychars;
		if (start == in.length) {
			System.out.println(in.toString());
			nearByPermutation.add(in.toString());
		}
		nearBychars = nearByChars(in[start]);
		for (char c : nearBychars) {
			in[start] = c;
			nearByPermutation(in, start + 1);
		}

		return;

	}

	char[] nearByChars(Character s) {
		char[] out = new char[3];
		if( s == 'a' )
		{
			out[0] = 'b';
			out[1] = 'd';
		}
		if( s == 'e' )
		{
			out[0] = 'f';
			out[1] = 'g';
		}
		return out;
		
	}

	public static void main(String[] args) {

	}
}
