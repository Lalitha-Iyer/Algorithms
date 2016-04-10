package udemy;

public class Node<Val> {

	public Node(Val v, Node<Val> next) {
		super();
		this.v = v;
		this.next = next;
	}
	Val v;
	Node<Val> next;
	
}
