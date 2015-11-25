package recursion;

import java.util.ArrayList;
import java.util.Random;

public class RecursionMergeSort {

	public static void main(String[] args) {
		int size = 10;
		int[] numbers = new int[size];
		int[] numbersWork = new int[size];
		Random r = new Random();
		//create random array of integers with length of int size
		for(int i = 0; i < size; i++){
			int rVar = 99;
			numbers[i]=r.nextInt(rVar);
		}
		//Debug code to view the original initialized array
		for (int z = 0; z < numbers.length; z++) {
			System.out.print(numbers[z]+",");
		}
		System.out.println();
		System.out.println("-------------------------");
		//sorting method calls
		topDownMergeSort(numbers, numbersWork, size);
		//print sorted int array
		for (int n = 0; n < size; n++) {
			System.out.print(numbers[n]+",");
		}
	}

	
	public static void topDownMergeSort(int[] A, int[] B, int n) {
		topDownSplitMerge(A, 0, n, B);
	}

	public static void topDownSplitMerge(int[] A, int iBegin, int iEnd, int[] B) {
		if (iEnd - iBegin < 2){
			return;
		}
		
		
		int iMiddle = (iEnd + iBegin) / 2;
		topDownSplitMerge(A, iBegin, iMiddle, B);
		topDownSplitMerge(A, iMiddle, iEnd, B);
		topDownMerge(A, iBegin, iMiddle, iEnd, B);
		copyArray(A, iBegin, iEnd, B);
		
	}

	public static void topDownMerge(int[] A, int iBegin, int iMiddle, int iEnd, int[] B) {
		int i0 = iBegin, i1 = iMiddle;
		for (int j = iBegin; j < iEnd; j++) {
			if (i0 < iMiddle && (i1 >= iEnd || A[i0] <= A[i1])) {
				B[j] = A[i0];
				i0 = i0 + 1;
			} else {
				B[j] = A[i1];
				i1 = i1 + 1;
			}
		}
		// Debug code to view sorting model at each step
//		for (int z = 0; z < A.length; z++) {
//			System.out.print(B[z]+",");
//		}
//		System.out.println();
//		System.out.println("-------------------------");
	}

	public static void copyArray(int[] A, int iBegin, int iEnd, int[] B) {
		for (int k = iBegin; k < iEnd; k++){
			A[k] = B[k];
		}
			
	}

}
