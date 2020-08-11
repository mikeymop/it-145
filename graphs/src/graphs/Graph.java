package graphs;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Graph {
	public ArrayList<Node> currentBestPath;
	public ArrayList<Node> children;
	public Node root;

	public Graph() {
		this.currentBestPath = new ArrayList<Node>();
		this.children = new ArrayList<Node>();
		this.root = new Node("root");
	}
	
	public int printCardinality(Node start, Node end) {
		HashMap<Node, Integer> traversed = new HashMap<Node, Integer>();
		int cardinality = 0;
		
		start.children.forEach((node, value) -> {
			if(start.equals(node)) { // found the target, return the weight of array
				for(int val : traversed.values()) {
					cardinality += val; // add the value between each traversed node to the return val.
				}
			} else { // we dont have the node, add it to the list of traversed
				traversed.put(node, value);
			}
		});
		return cardinality;
	}
}
