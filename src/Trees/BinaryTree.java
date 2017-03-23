package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Treenode<Integer> root = new Treenode<Integer>(1);
		root.left = new Treenode<Integer>(2);
		root.right = new Treenode<Integer>(3);
		root.left.left = new Treenode<Integer>(4);
		root.left.right = new Treenode<Integer>(5);
		root.right.left = new Treenode<Integer>(6);
		root.right.right = new Treenode<Integer>(7);

		System.out.println("\nInserting an element in the Binary Tree:");
		Tree t = new Tree();
		Treenode<Integer> rootnode = null;
		for (int i = 1; i <= 7; i++) {
			if (rootnode == null)
				rootnode = new Treenode<Integer>(i);
			else
				t.insertInBinaryTree(rootnode, i);
		}

		t.preOrderTraversal(rootnode);

		System.out.println("\nThe preorder traversal is :");
		t.preOrderTraversal(root);

		System.out.println("\nThe Inorder traversal is :");
		t.InOrderTraversal(root);

		System.out.println("\nThe postorder traversal is :");
		t.postOrderTraversal(root);

		System.out.println("\nThe preorder traversal(iteratively) is :");
		t.preOrderIterative(root);

		System.out.println("\nThe Inorder traversal(iteratively) is :");
		t.InOrderIterative(root);

		System.out.println("\nThe LevelOrder traversal is :");
		t.LevelOrderTraversal(root);

		System.out.println("\nFinding Maximum Element in a Binary tree :");
		System.out.println(t.MaxElementinBT(root));
		System.out.println(t.MaxElementinBT_PreOrder(root));

		System.out.println("\n--------Tree 2: ------ ");
		Queue<Treenode> queue = new LinkedList<Treenode>();
		;
		Treenode<Integer> tree2 = null;

		for (int i = 10; i <= 16; i++) {
			if (tree2 == null)
				tree2 = t.insertinBT_Recursive(null, i, queue);
			else
				tree2 = t.insertinBT_Recursive(tree2, i, queue);
		}

		t.LevelOrderTraversal(tree2);

		System.out.println("\nFinding the size of the tree :");
		System.out.print(t.SizeOfBT(tree2));

		System.out.println("\nSearching an Element in a Binary Tree :");
		Treenode curr = t.SearchElementinBT(tree2, 10);
		t.preOrderTraversal(curr);

		System.out.println("\nHeight of the tree:");
		System.out.println(t.height(tree2));

		System.out.println("\n--------Tree 3: ------ ");
		Treenode<Integer> tree3 = null;
		int height = 0;

		for (int i = 10; i <= 17; i++) {
			if (tree3 == null)
				tree3 = t.insertinBT_Recursive(null, i, queue);
			else
				height = t.insertinBTRecursive_height(tree3, i, queue);
			System.out.print(height +" ");
		}
        
		System.out.println("Tree 3 using BFS: ");
		t.LevelOrderTraversal(tree3);

		System.out.println("\n\nWidth of the tree: ");
		System.out.println(t.widthOfTree(tree3));

	}

}
