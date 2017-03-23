package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Treenode<T> {

	T data;
	Treenode<T> left;
	Treenode<T> right;
	Treenode<T> parent;

	int height;

	Treenode(T item) {
		data = item;
		left = null;
		right = null;
		parent = null;
	}

	Treenode() {

	}

	T getData() {
		return data;
	}

	public Treenode<T> getLeft() {
		return left;
	}

	public Treenode<T> getRight() {
		return left;
	}

	public void setLeft() {
		this.left = left;
	}

	public void setRight() {
		this.right = right;
	}

}

class Tree {

	int maxdata = Integer.MIN_VALUE;

	/**
	 * Pre-Order Traversal of a Binary Tree. (Data Left Right) or (Data Right
	 * Left)
	 * 
	 * @param root
	 */

	void preOrderTraversal(Treenode root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	/**
	 * In Order Traversal of a Binary Tree. ( Left Data Right) or (Right Data
	 * Left)
	 * 
	 * @param root
	 */

	public void InOrderTraversal(Treenode root) {
		if (root == null)
			return;

		InOrderTraversal(root.left);
		System.out.print(root.data + " ");
		InOrderTraversal(root.right);

	}

	/**
	 * Post Order Traversal of a Binary Tree. (Left Right Data) or (Right Left
	 * Data)
	 * 
	 * @param root
	 */

	public void postOrderTraversal(Treenode root) {
		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");

	}

	/**
	 * * Pre Order Traversal of a Binary Tree
	 * 
	 * @param root
	 */
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

	/** In Order Traversal of a Binary Tree */
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

	/** Post Order Traversal of a Binary Tree */
	public void postOrderIterative(Treenode root) {
		Stack st = new Stack();
		Treenode current = root;
		st.push(root);

	}

	/**
	 * Breadth first Search or Level Order Traversal of a Binary Tree.
	 * 
	 * @param root
	 */
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

	/**
	 * Inserting node in a Binary Tree. We can add wherever we want but we will
	 * use level order traversal and insert Element wherever we found the left
	 * or Right child is equal to NULL. Method : We are using Queue is maintain
	 * Breadth first Search Traversal for each node and adding it to queue and
	 * checking whether its left and right child is available or not. *
	 */
	public Treenode insertInBinaryTree(Treenode root, int data) {
		if (root == null) {
			root = new Treenode(data);
			return root;
		}
		Queue<Treenode> queue = new LinkedList<Treenode>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			Treenode polled = queue.poll();
			if (polled != null) {
				if (polled.left != null)
					queue.offer(polled.left);
				else {
					polled.left = new Treenode(data);
					// polled.left.height=root.height+1;
					return root;
				}
				if (polled.right != null) {
					queue.offer(polled.right);
				} else {
					polled.right = new Treenode(data);
					// polled.right.height=root.height+1;
					return root;
				}
			}
		}
		return root;
	}

	public Treenode<Integer> insertinBT_Recursive(Treenode node, int data, Queue<Treenode> q) {

		if (node == null) {
			node = new Treenode<Integer>(data);
			return node;
		}

		Treenode<Integer> root = node;

		if (root.left == null) {
			root.left = new Treenode<Integer>(data);
			// root.left.height=root.height+1;
			return node;
		} else if (root.right == null) {
			root.right = new Treenode<Integer>(data);
			// root.right.height=root.height+1;
			return node;
		} else {
			q.add(root.left);
			q.add(root.right);
		}

		insertinBT_Recursive(q.poll(), data, q);
		return node;
	}

	public int insertinBTRecursive_height(Treenode node, int data, Queue<Treenode> q) {

		if (node == null) {
			node = new Treenode<Integer>(data);
			node.height = 0;
			return node.height;
		}

		Treenode<Integer> root = node;

		if (root.left == null) {
			root.left = new Treenode<Integer>(data);
			root.left.height = root.height + 1;
			return root.left.height;
		} else if (root.right == null) {
			root.right = new Treenode<Integer>(data);
			root.right.height = root.height + 1;
			return root.right.height;
		} else {
			q.add(root.left);
			q.add(root.right);
		}

		Treenode polled = q.peek();
		if (polled.left != null && polled.right != null) {
			q.remove();
			polled=q.peek();
		}
		int height = insertinBTRecursive_height(polled, data, q);
		return height;

	}

	/**
	 * Maximum Element in a Binary Tree. Search the maximum element in left
	 * subtree and search the maximum element in right subtree.Compare them with
	 * the element at the root and return the maximum. Complexity : O(n) using
	 * level order Traversal i.e BFS Space Complexity :O(n)
	 * 
	 * @param root
	 */

	public int MaxElementinBT(Treenode root) {
		if (root == null)
			return 0;

		Queue<Treenode> queue = new LinkedList<Treenode>();

		if (maxdata < (int) root.data)
			maxdata = (int) root.data;

		if (root.left != null)
			queue.offer(root.left);
		if (root.right != null)
			queue.offer(root.right);

		while (!queue.isEmpty()) {
			MaxElementinBT(queue.poll());
		}

		// System.out.println(maxdata);
		return maxdata;
	}

	/**
	 * Maximum Element in Binary Tree using Pre order Traversal DFS No extra
	 * Space complexity
	 * 
	 * @param root
	 */

	public int MaxElementinBT_PreOrder(Treenode root) {
		if (root == null) {
			return maxdata;
		}

		if (maxdata < (int) root.data) {
			maxdata = (int) root.data;
		}
		MaxElementinBT_PreOrder(root.left);
		MaxElementinBT_PreOrder(root.right);

		return maxdata;
	}

	/**
	 * Search an Element in a Binary Tree.If we pass the root of a Tree, it
	 * should return boolean value to indicate element is found or not.
	 */
	public Treenode SearchElementinBT(Treenode root, int data) {
		if (root == null)
			return null;

		Treenode leftroot = null, rightroot = null;

		leftroot = SearchElementinBT(root.left, data);
		rightroot = SearchElementinBT(root.right, data);
		if ((int) root.data == data) {
			return root;
		} else if (leftroot != null)
			return leftroot;
		else if (rightroot != null)
			return rightroot;

		return null;
	}

	/**
	 * Size of the Binary Tree. The total number of nodes in the binary tree
	 * (including root of the tree)
	 * 
	 * @param root
	 */
	public int SizeOfBT(Treenode node) {
		int size = 0;
		if (node == null)
			return 0;
		size++;
		size = size + SizeOfBT(node.left);
		size = size + SizeOfBT(node.right);

		return size;
	}

	/**
	 * Level Order Traversal in reverse Order.
	 * Method : We are using a Stack and a Queue. 
	 * In post order traversal(LRD) rather than printing the last element , we are adding it to
	 * the stack using level order traversal 
	 * 
	 *          *10*
	 *    20*          *30
	 * 40*   *50     *60    *70
	 * 
	 * Stack : 10 20 30
	 * Queue : 40 50 60 70
	 * 
	 * Finally transfer all the elements in the queue to the top of the stack .
	 * Print all the elements in Stack in LIFO order.
	 * @param root
	 */
	public void LevelOrderReverse(Treenode root) {
		if (root == null)
			return;
		Queue<Treenode> q = new LinkedList<Treenode>();
		Stack<Treenode> stack = new Stack<Treenode>();
		
		q.offer(root);
		
		while(!q.isEmpty()){
			if(root.left!=null)
				q.add(root.left);
			if(root.right!=null)
				q.add(root.right);
			
		stack.push	(root);
		}
		
		System.out.print(stack.pop()+" ");

	}

	/**
	 * Height of a tree in Binary tree.
	 * 
	 */
	public int height(Treenode root) {
		if (root == null) {
			return 0;
		}

		int leftheight = 1;
		leftheight = leftheight + height(root.left);

		int rightheight = 1;
		rightheight = rightheight + height(root.left);

		if (leftheight > rightheight) {
			return leftheight;
		} else {
			return rightheight;
		}

	}

	/** Diameter of a tree (width of the tree) */
	List<Integer> list = new ArrayList<Integer>();
	public int widthOfTree(Treenode root) {

		List<Integer> list = diameter(root);

		//Sorting the list to get two top elements in a list
		Collections.sort(list, Collections.reverseOrder());

		int diameter = list.get(0) + list.get(1)+1;

		return diameter;

	}

	public List<Integer> diameter(Treenode root) {

		if (root == null)
			return null;

		diameter(root.left);
		diameter(root.right);
		
		list.add(root.height);
		return list;

	}

}
