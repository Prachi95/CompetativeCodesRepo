/*
---------------------------------------------------------------------------
Question
---------------------------------------------------------------------------
Design a Data Structure Linked list that supports linked list operations 
like push(), append(), insertAfter() and an additional operation to print 
the linked list. 
---------------------------------------------------------------------------
*/

public class LinkedListDS {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		//constructor
		Node(int key) {
			data = key;
			next = null;
		}
	}
	
	//prints linked list
	public void printLinkedList() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	//push node at the start of linked list
	public void push(int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}
	
	//insert node after some node
	public void insertAfter(Node startNode, int data) {
		Node n = new Node(data);
		n.next = startNode.next;
		startNode.next = n;
	}
	
	//append node at the end of linked list
	public void append(int data) {
		Node n = new Node(data);
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = n;
		n.next = null;	
	}
	
	
	public static void main(String []args) {
		
		LinkedListDS llist = new LinkedListDS(); 
		//created nodes 
		llist.head = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		
		llist.head.next = second;
		second.next = third;
		third.next = null;
		
		//pushed node in front
		llist.push(40);
		//append node at end
		llist.append(50);
		//insert node in between
		llist.insertAfter(llist.head.next, 60);
		
		//print linked list
		llist.printLinkedList();
	
	}

}
