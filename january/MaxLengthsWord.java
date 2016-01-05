import java.util.HashSet;

public class MaxLengthsWord {
	public static int getMaxProduct(String[] words) {
		int max = 0;
		for(int i=0;i<words.length;i++) {
			for(int j=1;j<words.length;j++) {
				if(!commonChars(words[i], words[j])) {
					int newLen = words[i].length() * words[j].length();
					if(newLen > max)
						max = newLen;
				}
			}
		}
		return max;
	}

	private static boolean commonChars(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		String str = aLen>bLen ? a : b;
		String cStr = aLen>bLen ? b : a;
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0;i<str.length();i++)
			set.add(str.charAt(i));
		for(int i=0;i<cStr.length();i++)
			if(set.contains(cStr.charAt(i)))
				return true;
		return false;
	}

	public static void main(String[] args) {
		String[] charArray = new String[] {"ABC", "ABCDEF", "FXYZ"};
		System.out.println(getMaxProduct(charArray));
	}
}