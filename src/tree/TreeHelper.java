package tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.sun.xml.internal.ws.util.StringUtils;

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

	 public static void bfsDump(Node parent,int depth,int nodewidth){
		 //String.format("%07d", number);
		 LinkedList<Node> queue=new LinkedList<Node>();
		 queue.add(parent);
		 queue.add(null);
		 int level=1;
		 int totalWidth=(int) Math.ceil((nodewidth*Math.pow(2, depth-1)));
		 
		 while(queue.size()!=0){
			 Node current=queue.poll();
			 if(current==null){
				 level++;
				 if(queue.size()!=0)
					 queue.add(null);
				 System.out.println();
				 continue;
			 }
			 int currentNodeNum=(int) Math.ceil(Math.pow(2, level-1));
			 int padding=(totalWidth/(currentNodeNum+1)-nodewidth);
			 if(padding<0)
				 padding=0;
			 System.out.print(new String(new char[padding]).replace("\0", " "));
			 System.out.print(String.format("%0"+nodewidth+"d",current.val));
			 
			 if(current.left!=null)
				 queue.add(current.left);
			 if(current.right!=null)
				 queue.add(current.right);
			 
		 }
	 }
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Node root = readTree(args[0]);

		Tree tree = new Tree(root);
		System.out.println("tree depth BFS " + tree.getDepthBFS());
		System.out.println("tree depth DFS " + tree.getDepthDFS1());
		tree = new Tree(null);
		System.out.println("tree depth BFS " + tree.getDepthBFS());
		Node bstRoot = createBST();
		bfsDump(bstRoot,7,3);
		bstRoot.inOrder(bstRoot);
		System.out.println();
		//System.out.println("Sucessor of Root value "+bstRoot.val+ "is "+ BST.getSuccessor(bstRoot).val);	
		System.out.println("Sucessor of Root value "+bstRoot.val+ "is "+ BST.getPredecessor(bstRoot).val);	
		
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
	
	
	public static Node  createBST()
	{
			Integer[] in = generateRandomArray(10);
			BST tree = new BST();
			
			for(Integer i : in)
			{
				Node n = new Node(i, null, null,  null);
				tree.insertBST(n);
			}		
			
			return tree.root;
	}
	
	public static Integer[] generateRandomArray(int size)
	{
		Integer[] array=new Integer[size*10];
		for(int i=0;i<array.length;i++){
			array[i]=i;
		}
		List<Integer> list=Arrays.asList(array);
		Collections.shuffle(list);
		return (Integer[]) Arrays.copyOfRange(list.toArray(),0,size);
	}

}
