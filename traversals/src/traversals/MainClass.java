package traversals;

public class MainClass {

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		
		for(int i = 0; i <= 5; i++) {
			tree.insert(tree.root, i);
		}
		for(int i = 10; i >= 5; i--) {
			tree.insert(tree.root, i);
		}
		
		tree.preOrder(tree.root);
	}
}
