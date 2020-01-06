/*
---------------------------------------------------------------------------
Question
---------------------------------------------------------------------------
Given an unsorted array A of size N of non-negative integers.
Find a continuous sub-array which adds to a given number S.
---------------------------------------------------------------------------
*/


public class Main
{
    /**
	 * Finds the first and last index of subarray.
	 * 
	 * @param array : input array
	 * @param n : size of array
	 * @param sum : Given integer sum
	 */
    public void subarrayOfSum(int[] array, int n, int sum) {
		int start = 0;
		int curr_sum = array[0];
		for (int i=1;i<=n;i++) {
			while(curr_sum > sum && start < i-1) {
				curr_sum = curr_sum - array[start];
				start++;
			}
			
			if(curr_sum == sum) {
			    int last = i-1;
				System.out.println("First index of subArray: " + start + "\nLast index of subArray: " + last);
				return;
			}
			
			if (i < n) {
				curr_sum = curr_sum + array[i];
			}
		}
		
	}
	
	public static void main(String[] args) {
	    Main obj = new Main();
	    
	    int[] array = {15, 2, 4, 8, 9, 5, 10, 23};
		int n = array.length;
		int sum = 23;

	    obj.subarrayOfSum(array, n, sum);
	}
}
