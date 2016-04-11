package tree;

import java.util.LinkedList;

public class Tree {

	public Tree(Node root) {
		super();
		this.root = root;
	}

	public Tree() {
		// TODO Auto-generated constructor stub
	}

	Node root;

	public Node getRoot() {
		return root;
	}

	static Node copyNode(Node n) {
		Node out = new Node();
		out.val = n.val;
		out.parent = n.parent;
		out.left = n.left;
		out.right = n.right;
		return out;
	}

	static Node getMin(Node in) {
		Node temp = copyNode(in);
		while (temp.left != null) {
			temp = in.left;
		}
		return temp;
	}

	
	static Node getMax(Node in) {
		Node temp = copyNode(in);
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}
	public void setRoot(Node root) {
		this.root = root;
	}

	int getDepthBFS() {

		LinkedList<Node> q = new LinkedList<Node>();
		if (root == null) {
			return 0;
		}
		q.add(root);
		q.add(null);
		Node current = null;
		int depth = 0;
		while (!(q.isEmpty())) {
			current = q.remove();
			// Null node in queue indicates end of level
			if (current == null) {
				if (!q.isEmpty()) {
					q.add(current);
				}
				depth++;
				continue;
			}
			// Add left and right child if they are not null
			if (current.left != null) {
				q.add(current.left);
			}
			if (current.right != null) {
				q.add(current.right);
			}
		}

		return depth;

	}

	public int getDepthDFS() {
		int[] maxDepth = { 1 };
		getDepthDFS(root, 1, maxDepth);
		return maxDepth[0];
	}

	private void getDepthDFS(Node parent, int currentDepth, int[] maxDepth) {
		if (parent.left != null) {
			getDepthDFS(parent.left, currentDepth + 1, maxDepth);
		}
		if (parent.right != null) {
			getDepthDFS(parent.right, currentDepth + 1, maxDepth);
		}
		if (parent.left == null && parent.right == null
				&& currentDepth > maxDepth[0]) {
			maxDepth[0] = currentDepth;
		}
	}

	public int getDepthDFS1() {
		int maxDepth = 1;
		maxDepth = getDepthDFS1(root, 1);
		return maxDepth;
	}

	private int getDepthDFS1(Node parent, int currentDepth) {
		int leftMax = -1, rightMax = -1;
		if (parent.left != null) {
			leftMax = getDepthDFS1(parent.left, currentDepth + 1);
		}
		if (parent.right != null) {
			rightMax = getDepthDFS1(parent.right, currentDepth + 1);
		}
		if (parent.left == null && parent.right == null) {
			return currentDepth;
		}
		return leftMax > rightMax ? leftMax : rightMax;
	}

}
