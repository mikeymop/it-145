package graphs;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Represents a Node in a Graph
 * @property value - The the Nodes name
 * @property children - A HashMap of nodes, whos value is the cardinality for that Node
 * @author mikey
 *
 */
public class Node {
	public String value;
	public Map<Node, Integer> children;

	public Node(String value) {
		this.value = value;
		this.children = new HashMap<Node, Integer>();
	}
	
	public boolean equals(Node node) {
		if(this.value == node.value) { return true; }
		else { return false; }
	}
}