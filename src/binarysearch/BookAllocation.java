package binarysearch;

public class BookAllocation {
	
/*
 	//min(Maximum pages)
	//Let's understand the line : Maximum no. of pages allocated should be the minimum
	//eg. books with pages : [25, 46, 28, 49, 24], students (m) = 4
	// each student should have atleast one book, so lets select 49 pages so that all students can have atleast 1 book
	// 49 pages ---> allocations : 25, 46, 28, (49 + 24) {NOT POSSIBLE as if allocate extra book then max no. of pages exceeds)
	   50....{NOT POSSIBLE}
	   51....{NOT POSSIBLE}
	 * 71 pages ---> allocations : (25 + 46), 28, 49, 24 {POSSIBLE as allocation can be done properly}
	// 71 pages will be minimum no. of Maximum pages count such that valid allocation can be done.
	
*/	
	//Method 1 : Brute force/ Linear search
	public static int bookAllocation1(int books[], int m) {
		
		//If no. of students are more than books
		if(m > books.length) return -1;		//allocation not possible
		
		int low = Integer.MIN_VALUE; //low will be holding minimum no. of pages to allocate atleast one book
		int high = 0;			//high will be holding maximum no. pages or one student can have maximum these no. of pages
		for(int i : books) {
			low = Math.max(low, i);	
			high += i;
		}
		
		// let's check for each pages from low --> high that which pagesCount allocation can be done successfully that would be our ans
		for(int pageCount = low; pageCount <= high; pageCount++) {
			
			//get no. of students possible to allocate "pageCount" pages
			int student = countStudent(books, pageCount);
			
			//let's compare it with given no. of students
			if(student == m) return pageCount;
			
		}
		
		return -1;
	}
	
	
	//Let's create countStudent function
	public static int countStudent(int []books, int pageCount) {
		int student = 1;
		int pages = 0;
		
		for(int i=0; i<books.length; i++) {
			
			//check if allocation is possible to this student
			if(pages + books[i] <= pageCount) {
				pages += books[i];		//allocating next book
			}
			//if allocation is not possible to that student move to the new 
			//student and allocate book to him
			else {
				student++;
				pages = books[i];
			}
		}
		
		return student;
	}
	
	
	//Method 1 : Optimized approach/ Binary search
	public static int bookAllocation2(int books[], int m) {
		
		//If no. of students are more than books
		if(m > books.length) return -1;		//allocation not possible
		
		int low = Integer.MIN_VALUE; //low will be holding minimum no. of pages to allocate atleast one book
		int high = 0;			//high will be holding maximum no. pages or one student can have maximum these no. of pages
		for(int i : books) {
			low = Math.max(low, i);	
			high += i;
		}
		
		int ans = -1;
		//applying Binary search
		while(low <= high) {
			int mid = (low + high)/2 ;
			
			
			//as we can think that
			//for 1 student --> possible pageCount ==> 172 (all allocated to single)
			//for 5 students --> possible pageCount ==> 49 (allocated atleast one to all 5)
			// as page count will decrease student count will increase
			
			
			//if student is more than expected then we need to check for less pages so move right
			//means we need increase the page count
			if(countStudent(books, mid) > m) {
				low = mid + 1;
			}
			//if allocation can be done but we need minimum possible pages
			else if(countStudent(books, mid) == m){
				ans = mid;
				high = mid - 1;
//				System.out.println(ans);
			}
			//if no. of student are less than expected then we need to move left
			//means we need decrease the page count
			else {
				high = mid - 1;
			}
		}
		
		return ans;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,8,4,9};
        int m = 3;
        int ans = bookAllocation2(arr, m);
        System.out.println("The answer is: " + ans);

	}

}
