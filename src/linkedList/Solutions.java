/**
 * 
 */
package linkedList;

/**
 * @author Aastha Jain 29,34
 *
 */
public class Solutions {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println("--------------------------");
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
		System.out.println("--------------------------");

		/*
		 * 23. Intersection Linked-List
		 */
		System.out.println("--------------------------");
		LinkedListNode head2 = null;
		for (int i = 12; i < 17; i++) {
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
		System.out.println("--------------------------");

		/*
		 * 24. Reversing Linked-List
		 */
		System.out.println("--------------------------");
		System.out.println("\n24. Linked list is:- ");
		LinkedListNode.printLinkedList(head);
		LinkedListNode.reverseRecursively(head);
		System.out.println("\nAfter reversing Linked list is:- ");
		LinkedListNode.printLinkedList(head);
		System.out.println("--------------------------");

		/* 25. Remove Duplicates */
		System.out.println("--------------------------");
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
		System.out.println("--------------------------");

		/* 26. Remove Duplicates Unsorted List */
		System.out.println("--------------------------");
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
		System.out.println("--------------------------");

		/* 27. Pairwise Swap */
		System.out.println("-----------27--------------");
		System.out.println("\n27. Linked list is:- ");
		LinkedListNode.printLinkedList(head);
		// LinkedListNode.pairwiseSwap(head);
		System.out.println("After Paiwise Swap:- ");
		LinkedListNode.printLinkedList(head);
		System.out.println("--------------------------");

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
		System.out.println("----------30--------------");
		System.out.println(" 2 Linked list are  ");
		LinkedListNode.printLinkedList(head);
		LinkedListNode.printLinkedList(head2);
		LinkedListNode head3 = LinkedListNode.intersectionSorted(head, head2);
		System.out.println("Intersection of Sorted Linked list is:- ");
		LinkedListNode.printLinkedList(head3);
		System.out.print("--------------------------");

		/**
		 * 31. Delete alternate nodes in a linked list
		 */
		System.out.println("-----------31---------------");
		System.out.println("Delete alternate nodes in a Linked list is:- ");
		LinkedListNode.printLinkedList(head);
		LinkedListNode.deleteAlternateNode(head);
		LinkedListNode.printLinkedList(head);
		System.out.println("--------------------------");

		/**
		 * 32. Alternating split of a given Singly Linked List
		 */
		System.out.println("-----------32---------------");
		System.out.println("Alternating split of a given Singly Linked List ");
		LinkedListNode.printLinkedList(head2);
		LinkedListNode.AlternatingSplit(head2);
		System.out.println("--------------------------");

		/**
		 * 33. Identical Linked Lists
		 */
		System.out.println("----------33-----------");
		System.out.println("Identical Singly Linked List ");
		LinkedListNode.printLinkedList(head);
		System.out.println("Two list are Identical : " + LinkedListNode.areIdentical(head, head));
		System.out.println("Two list are Identical : " + LinkedListNode.areIdentical(head, head2));
		System.out.println("--------------------------");

		/**
		 * 34. Merge Sort for Linked Lists
		 */
		System.out.println("----------34-----------");
		System.out.println("Merge Sort for Linked List ");
		LinkedListNode list = null;
		for (int i = 12; i < 22; i++) {
			if (list == null)
				list = new LinkedListNode(8);
			else if (i % 2 == 0)
				list.insertAtEnd(i / 2);
			else if (i % 3 == 0)
				list.insertAtEnd(i + 8);
			else if (i % 4 == 0)
				list.insertAtEnd(i + 1);
		}
		LinkedListNode.printLinkedList(list);
		// LinkedListNode.MergeSort(list);
		LinkedListNode.printLinkedList(list);
		System.out.println("--------------------------");

		/**
		 * 35. Reverse nodes with a Group of Size k
		 */
		System.out.println("----------35-----------");
		LinkedListNode head35 = null;
		for (int i = 12; i < 21; i++) {
			if (head35 == null)
				head35 = new LinkedListNode(5);
			else
				head35.insertAtEnd(i);
		}
		int k = 4;
		System.out.println("Reverse nodes with a Group of Size " + k);
		LinkedListNode.printLinkedList(head35);
		LinkedListNode reversedList = LinkedListNode.reverseKnodes(head35, k);
		LinkedListNode.printLinkedList(reversedList);
		System.out.println("--------------------------");

		/**
		 * 37. Delete nodes which have a greater value on right side
		 */
		System.out.println("----------37-----------");
		LinkedListNode head36 = null;
		for (int i = 12; i < 21; i++) {
			if (head36 == null)
				head36 = new LinkedListNode(5);
			else
				head36.insertAtEnd(i % 4);
		}

		System.out.println("Delete nodes which have a greater value on right side ");
		LinkedListNode.printLinkedList(head36);
		LinkedListNode greaterRight = LinkedListNode.GreaterRightSide(head36);
		LinkedListNode.printLinkedList(greaterRight);
		System.out.println("--------------------------");

		/**
		 * 38. Segregate even and odd nodes in a Linked List
		 */
		System.out.println("----------38-----------");
		LinkedListNode.printLinkedList(head2);
		System.out.println("Segregate even and odd nodes in a Linked List ");
		LinkedListNode.segregateEvenAndOdd(head2);
		System.out.println("--------------------------");

		/**
		 * 39. Detect and Remove Loop in a Linked List.
		 */
		System.out.println("----------39-----------");
		LinkedListNode head39 = null;
		for (int i = 12; i < 24; i++) {
			if (head39 == null)
				head39 = new LinkedListNode(5);
			else
				head39.insertAtEnd(i % 4);
		}
		head39.next.next.next.next.next = head39.next.next;
		System.out.println("Detect and Remove Loop in a Linked List. ");
		LinkedListNode.detectAndRemoveLoop(head39);
		LinkedListNode.printLinkedList(head39);
		System.out.println("-------------------------");

		/**
		 * 40. Adding Two Numbers using Linked List
		 */
		System.out.println("----------40-----------");
		LinkedListNode head40 = null;
		for (int i = 1; i < 9; i++) {
			if (head40 == null) head40 = new LinkedListNode(5);
			else
				head40.insertAtEnd(i % 4);
		}
		LinkedListNode.printLinkedList(head40);
		LinkedListNode.printLinkedList(head40);
		System.out.println("Adding Two Numbers using Linked List ");
		LinkedListNode.AddLinkedListWithCarry(head40, head40);
		System.out.println("--------------------------");

		/**
		 * QuickSort for LinkedList
		 */
		System.out.println("----------QuickSort-----------");
		
		
		LinkedListNode end = head39;
		while (end != null && end.next != null) {
			end=end.next;
		}
		LinkedListNode.printLinkedList(head39);
		LinkedListNode.printLinkedList(LinkedListNode.QuickSort(head39, end));
	}

}
