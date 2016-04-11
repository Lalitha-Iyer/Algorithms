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
		if(n.left!=null){
			Node current=n.left;
			while(current.left!=null){
				current=current.left;
			}
			return current;
		}else{
			Node current=n;
			while(true){
				if(current.parent==null)
					return null;
				if(current.parent.left==current)
					return current.parent;
				current=current.parent;
			}
		}
			
	}
	

}
