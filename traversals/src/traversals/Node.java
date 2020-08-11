package traversals;

/**
 * Represents a Node on a BinaryTree
 * @param value - The value to store inside of a Node
 */
public class Node {
	
	public int value;
	Node left; // Reference to a child Node on the left
	Node right; // and to the right.
	
	public Node(int value) {
		this.value = value; // store number locally in the object.
		System.out.printf("New Node, %d\n", this.value);
	}
	
}
