package com.hackerrank.problems.general;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RedKnightShortestPath {

	// Complete the printShortestPath function below.
	static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
		// Print the distance along with the sequence of moves.
		boolean isStartIndexIEven = (i_start % 2 == 0) ? true : false;
		boolean isStartIndexJEven = (j_start % 2 == 0) ? true : false;
		boolean isEndIndexIEven = (i_end % 2 == 0) ? true : false;
		boolean isEndIndexJEven = (j_end % 2 == 0) ? true : false;
		// if start i is even
		if (isStartIndexIEven) {
			// if end i is even
			if (isEndIndexIEven) {
				int diff = Math.abs((i_start - i_end));
				int level = diff / 2;
				if (level % 2 == 0) {
					// same level and if start j is even
					if (isStartIndexJEven) {
						if (isEndIndexJEven) { // end j is even
							findMinPath(n, i_start, j_start, i_end, j_end);
						} else // if end j is odd
							System.out.println("Impossible");
					}
					// if start j is odd
					else {
						if (!isEndIndexJEven) { // if end j is odd
							findMinPath(n, i_start, j_start, i_end, j_end);
						} else // if end j is even
							System.out.println("Impossible");
					}

				} else { // next level
					if (isStartIndexJEven) { // start index j is even
						if (!isEndIndexJEven) { // end index j is odd
							findMinPath(n, i_start, j_start, i_end, j_end);
						} else // end index j is even
							System.out.println("Impossible");
					} else { // start index j is odd
						if (isEndIndexJEven) { // end index j is even
							findMinPath(n, i_start, j_start, i_end, j_end);
						} else
							System.out.println("Impossible");
					}
				}
			}
			// if end i is odd
			else
				System.out.println("Impossible");
		}

		// if start i is odd
		else {
			if (!isEndIndexIEven) { // if end i is odd
				int diff = Math.abs((i_start - i_end));
				int level = diff / 2;
				if (level % 2 == 0) { // same level
					if (isStartIndexJEven) { // if start j is even
						if (isEndIndexJEven) { // if end j is even
							findMinPath(n, i_start, j_start, i_end, j_end);
						} else // if end j is odd
							System.out.println("Impossible");
					} else { // if start j is odd
						if (!isEndIndexJEven) { // if end j is odd
							findMinPath(n, i_start, j_start, i_end, j_end);
						} else // if end j is even
							System.out.println("Impossible");
					}
				} else { // next level
					if (isStartIndexJEven) { // if start j is even
						if (!isEndIndexJEven) { // if end j is odd
							findMinPath(n, i_start, j_start, i_end, j_end);
						} else
							System.out.println("Impossible");
					} else { // if start j is odd
						if (isEndIndexJEven) { // if end j is even
							findMinPath(n, i_start, j_start, i_end, j_end);
						} else // if end j is odd
							System.out.println("Impossible");
					}
				}

			} else // if end i is even
				System.out.println("Impossible");
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] i_startJ_start = scanner.nextLine().split(" ");

		int i_start = Integer.parseInt(i_startJ_start[0]);

		int j_start = Integer.parseInt(i_startJ_start[1]);

		int i_end = Integer.parseInt(i_startJ_start[2]);

		int j_end = Integer.parseInt(i_startJ_start[3]);

		printShortestPath(n, i_start, j_start, i_end, j_end);

		scanner.close();
	}

	public static void findMinPath(int n, int iStart, int jStart, int iEnd, int jEnd) {
		//System.out.println("Intial -->Start:(" + iStart + "," + jStart + ")" + " End:(" + iEnd + "," + jEnd + ")");
		int UL = 0, UR = 0, R = 0, LR = 0, LL = 0, L = 0;
		int currentI = iEnd, currentJ = jEnd;
		while (iStart != iEnd) {

			if ((iEnd <= iStart) && (jEnd <= jStart)) {// II Quadrant
				//System.out.println("II  Quadrant");
				//while (iStart > iEnd && jStart > jEnd) {
					UL++;
					iStart = iStart - 2;
					jStart = jStart - 1;
				//}
			}
			else if ((iEnd <= iStart) && (jEnd >= jStart)) { // I Quadrant
			//	System.out.println("I  Quadrant");
				//while (iStart < iEnd && jEnd < jStart) {
					UR++;
					iStart = iStart - 2;
					jStart = jStart + 1;
				//}
			} else if (iEnd >= iStart && jEnd >= jStart) { // IV Quadrant
				//System.out.println("IV  Quadrant");
				//while (iStart < iEnd && jStart < jEnd) {
					LR++;
					iStart = iStart + 2;
					jStart = jStart + 1;
			//	}
			} else { // III Quadrant
				//System.out.println("III  Quadrant");
				//while (iStart < iEnd && jStart > jEnd) {
					LL++;
					iStart = iStart + 2;
					jStart = jStart - 1;
				//}

			}
			//System.out.println("Start:(" + iStart + "," + jStart + ")" + " End:(" + iEnd + "," + jEnd + ")");

		}
		
		if(jEnd>jStart)	
			R = (jEnd - jStart) / 2;
		else
		L = (jStart - jEnd) / 2;
		System.out.println(UL + UR + LL + LR + R + L);
		printSeries(UL, UR, R, LR, LL, L);

		//System.out.println("Dest is reachable:)");
	}

	public static void printSeries(int UL, int UR, int R, int LR, int LL, int L) {
		while (UL > 0) {
			System.out.print("UL ");
			UL--;
		}
		while (UR > 0) {
			System.out.print("UR ");
			UR--;
		}
		while (R > 0) {
			System.out.print("R ");
			R--;
		}
		while (LR > 0) {
			System.out.print("LR ");
			LR--;
		}
		while (LL > 0) {
			System.out.print("LL ");
			LL--;
		}
		while (L > 0) {
			System.out.print("L ");
			L--;
		}

	}
}
