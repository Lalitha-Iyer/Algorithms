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
			currentRoot.right.parent = currentRoot;

		} else {
			currentRoot.left = insertBSTHelper(in, currentRoot.left);
			currentRoot.left.parent = currentRoot;

		}
		return currentRoot;

	}
	
	
	static Node getSuccessor(Node n)
	{
		if(n.right !=null)
			return getMin(n.right);
		else
			return getSuccessorHelper(n);
	}
	
	static Node getSuccessorHelper(Node n)
	{
		if(n == null )
			return null;
		Node parent = n.parent;
		if(  parent.left != n)
		{
			return getSuccessorHelper(parent);
		}
		else
		{
			return parent; 
		}
	}
	
	Node getPredecessor(Node n)
	{
		return n;		
	}
	

}
