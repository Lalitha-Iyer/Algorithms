package tree;

public class ValidateBST {

	boolean isValidBST(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root != null && root.val < max && root.val > min) {
			if (!isValidSubTree(root)) {
				return false;
			}
			return (isValidBST(root.left, min, less(max, root.val)) && isValidBST(
					root.right, more(min, root.val), max));

		}
		return true;
	}

	boolean isValidSubTree(Node subTree) {
		if (subTree.left != null) {
			if (subTree.val < subTree.left.val)
				return false;
		}
		if (subTree.right != null) {
			if (subTree.val > subTree.right.val)
				return false;
		}
		return true;

	}

	int less(int first, int second) {
		if (first < second)
			return first;
		else
			return second;
	}

	int more(int first, int second) {
		if (first < second)
			return second;
		else
			return first;
	}

	public static void main(String[] args) {
		Node root = new Node();
		root.val = 9;

		root.left = new Node();
		root.left.val = 1;

		root.right = new Node();
		root.right.val = 10;
		
		root.right.left = new Node();
		root.right.left.val = 8;
		
		ValidateBST vbst = new ValidateBST();
		System.out.print(vbst.isValidBST(root, Integer.MIN_VALUE,
				Integer.MAX_VALUE));

	}

}
