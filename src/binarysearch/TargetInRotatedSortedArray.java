package binarysearch;

public class TargetInRotatedSortedArray {
	
	//Hint : Compare mid with start and end and think that which
	//part will be sorted in which conditions then this question will be very easy

	public static int search(int[] nums, int target) {
		if (nums.length == 1) {
			if (nums[0] == target)
				return 0;
			else
				return -1;
		}

		int s = 0;
		int e = nums.length - 1;

		while (s <= e) {
			int mid = (s + e) / 2;

			// if we get the element
			if (nums[mid] == target)
				return mid;

			if (nums[s] <= nums[mid]) // will make sure that left part is sorted
			{
				if (nums[s] <= target && target <= nums[mid])// target lies inbetween
				{
					e = mid - 1;
				} else
					s = mid + 1;
			} else // will make sure that right part is sorted
			{
				if (nums[mid] <= target && target <= nums[e])// target lies inbetween
				{
					s = mid + 1;
				} else
					e = mid - 1;
			}

		}

		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
