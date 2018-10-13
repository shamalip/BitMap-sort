package my.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import my.util.bitsort.BitSort;

public class Invoker {
	private static final int LIMIT = 27000;

	public static void main(String[] args) throws IOException {
		int[] inp = randomIntArray(LIMIT,LIMIT);
		System.out.println("Input :");
		printArr(inp);
		bitSort(inp);
		arraysSort(inp);
	}

	private static int[] randomIntArray(int range,int len) {
		int[] genArr = new int[len];
		if(len > range) {
			throw new IllegalArgumentException("The length of generated array has to be less than range of intergers allowed");
		} 
		Set<Integer> intSet = new LinkedHashSet<Integer>();
		Random r = new Random();
		while (intSet.size() < len)
		{
			intSet.add(r.nextInt(range) + 1);
		}
		genArr = intSet.stream().mapToInt(Number::intValue).toArray();
		return genArr;
	}

	private static void arraysSort(int[] inp) {
		long start = System.nanoTime();
		Arrays.sort(inp);
		long end = System.nanoTime();
		System.out.println("Output with Arrays sort function:");
		printResults(start, inp, end);
	}

	private static int[] bitSort(int[] inp) {
		long start = System.nanoTime();
		inp = BitSort.sort(inp,LIMIT);
		long end = System.nanoTime();
		System.out.println("Output with bitsort:");
		printResults(start, inp, end);
		return inp;
	}

	private static void printResults(long start, int[] out, long end) {
		printArr(out);
		System.out.println("execution time :- " + (end - start)/1000000.00 + "ms");
	}
	
	private static void printArr(int[] inp) {
		IntStream.of(inp).forEachOrdered(i -> System.out.print(i + " "));
		System.out.println();
	}



}
