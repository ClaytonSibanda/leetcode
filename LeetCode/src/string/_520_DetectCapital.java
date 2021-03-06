package string;

/**
 * 
 * Problem:
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA". All letters in this word
 * are not capitals, like "leetcode". Only the first letter in this word is
 * capital if it has more than one letter, like "Google". Otherwise, we define
 * that this word doesn't use capitals in a right way.
 * 
 * Example 1:
 * 
 * Input: "USA"
 * 
 * Output: True
 * 
 * Example 2:
 * 
 * Input: "FlaG"
 * 
 * Output: False
 * 
 * Note: The input will be a non-empty word consisting of uppercase and
 * lowercase latin letters.
 *
 *
 */
public class _520_DetectCapital {
	// Method 1
	public boolean detectCapitalUse1(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		int len = word.length();
		int index = 0;
		if (word.charAt(index) >= 'a' && word.charAt(index) <= 'z') {
			index++;
			while (index < len) {
				if (!(word.charAt(index) >= 'a' && word.charAt(index) <= 'z')) {
					return false;
				}
				index++;
			}
		} else if (word.charAt(index) >= 'A' && word.charAt(index) <= 'A') {
			index++;
			if (index < len && word.charAt(index) >= 'A' && word.charAt(index) <= 'Z') {
				while (index < len) {
					if (!(word.charAt(index) >= 'A' && word.charAt(index) <= 'Z')) {
						return false;
					}
					index++;
				}
			} else if (index < len && word.charAt(index) >= 'a' && word.charAt(index) <= 'z') {
				while (index < len) {
					if (!(word.charAt(index) >= 'a' && word.charAt(index) <= 'z')) {
						return false;
					}
					index++;
				}
			}

		}
		return true;
	}

	// Method 2
	public boolean detectCapitalUse2(String word) {
		int count = 0;
		for (char c : word.toCharArray()) {
			if ('Z' - c >= 0) {
				count++;
			}
		}
		return (count == 0 || count == word.length() || (count == 1 && 'Z' - word.charAt(0) >= 0));
	}
}
