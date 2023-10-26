package binarysearch;

import java.util.Arrays;

public class MedianOfRowWiseSortedArray {
	
	//Bruteforce approach
	public static int median(int matrix[][], int r, int c) {
		int arr[] = new int[r*c] ;
		int p = 0;
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				arr[p++] = matrix[i][j];
			}
		}
		
		Arrays.sort(arr);
		
		return arr[arr.length/2] ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
