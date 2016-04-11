package tree;

public class BST extends Tree {

	void insertBST(Node n) {
		root = insertBSTHelper(n, root);

	}

	Node insertBSTHelper(Node in, Node currentRoot) {
		if (currentRoot == null) {
			return in;
		}
		if (in.val > currentRoot.val) {
			currentRoot.right = insertBSTHelper(in, currentRoot.right);

		} else {
			currentRoot.left = insertBSTHelper(in, currentRoot.left);
		}
		return currentRoot;

	}
	
	
	Node getSuccessor(Node n)
	{
		return n;		
	}
	
	Node getPredecessor(Node n)
	{
		return n;		
	}
	

}
