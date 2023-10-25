package binarysearch;

public class NthRoot {
	
	
	//Square root
	public static int sqrt(int n) {
		int s = 0;
		int e = n/2;
		
		while (s <= e) {
			int mid = (s + e)/2 ;
			
			if(Math.pow(mid, 2) == n) return mid;
			else if(Math.pow(mid, 2) < n) {
				
				if(Math.pow(mid+1, 2) > n) return -1;
				
				else s = mid+1;
			}
			
			else e = mid-1;
		}
		
		return -1;
	}
	
	
	
	//Nth-Root
	
	public static int Nthroot(int n, int m) {
		int s = 1;
		int e = n;
		
		while (s <= e) {
			int mid = (s + e)/2 ;
			
			if(Math.pow(mid, m) == n) return mid;
			else if(Math.pow(mid, m) < n) {
				
				if(Math.pow(mid+1, m) > n) return -1;
				
				else s = mid+1;
			}
			
			else e = mid-1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int p = Nthroot(1, 4);
		System.out.println(p);

	}

}
