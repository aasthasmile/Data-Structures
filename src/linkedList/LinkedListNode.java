/**
 * 
 */
package linkedList;

import java.util.HashMap;
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

	public static LinkedListNode reverseIteratively(LinkedListNode head) {
		if (head == null || head.next == null)
			return null;
		LinkedListNode curr = head;
		LinkedListNode prev = null;
		LinkedListNode next = null;

		// Iterative code for reversing the linked list
		// Steps can be explained as :
		// 1. Take three Nodes previous ,current ,next
		// 2. Initially prev=null eg null->2->3->4->5
		// 3. Assign current to Head node i.e. 2->
		// 4. Assign next to current to next .
		// 5.In a loop, change next to prev, prev to current and current to
		// next.(Iteratively).
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}
		head = prev;
		return head;
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
	 * 31. Deleting alternate Nodes in a Linked List using Recursion . Time
	 * Complexity : O(n)
	 * 
	 * Method : Pick the link of the second node pointer and place that in the
	 * link of the first node pointer.Delete the Second node.
	 * 
	 * @param head
	 */

	public static void deleteAlternateNode(LinkedListNode head) {
		if (head == null)
			return;
		LinkedListNode node = head.next;
		head.next = node.next;
		node = null;
		deleteAlternateNode(head.next);

	}

	/**
	 * 32. Alternating split of a given Singly Linked List
	 * 
	 * @param args
	 */
	public static void AlternatingSplit(LinkedListNode head) {
		if (head == null)
			return;

		LinkedListNode a = null;
		LinkedListNode b = null;

		while (head.next != null) {
			if (a == null)
				a = new LinkedListNode(head.data);
			else
				a.insertAtEnd(head.data);

			head = head.next;

			if (b == null)
				b = new LinkedListNode(head.data);
			else
				b.insertAtEnd(head.data);

			if (head.next != null)
				head = head.next;
		}

		System.out.print("List 1 : ");
		LinkedListNode.printLinkedList(a);
		System.out.print("List 2 : ");
		LinkedListNode.printLinkedList(b);
	}

	/**
	 * Identical Linked Lists using Recursion :Two Linked Lists are identical
	 * when they have same data and arrangement of data is also same. For
	 * example Linked lists a (1->2->3) and b(1->2->3) are identical.
	 * 
	 * @param args
	 */

	public static boolean areIdentical(LinkedListNode head1, LinkedListNode head2) {
		if (head1 == null && head2 == null)
			return true;

		if (head1 != null && head2 != null) {
			if (head1.data != head2.data)
				return false;

		}
		return areIdentical(head1.next, head2.next);
	}

	/**
	 * Merge Sort for Linked Lists Let head be the first node of the linked list
	 * to be sorted and headRef be the pointer to head. Note that we need a
	 * reference to head in MergeSort() as the below implementation changes next
	 * links to sort the linked lists (not data at the nodes), so head node has
	 * to be changed if the data at original head is not the smallest value in
	 * linked list
	 */

	public static HashMap FrontBackSplit(LinkedListNode head) {
		if (head == null)
			return null;

		LinkedListNode list1 = null;
		LinkedListNode list2 = null;
		int size = head.sizeOfLinkedList(head);
		int count = 1;
		while (head.next != null) {

			if (count <= size / 2) {
				if (list1 == null)
					list1 = new LinkedListNode(head.data);
				else
					list1.insertAtEnd(head.data);

				head = head.next;
				count++;
			} else {
				if (list2 == null)
					list2 = new LinkedListNode(head.data);
				else
					list2.insertAtEnd(head.data);

				if (head.next != null)
					head = head.next;
			}

		}
		if (size % 2 != 0)
			list2.insertAtEnd(head.data);

		HashMap<Integer, LinkedListNode> map = new HashMap<>();
		map.put(1, list1);
		map.put(2, list2);
		return map;

	}

	public static void MergeSort(LinkedListNode head) {

		if (head == null || head.next == null)
			return;

		HashMap<Integer, LinkedListNode> map = new HashMap<>();
		map = FrontBackSplit(head);
		LinkedListNode list1 = map.get(1);
		LinkedListNode list2 = map.get(2);

		System.out.print("List1 ");
		LinkedListNode.printLinkedList(list1);
		System.out.print("List2 ");
		LinkedListNode.printLinkedList(list2);

		while (list1 != null)
			MergeSort(list1);
		while (list2 != null)
			MergeSort(list2);

		head = SortedMerge(list1, list2);
		LinkedListNode.printLinkedList(head);
	}

	public static LinkedListNode SortedMerge(LinkedListNode head1, LinkedListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		LinkedListNode head3 = null;
		while (head1 != null && head2 != null) {
			if ((int) head1.data <= (int) head2.data) {
				head3 = head1;
				head3 = SortedMerge(head1.next, head2);
			} else {
				head3 = head2;
				head3 = SortedMerge(head1, head2.next);
			}
		}
		return head3;

	}

	/**
	 * Reverse a Linked List in groups of given size. Given a linked list, write
	 * a function to reverse every k nodes (where k is an input to the
	 * function).
	 */
	public static LinkedListNode reverseKnodes(LinkedListNode head, int k) {
		if (head == null || head.next == null)
			return null;
		LinkedListNode curr = head;
		LinkedListNode prev = null;
		LinkedListNode next = null;

		int count = 1;

		// Iterative code for reversing the linked list
		// Steps can be explained as :
		// 1. Take three Nodes previous ,current ,next
		// 2. Initially prev=null eg null->2->3->4->5
		// 3. Assign current to Head node i.e. 2->
		// 4. Assign next to current to next .
		// 5.In a loop, change next to prev, prev to current and current to
		// next.(Iteratively).
		while (head != null && count <= k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}

		if (next != null)
			head.next = reverseKnodes(next, k);

		/* prev becomes the new head of the list */
		return prev;

	}

	/**
	 * 37. Delete nodes which have a greater value on right side The list
	 * 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL.
	 * Note that 12, 10, 5 and 2 have been deleted because there is a greater
	 * value on the right side.
	 */
	public static LinkedListNode GreaterRightSide(LinkedListNode head) {
		if (head == null || head.next == null)
			return null;

		// Method 2 (Use Reverse)
		// 1. Reverse the list.
		// 2. Traverse the reversed list. Keep max till now. If next node < max,
		// then delete the next
		// node, otherwise max = next node.
		// 3. Reverse the list again to retain the original order. Time
		// Complexity: O(n)

		LinkedListNode reversed = reverseIteratively(head);

		LinkedListNode curr = reversed;
		LinkedListNode maxNode = reversed;

		while (curr != null && curr.next != null) {
			if ((int) curr.next.data < (int) maxNode.data) {
				LinkedListNode next_to_next = curr.next.next;
				curr.next = null;
				curr.next = next_to_next;
			} else {
				maxNode = curr.next;
				curr = maxNode;
			}
		}

		return reverseIteratively(reversed);

	}

	/**
	 * 38. Segregate even and odd nodes in a Linked List Given a Linked List of
	 * integers, write a function to modify the linked list such that all even
	 * numbers appear before all the odd numbers in the modified linked list.
	 * Also, keep the order of even and odd numbers same.
	 */

	public static void segregateEvenAndOdd(LinkedListNode head) {

		// The idea is to split the linked list into two: one containing all
		// even nodes and other containing all odd nodes.
		// And finally attach the odd node linked list after the even node
		// linked list.

		if (head == null || head.next == null)
			return;

		LinkedListNode current = head;
		LinkedListNode evenplusOdd = null;

		while (current != null) {
			if ((int) current.data % 2 == 0) {
				if (evenplusOdd == null)
					evenplusOdd = new LinkedListNode(current.data);
				else
					evenplusOdd.insertAtEnd(current.data);
			}
			current = current.next;
		}

		while (head != null) {
			if ((int) head.data % 2 != 0) {
				evenplusOdd.insertAtEnd(head.data);
			}
			head = head.next;
		}
		LinkedListNode.printLinkedList(evenplusOdd);

	}

	/**
	 * 39. Detect and Remove Loop in a Linked List. slow and fast pointers meet
	 * at some point after Floyd’s Cycle finding algorithm.
	 * 
	 * Algorithms : So if we start moving both pointers again at same speed such
	 * that one pointer (say slow) begins from head node of linked list and
	 * other pointer (say fast) begins from meeting point. When slow pointer
	 * reaches beginning of linked list (has made m steps). Fast pointer would
	 * have made also moved m steps as they are now moving same pace. Since m+k
	 * is a multiple of n and fast starts from k, they would meet at the
	 * beginning.
	 */

	public static void detectAndRemoveLoop(LinkedListNode head) {

		if (head == null || head.next == null)
			return;

		// Detecting loop in linked list using Slow and Fast Pointer.
		LinkedListNode slow = head;
		LinkedListNode fast = head.next;

		while (fast != null && fast.next != null) {
			if (slow != fast) {
				slow = slow.next;
				fast = fast.next.next;
			} else {
				break;
			}
		}

		// if there is a loop in linked list
		// 1.Move slow and fast pointer at same speed.
		// 2.Slow is at head of linked list and fast is at the meeting point.
		// 3. When slow and fast.next meet each other we are at the intersection
		// 4. We can set fast.next=null to remove the loop
		if (slow == fast) {
			slow = head;
			while (slow != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}

	}

	/**
	 * 40. Adding Two Numbers using Linked List Input: First List: 5->6->3 //
	 * represents number 365 Second List: 8->4->2 // represents number 248
	 * Output Resultant list: 3->1->6 // represents number 613
	 * 
	 */

	public static void AddLinkedListWithCarry(LinkedListNode head1, LinkedListNode head2) {
		int len1 = LinkedListNode.sizeOfLinkedList(head1);
		int len2 = LinkedListNode.sizeOfLinkedList(head2);

		if (head1 == null || head2 == null || len1 != len2)
			return;
		else {
			int carry = 0, data = 0;
			LinkedListNode node3 = null;
			LinkedListNode head3 = null;
			while (head1 != null) {

				data = (((int) head1.data + (int) head2.data) % 10) + carry;
				carry = ((int) head1.data + (int) head2.data) / 10;

				if (node3 == null) {
					node3 = new LinkedListNode(((int) head1.data + (int) head2.data) % 10);
					head3 = node3;
				} else {
					node3.insertAtEnd(data);
				}
				head1 = head1.next;
				head2 = head2.next;

			}

			System.out.println("\n\nLinked list after addition:- ");
			LinkedListNode.printLinkedList(head3);

		}
	}

	/**
	 * QuickSort on Singly Linked List.
	 */

	public static LinkedListNode QuickSort(LinkedListNode begin, LinkedListNode end) {

		if (begin == end)
			return begin;

		// Choose the End Element in Linked list as Pivot element
		LinkedListNode pivot = end;
		LinkedListNode cur = begin;
		LinkedListNode prev = null;
		LinkedListNode node = null;

		// Traverse the linked List while you reach the end of linked list.
		while (pivot != cur) {
			if ((int) cur.data < (int) pivot.data) {
				if (node == null)
					node = cur;
				prev = cur;
				cur = cur.next;
			} else {

				end.next = cur;
				end = end.next;
				LinkedListNode tmp = cur.next;
				cur.next = null;
				cur = tmp;
				if (prev != null) {
					prev.next = cur;
				}
			}
		}
		if (prev != null) {
			node = QuickSort(node, prev);
			LinkedListNode tmp = node;
			while (pivot != tmp.next)
				tmp = tmp.next;
			tmp.next = pivot;
		} else {
			node = pivot;
		}
		if (pivot != end)
			pivot.next = QuickSort(pivot.next, end);
		return node;
	}
}
