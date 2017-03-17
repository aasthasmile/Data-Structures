package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Treenode<T> {

	T data;
	Treenode left;
	Treenode right;
	Treenode parent;

	Treenode(T item) {
		data = item;
		left = null;
		right = null;
		parent = null;
	}

	T getData() {
		return data;
	}

	public Treenode getLeft() {
		return left;
	}

	public Treenode getRight() {
		return left;
	}

	public void setLeft() {
		this.left = left;
	}

	public void setRight() {
		this.right = right;
	}

	void preOrderTraversal(Treenode root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	public void InOrderTraversal(Treenode root) {
		if (root == null)
			return;

		InOrderTraversal(root.left);
		System.out.print(root.data + " ");
		InOrderTraversal(root.right);

	}

	public void postOrderTraversal(Treenode root) {
		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");

	}

	public void preOrderIterative(Treenode root) {
		Stack st = new Stack();
		Treenode current = root;
		st.push(root);

		while (!st.empty()) {
			current = (Treenode) st.pop();
			while (current.left != null || current.data != null) {
				if (current.left == null) {
					System.out.print(current.data + " ");
					break;
				} else {
					if (current.right != null)
						st.push(current.right);
					System.out.print(current.data + " ");
					current = current.left;
				}
			}
		}
	}

	public void InOrderIterative(Treenode root) {

		Stack<Treenode> st = new Stack<Treenode>();
		Treenode current = root;

		boolean done = false;

		while (!done) {

			if (current != null) {
				st.push(current);
				current = current.left;

			} else {
				if (st.isEmpty())
					done = true;
				else {
					current = st.pop();
					System.out.print(current.data + " ");
					// if (current.right != null)
					current = current.right;

				}
			}
		}
	}

	public void postOrderIterative(Treenode root) {
		Stack st = new Stack();
		Treenode current = root;
		st.push(root);

	}

	public void LevelOrderTraversal(Treenode root) {
		Queue<Treenode> myQueue = new LinkedList<Treenode>();

		if (root == null || (root.left == null && root.right == null))
			return;

		myQueue.add(root);
		while (!myQueue.isEmpty()) {
			Treenode element = myQueue.remove();
			System.out.print(element.data + " ");
			if (element.left != null)
				myQueue.add(element.left);
			if (element.right != null)
				myQueue.add(element.right);

		}

	}

	public Treenode InsertBT(Treenode root, T data) {

		if (root == null) {
			root = new Treenode<T>(data);
			return root;
		}

		if ((int) root.data >= (int) data) {
			InsertBT(root.left, data);
			root.left = new Treenode<T>(data);
		} else{
			InsertBT(root.right, data);
			root.right = new Treenode<T>(data);
		}
		return root;
	
	}
}
