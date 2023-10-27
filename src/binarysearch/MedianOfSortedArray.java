package binarysearch;

import java.util.Arrays;

public class MedianOfSortedArray {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int arr[] = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }

        while(i < m){
            arr[k++] = nums1[i++];
        }

        while(j < n){
            arr[k++] = nums2[j++];
        }
        
        System.out.println(Arrays.toString(arr));
        if((m+n)%2 != 0) return arr[arr.length/2];

        return (arr[(arr.length/2)] + arr[(arr.length/2 -1)])/2.0 ;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1, 2};
		int arr2[] = {3, 4};
		
		System.out.println(findMedianSortedArrays(arr1, arr2));
	}

}
