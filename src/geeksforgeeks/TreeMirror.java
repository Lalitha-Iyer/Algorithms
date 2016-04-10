package geeksforgeeks;

public class TreeMirror {

	private class Node {

		int val;
		Node left;
		Node right;

		Node() {

		}
	}

	static boolean isSymmetric(Node left, Node right) {
		boolean leftR = false, rightR = false;
		if (left == null && right == null)
			return true;
		if ((left != null && right != null) && left.val == right.val) {
			leftR = isSymmetric(left.left, right.right);
			rightR = isSymmetric(left.right, right.left);
		}
		return (leftR & rightR);
	}

	static boolean isSymmetric(Node root) {
		if (root == null)
			return true;
		else
			return isSymmetric(root.left, root.right);

	}

	public static void main(String[] args) {
		TreeMirror tm = new TreeMirror();
		Node root = tm.new Node();
		root.val = 1;

		root.left = tm.new Node();
		root.left.val = 2;

		root.right = tm.new Node();
		root.right.val = 3;

		System.out.println(isSymmetric(root));
	}

}
