package Trees;

import java.util.LinkedList;
import java.util.Queue;

import javax.print.attribute.IntegerSyntax;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Treenode root=new Treenode(1);
		root.left=new Treenode(2);
		root.right=new Treenode(3);
		root.left.left=new Treenode(4);
		root.left.right=new Treenode(5);
		root.right.left=new Treenode(6);
		root.right.right=new Treenode(7);
		
		System.out.println("\nThe preorder traversal is :");
		root.preOrderTraversal(root);
		
		System.out.println("\nThe Inorder traversal is :");
		root.InOrderTraversal(root);
		
		System.out.println("\nThe postorder traversal is :");
		root.postOrderTraversal(root);
		
		System.out.println("\nThe preorder traversal(iteratively) is :");
		root.preOrderIterative(root);
		
		System.out.println("\nThe Inorder traversal(iteratively) is :");
		root.InOrderIterative(root);
		
		System.out.println("\nThe LevelOrder traversal is :");
		root.LevelOrderTraversal(root);
		
		System.out.println("\nInserting an element in the Binary Tree:");
		Treenode newroot=root.InsertBT(root, 9);
		root.InOrderIterative(newroot);
		

		

	}

}
