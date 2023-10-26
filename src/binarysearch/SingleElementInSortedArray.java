package binarysearch;

public class SingleElementInSortedArray {
	
	//method 1 ----> O(N) 
	
	//Method 2----> O(N) using XOR as XOR of two same element = 0, XOR of 0 and element = element
	public static int singleElementM2(int[] arr) {
		
		int ans = arr[0];
		for(int i=1; i<arr.length; i++) {
			ans = ans ^ arr[i];
		}
		
		return ans;
		
	}
	
	
	
	
	//Method 3 ----> using Binary search O(logN)
	public static int singleElement(int[] arr) {
		//corner cases
		if(arr.length == 1) return arr[0];
		if(arr[0] != arr[1]) return arr[0];
		if(arr[arr.length-1] != arr[arr.length-2]) return arr[arr.length-1];
		
		int s = 1;    //as 0 is already considered above 
		int e = arr.length-2;	//as arr.length-1 is already considered above 
		
		while(s <= e) {
			
			int mid = (s + e)/2;
			
			//checking if mid is a single element
			if(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]) {
				return arr[mid];
			}
			
			//checking if we are in first half
			if((mid % 2 == 0 && arr[mid] == arr[mid+1]) || (mid % 2 == 1 && arr[mid] == arr[mid-1])){
				s = mid + 1	;		//will go to the second half
			}
			
			else {
				e = mid -1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,2,3,3,4,4,5,5};
		System.out.println(singleElement(arr));

	}

}
