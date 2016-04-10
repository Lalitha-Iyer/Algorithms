package String;

public class DuplicateChar {
	
	static boolean hasUniqueChar(String in) {
		boolean[] charSet = new boolean[256];
		for (char c : in.toCharArray()) {
			if (charSet[c])
				return false;
			else
				charSet[c] = true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		System.out.println(hasUniqueChar("test"));
		
	}

}
