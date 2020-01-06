
/*
---------------------------------------------------------------------------
Question
---------------------------------------------------------------------------
Design a Data Structure SpecialStack that supports all the stack operations like push(), 
pop(), isEmpty(), isFull() and an additional operation getMin() which should return 
minimum element from the SpecialStack. All these operations of SpecialStack must be O(1). 
To implement SpecialStack, you should only use standard Stack data structure and 
no other data structure like arrays, list, .. etc.
---------------------------------------------------------------------------
*/

import java.util.Stack;


class StackDS extends Stack<Integer> 
{
	//declare stack
	Stack<Integer> st = new Stack<>();
	
	/*
	 * check if stack is empty.
	 */
	public boolean isEmpty() {
		return st.empty();
	}
	
	/*
	 * check if stack is full.
	 * 
	 * @param n : max size of stack.
	 */
	public boolean isFull(int n) {
		boolean result = (st.size() == n);
		return result;	
	}

	
	/*
	 * push element on top of stack.
	 * 
	 * @param a : integer number
	 */
	public void push(int a) {
		st.push(a);
	}
	
	
	/*
	 * pop the element from the top of stack.
	 */
	public Integer pop() {
		if(st.isEmpty()) {
			return -1;
		} else {
			return st.pop();
		}
	}
 	
	/*
	 * return minimum element from the stack.
	 */
	public int getMin() {
		if(!st.isEmpty()) {
			int minEle = st.pop();
			while(!st.isEmpty()) {
				int ele = st.pop();
				minEle = Math.min(ele, minEle);
			}
			return minEle;
		}
		return -1;
	}
	
	
	public static void main(String []args) {

		StackDS stObj = new StackDS(); 
		stObj.push(20);
		stObj.push(10);
        System.out.println(stObj.pop()); 
        System.out.println(stObj.getMin()); 

	}

	
}
