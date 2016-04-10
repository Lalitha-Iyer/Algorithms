package tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TreeHelper {

	private static void dfs(Node parent, int parentId, String[] arrayTree) {
		String leftNodeStr = "";
		String rightNodeStr = "";
		int leftIndex = parentId * 2 + 1;
		int rightIndex = parentId * 2 + 2;

		if (leftIndex < arrayTree.length)
			leftNodeStr = arrayTree[leftIndex];
		if (rightIndex < arrayTree.length)
			rightNodeStr = arrayTree[rightIndex];
		if (!leftNodeStr.equals("")) {
			Node left = new Node();
			left.parent = parent;
			parent.left = left;
			left.val = Integer.parseInt(leftNodeStr);
			dfs(left, leftIndex, arrayTree);
		}
		if (!rightNodeStr.equals("")) {
			Node right = new Node();
			right.parent = parent;
			parent.right = right;
			right.val = Integer.parseInt(rightNodeStr);
			dfs(right, rightIndex, arrayTree);
		}
	}

	// public static void bfsDump(Node parent){
	// LinkedQueue<Node> queue=new LinkedQueue<Node>
	// }
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Node root = readTree(args[0]);
		Tree tree = new Tree(root);
		System.out.print("tree depth " + tree.getDepthBFS());
		tree = new Tree(null);
		System.out.println("tree depth " + tree.getDepthBFS());

	}

	public static Node readTree(String path) throws IOException {

		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line.replace(" ", "").replace("\t", ""));
		}
		String[] arrayTree = sb.toString().split(",");
		Node root = new Node();
		// some check should be here
		if (arrayTree.length == 0)
			root = null;
		else {
			root.val = Integer.parseInt(arrayTree[0]);
			dfs(root, 0, arrayTree);
		}
		return root;
	}

}
