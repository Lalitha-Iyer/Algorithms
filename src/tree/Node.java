package tree;

public class Node {

	public Node(int val, Node parent, Node left, Node right) {
		super();
		this.val = val;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}

	int val;
	Node parent;
	Node left;
	Node right;

	public Node insert(Node root, int val) {
		if (root == null) {
			root = new Node(val, null, null, null);
			return root;
		}
		if (root.val < val) {
			root.right = insert(root.right, val);
		} else {
			root.left = insert(root.left, val);
		}
		return root;
	}

	public void preOrder(Node root) {
		if (root == null)
			return;
		else {
			System.out.print("\t" + root.val);
			preOrder(root.left);
			preOrder(root.right);
		}

	}

	public void postOrder(Node root) {
		if (root == null)
			return;
		else {
			preOrder(root.left);
			preOrder(root.right);
			System.out.print("\t" + root.val);
		}
	}

	public void inOrder(Node root) {

		if (root == null)
			return;
		else {
			inOrder(root.left);
			System.out.print("\t" + root.val);
			inOrder(root.right);

		}
	}

}
