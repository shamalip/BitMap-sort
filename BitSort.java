package my.util.bitsort;
import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * @author shamalip
 * Excercise 3 : Column 1: Cracking the oyster
 * Problem : Implementing a bitsort method to sort integers
 * Assumptions : None of the numbers repeat 
 */
public class BitSort {

	/**
	 * @param arr The input array to be sorted
	 * @param limit the max value in range
	 * @return The sorted array.
	 * The complexity of this method is O(n)
	 */
	public static int[] sort(int[] arr,int limit) {
		BitSet bitMap = new BitSet(limit+1);
		IntStream.of(arr).forEach(num -> setBit(bitMap,num));
		int j = 0;
		for (int i = bitMap.nextSetBit(0); i >= 0; i = bitMap.nextSetBit(i+1)) {
			if (i != -1) { arr[j] = i; j++; }
			if (i == Integer.MAX_VALUE) { break; }	
		}
		return arr;
	}

	private static void setBit(BitSet bitMap, int num) {
		if(bitMap.get(num)) { /** If the bit is already set **/
			throw new IllegalArgumentException("The input has duplicate records.");
		}
		bitMap.set(num);
	}

}
