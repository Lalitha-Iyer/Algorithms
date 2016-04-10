package tree;

import java.util.LinkedList;

public class Tree {

	public Tree(Node root) {
		super();
		this.root = root;
	}

	Node root;

	int getDepthBFS() {

		LinkedList<Node> q = new LinkedList<Node>();
		if (root == null) {
			return 0;
		}
		q.add(root);
		q.add(null);
		Node current = null;
		int depth = 0;
		while (!(q.isEmpty() )) {
			current = q.remove();
			//Null node in queue indicates end of level
			if (current == null) {
				if (!q.isEmpty()) {
					q.add(current);
				}
				depth++;
				continue;
			}
			//Add left and right child if they are not null
			if (current.left != null) {
				q.add(current.left);
			}
			if (current.right != null) {
				q.add(current.right);
			}
		}

		return depth;

	}

	public void getDepthDFS(){
		int[] maxDepth={0};
		getDepthDFS(root,0,maxDepth);
	}
	private void getDepthDFS(Node parent,int currentDepth,int[] maxDepth) {
		if(parent.left!=null){
			getDepthDFS(parent.left,currentDepth+1,maxDepth);
		}
		if(parent.right!=null){
			getDepthDFS(parent.right,currentDepth+1,maxDepth);
		}
		if(parent.left==null&&parent.right==null&&currentDepth>maxDepth[0]){
			maxDepth[0]=currentDepth;
		}
	}
	
}
