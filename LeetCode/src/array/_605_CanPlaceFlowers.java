package array;

/**
 * 
 * Problem:
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and
 * some are not. However, flowers cannot be planted in adjacent plots - they
 * would compete for water and both would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means
 * empty and 1 means not empty), and a number n, return if n new flowers can be
 * planted in it without violating the no-adjacent-flowers rule.
 * 
 * Example 1: Input: flowerbed = [1,0,0,0,1], n = 1 Output: True Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2 Output: False
 * 
 * 
 * Note: The input array won't violate no-adjacent-flowers rule. The input array
 * size is in the range of [1, 20000]. n is a non-negative integer which won't
 * exceed the input array size.
 * 
 */
public class _605_CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int len = flowerbed.length;
		int index = 0;
		int count = 0;
		while (index < len) {
			int curCount = 0;
			while (index < len && flowerbed[index] == 0) {
				curCount++;
				index++;
			}
			if (index - curCount == 0 && index == len) { // all empty
				return (len + 1) / 2 >= n;
				// find positions in the beginning or end
			} else if (index - curCount == 0 || index == len) {
				count += curCount / 2;
			} else {
				count += (curCount - 1) / 2; // find positions in the middle
			}
			if (count >= n) {
				return true;
			}
			index++;
		}
		return false;
	}
}
