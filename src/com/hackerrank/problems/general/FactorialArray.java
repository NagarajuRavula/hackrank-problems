package com.hackerrank.problems.general;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class FactorialArray {
	public static Map<Integer, BigInteger> factorial = new HashMap<>();
	public static SortedSet<Integer> NumbersInRange = new ConcurrentSkipListSet<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] A = new int[n];
		factorial.put(1, BigInteger.valueOf(1));
		calculateFactorials();
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
			if (A[A_i] < 40)
				NumbersInRange.add(A_i);
		}
		for (int a0 = 0; a0 < m; a0++) {
			int op = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			
			if (op == 1) {
				SortedSet<Integer> NumbersInRangeForUpdate = NumbersInRange.subSet((l-1), r);
				Iterator it = NumbersInRangeForUpdate.iterator();
				while (it.hasNext()) {
					int ind = (int) it.next();
						A[ind]++;
						if (A[ind] > 39) {
							NumbersInRangeForUpdate.remove(ind);
						}
				}
			} 
			else if (op == 2) {
				BigInteger factSum = BigInteger.valueOf(0);
                
                SortedSet<Integer> NumbersInRangeForCalc = NumbersInRange.subSet((l-1), r);
                Iterator it = NumbersInRangeForCalc.iterator();
                while(it.hasNext()) {
                    int ind = (int) it.next();
                    factSum = factSum.add(factorial.get(A[ind]));
                }
				System.out.println(factSum.mod(BigInteger.valueOf(1000000000)));
			} 
			else if (op == 3) {
				A[(l - 1)] = r;
				boolean isPresent = NumbersInRange.contains((l-1));
				if (r < 40) {
					if(!isPresent)
						NumbersInRange.add((l-1));
				}
				
				else {
					if (isPresent)
						NumbersInRange.remove((l - 1));
				}
			}
		}

		in.close();
	}

	public static void calculateFactorials() {
		for (int i = 2; i < 40; i++) {
			factorial.put(i,
					(BigInteger.valueOf(i).multiply(factorial.get(i - 1)).mod(BigInteger.valueOf(1000000000))));
		}
	}
}
