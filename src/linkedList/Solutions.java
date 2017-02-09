/**
 * 
 */
package linkedList;

/**
 * @author Aastha Jain
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
		System.out.println("--------------------------");
		System.out.println("\n30. 2 Linked list is:- ");
		LinkedListNode.printLinkedList(head);
		LinkedListNode.printLinkedList(head2);
		LinkedListNode head3 = LinkedListNode.intersectionSorted(head, head2);
		System.out.println("Intersection of Sorted Linked list is:- ");
		LinkedListNode.printLinkedList(head3);
		System.out.println("--------------------------");

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
