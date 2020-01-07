import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
/*
---------------------------------------------------------------------------
Question
---------------------------------------------------------------------------
Given an array and a number k where k is smaller than size of array, we 
need to find the k’th largest element, k'th smallest element, k largest elements and
k smallest elements in the given array. It is given 
that all array elements are distinct.
---------------------------------------------------------------------------
*/
class KLargestElement {
	
	//returns k th smallest element from given array
	public Integer findKthSmallestElement(Integer[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			public int compare(Integer l1, Integer l2) {
				return l2.compareTo(l1);
			}
		});

		//add k elements in heap
		for(int i=0;i<k;i++) maxHeap.add(arr[i]);
			 
		int n = arr.length;
		for (int i=k;i<n;i++) {
			Integer root = maxHeap.peek();
			if(arr[i].compareTo(root) == -1) {
				maxHeap.poll();
				maxHeap.add(arr[i]);
			}
		}
		return maxHeap.peek();
	}
	
	//returns k th largest element from given array
	public Integer findKthLargestElement(Integer[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		//add k elements in heap
		for(int i=0;i<k;i++) minHeap.add(arr[i]);
		
		 
		int n = arr.length;
		for (int i=k;i<n;i++) {
			Integer root = minHeap.peek();
			if(arr[i].compareTo(root) == 1) {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}
		return minHeap.peek();
	}
	
	//returns k smallest elements from given array
	public ArrayList<Integer> findKSmallestElements(Integer[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int n = arr.length;
		for(int i=0;i<n;i++) minHeap.add(arr[i]);

		ArrayList <Integer> op = new ArrayList <>();
		for (int i=0;i<k;i++) {
			op.add(minHeap.poll());
		}
		return op;
	}
	
	//returns k largest elements from given array
	public ArrayList<Integer> findKLargestElements(Integer[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			public int compare(Integer l1, Integer l2) {
				return l2.compareTo(l1);
			}
		});
		int n = arr.length;
		for(int i=0;i<n;i++) maxHeap.add(arr[i]);

		ArrayList <Integer> op = new ArrayList <>();
		for (int i=0;i<k;i++) {
			op.add(maxHeap.poll());
		}
		return op;
	}
	
	
	
	public static void main(String[] args) {
		
		KLargestElement kl = new KLargestElement();
		
		Integer[] arr = {7, 10, 4, 3, 20, 15};
		int k = 3;
		
		System.out.println("K th smallest element is: " + kl.findKthSmallestElement(arr, k));
		System.out.println("K th largest element is: " + kl.findKthLargestElement(arr, k));
		System.out.println("K smallest elements are: " + kl.findKSmallestElements(arr, k));
		System.out.println("K largest elemenents are: " + kl.findKLargestElements(arr, k));
		
	}

}
