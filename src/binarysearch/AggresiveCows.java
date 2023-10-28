package binarysearch;

import java.util.Arrays;

public class AggresiveCows {
	
	//max(Minimum possible distance)
	
	//Method-1 : Brute force
	public static int aggresiveCows1(int[] stalls, int cows) {
		
		//sort stalls
		Arrays.sort(stalls);
		
		//minimum distance possible between two cows, if placed on two consequtive stalls positions
		int low = 1;	
		//maximum distance, one placed at starting and another placed at last stall
		int high = stalls[stalls.length-1] - stalls[0];
		
		//Let's check we can place cow at positions or not, getting maximum of minimum possible distance
		for(int distance = low; distance <= high; distance++) {
			
			//if we get that distance according which we can not place cows
			//means we were able to place cows for all before distance values
			if(canPlace(stalls, distance, cows) == false) {
				return distance - 1;	//returning the maximum distance where distance is minimum possible
			}
		}
		
		return high;	//last possibility to place cows --> at max possible distance
	}
	
	
	//canPlace
	public static boolean canPlace(int stalls[], int distance, int cows) {
		
		int lpCow = stalls[0]; //position of last placed cow // assuming for first position to get the minimum distance
		int countCow = 1; 	   // initially single cow is placed
		
		//place cow
		for(int i=1; i<stalls.length; i++) {
			
			int currDistance = stalls[i] - lpCow ;
			if(currDistance >= distance ) //as distance is more than we can place more cows 
			{
				countCow++;		//placed more cows
				lpCow = stalls[i]; // updating position of last placed cow 
			}
			//if placed cows are equal to expected cows means placement with atleast distance of "distance" between two cows, is possible 
			if(countCow == cows) return true;
		}
		return false;
	}
	
	//Method-2 : BinarySearch
	public static int aggresiveCows2(int[] stalls, int cows) {
		
		//sort stalls
		Arrays.sort(stalls);
		
		//minimum distance possible between two cows, if placed on two consequtive stalls positions
		int low = 1;	
		//maximum distance, one placed at starting and another placed at last stall
		int high = stalls[stalls.length-1] - stalls[0];
		int ans = -1;
		
		while(low <= high) {
			int mid = (low + high)/2 ;
			
			if(canPlace(stalls, mid, cows) == false) //means we are in right part we need to go to the left part to get possible distance
			{
				high = mid - 1;
			}
			else	//means we have got one possible ans but we need to find max of it so will have to move right
			{
				ans = mid;
				low = mid + 1;
			}
		}
		
		return ans;	//last possibility to place cows --> at max possible distance
	}

	
	
	public static void main(String[] args) {
		int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggresiveCows2(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);

	}

}
