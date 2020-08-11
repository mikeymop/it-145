package traversals;

public class BinaryTree {

	Node root;
	
	public BinaryTree() {
		this.root = null; // ensure the BT is empty when initialized.
	}
	
	/**
	 * Insert a node, such that it keeps the BinaryTree in ascending order:
	 * <ul>
	 *  <li> If node is > the value 
	 *  <li> if new node is smaller than current node, move to left child
	 *	<li> if new node is greater than current node, move to right child
	 *  <li> if current node is null, at leaf node, insert new node here
	 * </ul>
	 * @param node - The Node you want to reference
	 * @param value - The value you want to put in the new node.
	 */
	public void insert(Node node, int value) {
		if(node.value > value) { 
			if(node.left != null) {            // if child has a value, repeat the process
				this.insert(node.left, value); // for all of it's children
			}
			else {
				System.out.printf("Creating left child Node: %d\n", value);
				node.left = new Node(value); // the child is empty, so create a new Node
			}
		} // insert left

		else if(node.value < value) {
			if(node.right != null) { // if child has a value, repeat the process
				this.insert(node.right, value); // repeat until you find empty node
			}
			else { // the child is empty, create a new Node
				System.out.printf("Creating right child Node: %d\n", value);
				node.right = new Node(value);
			}
		} // insert right	
	}
	
	/**
	 * <ul>
	 * <li> Use Recursion to step down one level
	 * <li> If the node is not empty, print value
	 * <li> Move down to left leaf
	 * <li> Move down to right leaf
	 * </ul>
	 * @param node
	 */
	public void preOrder(Node node) {
		if(node != null) {
			System.out.printf("Found Node: %d\n", node.value);
			this.preOrder(node.left); // Move down to left leaf
			this.preOrder(node.right); // Move down to right leaf
		}
		
	}
	
	/**
	 * Uses Recursion
	 * <ul>
	 * <li> Use recursion to step down one level
	 * <li> If left leaf is not empty, enter it
	 * <li> If left leaf is empty, print current node
	 * <li> If right leaf is not empty, enter it
	 * <li> Move up one level
	 * </ul>
	 * @param node
	 */
	public void inOrder(Node node) {
		if(node != null) { // skip if the node is empty
			this.inOrder(node.left); // check the left leaf, skip if empty
			System.out.printf("Found Node: %d\n", node.value); // print value of current node before moving right
			this.inOrder(node.right); // check the right leaf, skip if empty
		}
	}
}