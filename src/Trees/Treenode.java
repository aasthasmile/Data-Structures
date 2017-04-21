package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Map.Entry;

public class Treenode<T> {

	T data;
	Treenode<T> left;
	Treenode<T> right;
	Treenode<T> parent;
	int height;

	Treenode(T item) {
		data = item;
		left = right = parent = null;
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
	 * Left) Time Complexity :O(n) Space Complexity :O(n)-->Stack maintains the
	 * recursive calls
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
	 * Left) Time Complexity :O(n) Space Complexity :O(n)
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
	 * Data) Time Complexity :O(n) Space Complexity :O(n)
	 */

	public void postOrderTraversal(Treenode root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	/**
	 * * Pre Order Traversal of a Binary Tree. Time Complexity :O(n) Space
	 * Complexity :O(n)
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

	/**
	 * In Order Traversal of a Binary Tree Time Complexity :O(n) Space
	 * Complexity :O(n)
	 */
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

	/**
	 * Post Order Traversal of a Binary Tree
	 * 
	 * 1.1 Create an empty stack 2.1 Do following while root is not NULL a) Push
	 * root's right child and then root to stack. b) Set root as root's left
	 * child. 2.2 Pop an item from stack and set it as root. a) If the popped
	 * item has a right child and the right child is at top of stack, then
	 * remove the right child from stack, push the root back and set root as
	 * root's right child. b) Else print root's data and set root as NULL. 2.3
	 * Repeat steps 2.1 and 2.2 while stack is not empty.
	 */
	public void postOrderIterative(Treenode root) {
		Stack<Treenode> st = new Stack<Treenode>();
		st.push(new Treenode(-1));

		do {
			while (root != null) {
				if (root.right != null)
					st.push(root.right);
				st.push(root);
				root = root.left;
			}

			root = st.pop();

			if (root.right != null && st.peek() == root.right) {
				st.pop();
				st.push(root);
				root = root.right;
			} else {
				System.out.print(root.data + " ");
				root = null;
			}

		} while (!st.isEmpty());

	}

	/**
	 * Breadth first Search or Level Order Traversal of a Binary Tree.
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
					return root;
				}
				if (polled.right != null)
					queue.offer(polled.right);
				else {
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
			polled = q.peek();
		}
		int height = insertinBTRecursive_height(polled, data, q);
		return height;

	}

	/**
	 * Maximum Element in a Binary Tree. Search the maximum element in left
	 * subtree and search the maximum element in right subtree.Compare them with
	 * the element at the root and return the maximum. Complexity : O(n) using
	 * level order Traversal i.e BFS Space Complexity :O(n)
	 */

	public int MaxElementinBT(Treenode root) {
		Queue<Treenode> queue = new LinkedList<Treenode>();
		if (root == null)
			return 0;
		if (maxdata < (int) root.data)
			maxdata = (int) root.data;

		queue.offer(root.left);
		queue.offer(root.right);

		while (!queue.isEmpty())
			MaxElementinBT(queue.poll());

		return maxdata;
	}

	/**
	 * Maximum Element in Binary Tree using Pre order Traversal DFS No extra
	 * Space complexity.
	 */
	public int MaxElementinBT_PreOrder(Treenode root) {
		if (root == null)
			return maxdata;

		if (maxdata < (int) root.data)
			maxdata = (int) root.data;

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
		if ((int) root.data == data)
			return root;
		else if (leftroot != null)
			return leftroot;
		else if (rightroot != null)
			return rightroot;

		return null;
	}

	/**
	 * Size of the Binary Tree. The total number of nodes in the binary tree
	 * (including root of the tree)
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
	 * Level Order Traversal in reverse Order. Method : We are using a Stack and
	 * a Queue. In post order traversal(LRD) rather than printing the last
	 * element , we are adding it to the stack using level order traversal
	 * 
	 * *10* 20* *30 40* *50 *60 *70 Stack : 10 20 30 Queue : 40 50 60 70 Finally
	 * transfer all the elements in the queue to the top of the stack . Print
	 * all the elements in Stack in LIFO order.
	 * 
	 * @param root
	 */
	public void LevelOrderReverse(Treenode node) {
		if (node == null)
			return;
		Queue<Treenode> q = new LinkedList<Treenode>();
		Stack<Treenode> stack = new Stack<Treenode>();

		q.offer(node);

		while (!q.isEmpty()) {
			Treenode root = q.poll();
			if (root.left != null)
				q.add(root.left);
			if (root.right != null)
				q.add(root.right);

			stack.push(root);
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");
		}

	}

	/** Height of a tree in Binary tree */
	public int height(Treenode root) {
		if (root == null)
			return 0;
		int leftheight = 1;
		leftheight = leftheight + height(root.left);

		int rightheight = 1;
		rightheight = rightheight + height(root.left);

		return (leftheight > rightheight) ? leftheight : rightheight;
	}

	/** Diameter of a tree (width of the tree) */
	List<Integer> list = new ArrayList<Integer>();

	public int widthOfTree(Treenode root) {
		List<Integer> list = diameter(root);

		// Sorting the list to get two top elements in a list
		Collections.sort(list, Collections.reverseOrder());

		int diameter = list.get(0) + list.get(1) + 1;
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

	/**
	 * Maximum Depth of a Binary tree. The maximum depth is the number of nodes
	 * along the longest path from root node down to the leaf node.
	 */
	public int maximumDepth(Treenode root) {
		if (root == null)
			return 0;

		int left = maximumDepth(root.left);
		int right = maximumDepth(root.right);

		// Diameter
		// max=Math.max(max,left+right);
		// return max

		return (Math.max(left, right) + 1);
	}

	/**
	 * Minimum Depth of a Binary tree. The minimum depth is the number of nodes
	 * along the shortest path from root node down to the nearest leaf node.
	 */
	public int minimumDepth(Treenode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		int left = minimumDepth(root.left);
		int right = minimumDepth(root.right);

		/*
		 * if the left subtree is a null Tree , we consider the right subtree
		 * value
		 */
		if (left == 0)
			return right + 1;
		else if (right == 0)
			return left + 1;
		return (Math.min(left, right) + 1);
	}

	/**
	 * Total Number of leaves in the binary tree. Method : If a node has both
	 * left and right children as NULL then the nodes are called leaf nodes and
	 * hence we increment the count.
	 */

	public int numberOfLeaves(Treenode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int leftcount = numberOfLeaves(root.left);
		int rightcount = numberOfLeaves(root.right);

		return (leftcount + rightcount);
	}

	/**
	 * Number of Full Nodes in a binary Tree. Definition : A full node is a node
	 * that has both left and right children.
	 */

	public int numberOfFullNodes(Treenode root) {
		if (root == null)
			return 0;

		int leftcount = numberOfFullNodes(root.left);
		int rightcount = numberOfFullNodes(root.right);
		if (root.left == null && root.right == null)
			return 0;
		if (root.left != null && root.right != null) {
			return 1 + leftcount + rightcount;
		}
		if (root.left == null && root.right != null) {
			return rightcount;
		}
		if (root.left != null && root.right != null) {
			return leftcount;
		}
		return 0;

	}

	/**
	 * Number of half nodes in a Binary Tree. Definition : Nodes having only one
	 * child is called Half nodes.
	 */
	public int numberOfHalfNodes(Treenode root) {
		if (root == null)
			return 0;

		int leftcount = numberOfHalfNodes(root.left);
		int rightcount = numberOfHalfNodes(root.right);

		/*
		 * If either one of left or right child is null,then it is considered as
		 * half nodes, hence we add 1 to the value getting from left subtree and
		 * right subtree. else if both child's are not null ,then it is
		 * considered as full node, hence we don't consider an extra 1 added to
		 * left or right subtree.
		 */
		if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
			return 1 + leftcount + rightcount;
		} else {
			return leftcount + rightcount;
		}
	}

	/**
	 * Two Trees are Identical to Each other. Base Condition:If both trees are
	 * Null ,return true (as they are identical). Otherwise we recurively check
	 * the left and right subtree to check whether they are identical or not.
	 */

	public boolean IdenticalTrees(Treenode root1, Treenode root2) {
		/*
		 * * Base Condition:If both trees are Null ,return true (as they are
		 * identical).
		 */
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		/*
		 * if two strings are identical then Comparator outputs a zero, if first
		 * string greater than second string then comparator outputs greater
		 * than zero(positive values, else first string less than second string
		 * then comparator outputs less than zero(negative values)
		 */

		if (!((root1.data.toString()).compareTo(root2.data.toString()) == 0)) {
			return false;
		}

		boolean left = IdenticalTrees(root1.left, root2.left);
		boolean right = IdenticalTrees(root1.right, root2.right);

		/*
		 * if both left and right subtree is Similar or Identical ,return True
		 * else return false
		 */
		return (left && right);

	}

	/**
	 * Finding the level that has maximum sum in the binary tree. (Level Order
	 * traversal Algorithm).
	 */

	public int findLevelwithMaximumSum(Treenode root) {
		if (root == null)
			return 0;
		int max = Integer.MIN_VALUE;
		int level = 0;
		Queue<Treenode> queue = new LinkedList<Treenode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelSum = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Treenode temp = queue.poll();
				levelSum += (int) temp.data;

				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			if (max < levelSum)
				max = levelSum;
			/*
			 * level with maximum sum of nodes i.e height=log(n) as 2^height=n
			 */
			level = (int) Math.log(queue.size());
		}
		return max;
	}

	/**
	 * Finding all the paths from the root to the leaf nodes and print them.
	 */

	public void pathRootToLeaf(Treenode root, String str) {

		if (root.left == null && root.right == null) {
			String s = str +" "+ root.data;
			System.out.println(s);
			return;
		}
		pathRootToLeaf(root.left, str +" "+ root.data);
		pathRootToLeaf(root.right, str+" " + root.data);

	}

	/**
	 * Finding all the paths from the root to the leaf nodes with a particular
	 * sum.
	 * 
	 */
	public boolean pathRootToLeafWithSum(Treenode root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null) {
			if (sum == (int) root.data)
				return true;
		}

		boolean left = pathRootToLeafWithSum(root.left, sum - (int) root.data);
		boolean right = pathRootToLeafWithSum(root.right, sum - (int) root.data);

		return (left || right);
	}

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 */
	public boolean SymmetricTree(Treenode root1) {
		if (root1 == null)
			return true;
		return isMirror(root1.left, root1.right);
	}

	/**
	 * Given two binary trees,check whether they are mirror of each other or not
	 */
	public boolean isMirror(Treenode root1, Treenode root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (!(root1.data == root2.data))
			return false;

		boolean left = isMirror(root1.left, root2.right);
		boolean right = isMirror(root1.right, root2.left);

		return (left && right);
	}

	/**
	 * Level Order Traversal in Spiral Order (zig-zag order- left to right then
	 * next row right to left and vice versa)
	 * 
	 * @param root
	 */
	public void LevelOrderSpiral(Treenode root) {

		if (root == null)
			return;
		List<Integer> list = new LinkedList<Integer>();
		Stack<Treenode> s1 = new Stack<Treenode>(); // Left to right
		Stack<Treenode> s2 = new Stack<Treenode>(); // right to left
		s1.push(root);

		while (!s1.isEmpty() || !s2.isEmpty()) {

			while (!s1.isEmpty()) {
				Treenode curr = s1.pop();
				if (curr.left != null)
					s2.push(curr.left);
				if (curr.right != null)
					s2.push(curr.right);
				System.out.print(curr.data + " ");
			}

			while (!s2.isEmpty()) {
				Treenode curr = s2.pop();
				if (curr.right != null)
					s1.push(curr.right);
				if (curr.left != null)
					s1.push(curr.left);
				System.out.print(curr.data + " ");
			}
		}

	}

	/*
	 * Build Binary Tree from Post-order and In-order Traversal of the tree.
	 */
	public Treenode buildBinaryTree(int[] preOrder, int[] inorder) {
		if (preOrder.length == 0 || preOrder.length != inorder.length) {
			return null;
		}
		Treenode root = buildTree(preOrder, 0, preOrder.length - 1, inorder, 0, inorder.length - 1);
		return root;
	}

	private Treenode buildTree(int[] preOrder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
		if (pStart > pEnd || iStart > iEnd)
			return null;

		Treenode root = new Treenode(preOrder[pStart]);
		int offset = iStart;
		while (offset < iEnd) {
			if (inorder[offset] == preOrder[pStart])
				break;
		}
		root.left = buildTree(preOrder, pStart + 1, pStart + offset - iStart, inorder, iStart, offset - 1);
		root.right = buildTree(preOrder, pStart + offset - iStart + 1, pEnd, inorder, offset + 1, iEnd);
		return root;

	}

	/**
	 * Vertical order traversal of Tree
	 */
	public void VerticalOrderTraversal(Treenode root) {
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		int horizantalDist=0;
		
		calculateVerticalSum(root,map,horizantalDist);
		
		
		for(Entry<Integer, List<Integer>> entry : map.entrySet())
			System.out.println(entry.getKey()+"  |  "+entry.getValue());
		

	}

	private void calculateVerticalSum(Treenode root, HashMap<Integer, List<Integer>> map, int horizantalDist) {
		
		if(root.left!=null)
			calculateVerticalSum(root.left,map,horizantalDist-1);
		if(root.right!=null)
			calculateVerticalSum(root.right,map,horizantalDist+1);
		
		if(!map.containsKey(horizantalDist))
			map.put(horizantalDist,new ArrayList<>());
		map.get(horizantalDist).add((Integer) root.data);
		
	}
	
	/**Lowest Common Ancestor *
	 */
	public Treenode lowestCommonAncestor(Treenode root,Object value1,Object value2){
		if(root==null) return null;
		if(root.data.equals(value1) || root.data.equals(value2))
			return root;
		Treenode left=lowestCommonAncestor(root.left, value1, value2);
		Treenode right=lowestCommonAncestor(root.right, value1, value2);
		
		if(left!=null && right!=null)
			return root;
		if(left==null && right==null)
			return null;
		
        return (left!=null )?left:right;
	}
}
