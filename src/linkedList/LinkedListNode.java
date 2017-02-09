/**
 * 
 */
package linkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Aastha Jain
 *
 */

public class LinkedListNode<T> {
	T data;
	LinkedListNode next;
	LinkedListNode prev;

	public LinkedListNode(T data) {
		this.data = data;
	}

	public void insertAtBeginnning(T data) {
		LinkedListNode startNode = new LinkedListNode(data);
		LinkedListNode start = this;
		startNode.next = start;
		start = startNode;
	}

	public void insertAtEnd(T data) {
		LinkedListNode end = new LinkedListNode(data);
		LinkedListNode start = this;

		while (start.next != null)
			start = start.next;
		start.next = end;
	}

	public void insertAtPosition(int position, T data) {
		LinkedListNode start = this;
		LinkedListNode startNode = new LinkedListNode(data);
		LinkedListNode prev = start;
		int count = 1;
		while (count < position - 1 && prev.next != null) {
			prev = prev.next;
			count++;
		}
		startNode.next = prev.next;
		prev.next = startNode;

	}

	public void insertAtBegining_DoublylinkedList() {
		LinkedListNode start = this;
		LinkedListNode new1 = new LinkedListNode(data);

		if (start != null) {
			new1.next = start;
			new1.prev = null;

			start.prev = new1;
			start = new1;
		}

	}

	public void insertAtEnd_DoublylinkedList() {
		LinkedListNode start = this;
		LinkedListNode new1 = new LinkedListNode(data);
		LinkedListNode last = start;
		while (last != null) {
			last = last.next;
		}
		last.next = new1;
		new1.prev = last;
		new1.next = null;
		last = new1;
	}

	public static void printLinkedList(LinkedListNode head) {

		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println("\n");
	}

	public static int sizeOfLinkedList(LinkedListNode head) {

		LinkedListNode node = head;
		int size = 0;
		while (node != null) {
			size++;
			node = node.next;
		}
		return size;

	}

	protected static void NthLastElement(LinkedListNode head, int n) {
		if (head == null)
			return;
		else {
			LinkedListNode node = head;
			int size = 0;
			while (head != null) {
				size++;
				head = head.next;
			}
			int position = size - n;
			while (position != 0) {
				node = node.next;
				position--;
			}
			System.out.println("\n\n" + n + "th Last Element of Singly-LinkedList is :" + node.data);
		}
	}

	/*
	 * 22.Given a singly linked list of characters, write a function that
	 * returns true if the given list is palindrome, else false.
	 */

	protected static boolean palindrome(LinkedListNode head) {
		if (head == null)
			return true;

		StringBuilder str = new StringBuilder();
		while (head != null) {
			str.append(head.data);
			head = head.next;
		}
		// System.out.println(str);
		int len = str.length();
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1))
				return false;
		}
		return true;

	}

	/*
	 * 23 Write a function to get the intersection point of two Linked Lists
	 */
	public static void intersection(LinkedListNode head1, LinkedListNode head2) {
		if (head1 == null || head2 == null)
			return;
		else {
			/*
			 * Traversing the list1 to find which element of list2 matches list1
			 */
			LinkedListNode node1 = head1;
			LinkedListNode node2 = head2;
			while (node1.data != node2.data) {
				if (node1.next != null)
					node1 = node1.next;
				else {
					node1 = head1;
					node2 = node2.next;
				}
			}
			System.out.println(node1.data);
		}
	}

	/*
	 * 24.Write a recursive function to print reverse of a Linked List
	 */
	public static LinkedListNode reverseRecursively(LinkedListNode head) {
		if (head == null || head.next == null)
			return head;
		LinkedListNode lastnode = reverseRecursively(head.next);
		// head.next.next=head;
		// lastnode.next=head;
		return lastnode;
	}

	/*
	 * 25. Remove duplicates from a sorted linked list
	 */
	protected static void removeDuplicates(LinkedListNode head) {
		if (head == null)
			return;
		else {

			LinkedListNode temp = head;
			while (temp.next != null) {
				if (temp.data == temp.next.data)
					temp.next = temp.next.next;

				else
					temp = temp.next;

			}
		}
	}

	/*
	 * 26. Remove duplicates from an unsorted linked list
	 */
	protected static LinkedListNode removeDuplicatesUnsorted(LinkedListNode head) {
		HashSet<Integer> hs = new HashSet<Integer>();
		LinkedListNode temp = head;
		LinkedListNode prev = null;

		if (head == null)
			return null;
		else {

			while (head.next != null) {
				if (!hs.contains(head.data)) {
					hs.add((Integer) head.data);
					prev = head;
					head = head.next;
				} else {
					prev.next = head.next;
					head = head.next;
				}

			}

		}
		return temp;
	}

	/*
	 * 27. Pairwise swap elements of a given linked list.
	 */
	protected static void pairwiseSwap(LinkedListNode head) {

		if (head == null || head.next == null)
			return;
		else {
			int temp_data = (int) head.data;
			head.data = head.next.data;
			head.next.data = temp_data;

			pairwiseSwap(head.next.next);
		}
		// System.out.println(head.data);
	}

	/*
	 * 29. Move last element to front of a given Linked List
	 */

	protected static void moveLasttoFirst(LinkedListNode head) {
		if (head == null || head.next == null)
			return;
		else {

			LinkedListNode lastnode = head;
			LinkedListNode secondlastnode = null;

			while (lastnode.next != null) {
				secondlastnode = lastnode;
				lastnode = lastnode.next;
			}
			secondlastnode.next = null;
			lastnode.next = head;
			head = lastnode;

		}
	}

	/**
	 * 30.Intersection of two Sorted Linked Lists
	 */
	protected static LinkedListNode intersectionSorted(LinkedListNode head1, LinkedListNode head2) {
		if (head1 == null || head2 == null)
			return null;
		else {
			LinkedListNode head3 = null;

			while (head1 != null && head2 != null) {
				if (head1.data == head2.data) {
					if (head3 == null)
						head3 = new LinkedListNode(head1.data);
					else
						head3.insertAtEnd(head1.data);
					head1 = head1.next;
					head2 = head2.next;
				} else if ((int) head1.data < (int) head2.data) {
					head1 = head1.next;
				} else {
					head2 = head2.next;
				}

			}
			return head3;
		}
	}

	/**
	 * Deleting alternate Nodes in a Linked List
	 * 
	 * @param head
	 */

	public static void deleteAlternateNode(LinkedListNode head) {
		if (head == null)
			return;
		LinkedListNode node=head.next;
		head.next = node.next;
		node=null;
		deleteAlternateNode(head.next);
		
	}

	public static void main(String[] args) {

		LinkedListNode head = null;

		// Creating A Linked List
		for (int i = 10; i < 16; i++) {
			if (head == null)
				head = new LinkedListNode(i / 2);
			else
				head.insertAtEnd(i);
		}

		System.out.println("Intial Linked List :");
		LinkedListNode.printLinkedList(head);

		/*
		 * 22.Linked list is Palindrome or Not
		 */
		char str[] = { 'a', 'b', 'c', 'd', 'c', 'b', 'a' };
		LinkedListNode head22 = null;
		for (int i = 0; i < str.length; i++) {
			if (i == 0)
				head22 = new LinkedListNode(str[i]);
			else
				head22.insertAtEnd(str[i]);
		}

		System.out.println("22. Linked list is Palindrome or Not :");
		LinkedListNode.printLinkedList(head22);
		System.out.println("Palindrome is: " + LinkedListNode.palindrome(head22));

		/*
		 * 23. Intersection Linked-List
		 */
		LinkedListNode head2 = null;
		for (int i = 12; i < 16; i++) {
			if (head2 == null)
				head2 = new LinkedListNode(i % 4);
			else
				head2.insertAtEnd(i);
		}

		System.out.println("\n23.  2 linked list are:- ");
		LinkedListNode.printLinkedList(head);
		LinkedListNode.printLinkedList(head2);
		System.out.println("The point of intersection is :");
		LinkedListNode.intersection(head, head2);

		/*
		 * 24. Reversing Linked-List
		 */
		System.out.println("\n24. Linked list is:- ");
		LinkedListNode.printLinkedList(head);
		LinkedListNode.reverseRecursively(head);
		System.out.println("\nAfter reversing Linked list is:- ");
		LinkedListNode.printLinkedList(head);

		/* 25. Remove Duplicates */
		LinkedListNode head25 = null;
		for (int i = 12; i < 20; i++) {
			if (i == 12)
				head25 = new LinkedListNode(i);
			else if (i > 12 & i < 16)
				head25.insertAtEnd(18);
			else
				head25.insertAtEnd(i);
		}
		System.out.println("\n25. Linked list is:- ");
		LinkedListNode.printLinkedList(head25);
		LinkedListNode.removeDuplicates(head25);
		LinkedListNode.printLinkedList(head25);

		/* 26. Remove Duplicates Unsorted List */
		System.out.println("\n26. Linked list is:- ");
		LinkedListNode head26 = null;
		for (int i = 12; i < 20; i++) {
			if (head26 == null)
				head26 = new LinkedListNode(i + 3);
			else
				head26.insertAtEnd(i);

		}
		LinkedListNode.printLinkedList(head26);
		LinkedListNode.removeDuplicatesUnsorted(head26);
		LinkedListNode.printLinkedList(head26);

		/* 27. Pairwise Swap */
		System.out.println("\n27. Linked list is:- ");
		LinkedListNode.printLinkedList(head);
		// LinkedListNode.pairwiseSwap(head);
		System.out.println("After Paiwise Swap:- ");
		LinkedListNode.printLinkedList(head);

		/*
		 * Recheck solution --- 29. Move last element to front of a given Linked
		 * List System.out.println("\n29. Linked list is:- "); LinkedListNode
		 * head29 = null; for (int i = 12; i < 17; i++) { if (head29 == null)
		 * head29 = new LinkedListNode(i); else head29.insertAtEnd(i);
		 * 
		 * }
		 * 
		 * LinkedListNode.printLinkedList(head29);
		 * LinkedListNode.moveLasttoFirst(head29); System.out.
		 * println("After moving last element to the front of a list:- ");
		 * LinkedListNode.printLinkedList(head29);
		 */

		/*
		 * 30. Intersection of two Linked list
		 */
		System.out.println("\n30. 2 Linked list is:- ");
		LinkedListNode.printLinkedList(head);
		LinkedListNode.printLinkedList(head2);
		LinkedListNode head3 = LinkedListNode.intersectionSorted(head, head2);
		System.out.println("\nIntersection of Sorted Linked list is:- ");
		LinkedListNode.printLinkedList(head3);

		/*
		 * 31. Delete alternate nodes in a linked list
		 */
		System.out.println("-----------31---------------");
		System.out.println("Delete alternate nodes in a Linked list is:- ");
		LinkedListNode.printLinkedList(head);
		LinkedListNode.deleteAlternateNode(head);
		LinkedListNode.printLinkedList(head);
		System.out.println("--------------------------");

	}

}
