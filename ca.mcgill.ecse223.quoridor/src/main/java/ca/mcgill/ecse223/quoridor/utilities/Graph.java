package ca.mcgill.ecse223.quoridor.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.mcgill.ecse223.quoridor.model.Tile;

/**
 * Graph class used to determine if a path exists for a player. 
 * Created with inspiration from https://www.baeldung.com/java-graphs
 * @author Tristan Bouchard
 *
 */
public class Graph {
	public HashMap<Node, List<Node>> adjNodes;
	
	public Graph() {
		 adjNodes = new HashMap<Node, List<Node>>();
	}
	/**
	 * Method used to add a node to our graph.
	 * @param tile
	 */
	public void addNode(Tile tile) {
		Node n = new Node(tile);
	    adjNodes.putIfAbsent(n, new ArrayList<Node>());
	}
	 
	/**
	 * Method used to remove a node from our graph based on a given tile
	 * @param tile
	 */
	public void removeNode(Node tile) {
	    adjNodes.values().stream().forEach(e -> e.remove(tile));
	    adjNodes.remove(tile);
	}
	
	/**
	 * Method used to add an edge between nodes containing the tiles
	 * @param tile1
	 * @param tile2
	 */
	public void addEdge(Tile currTile, Tile adjTile) {
		Node n1 = new Node(currTile);
		Node n2 = new Node(adjTile);
		if(!adjNodes.get(n1).contains(n2)) {
			adjNodes.get(n1).add(n2);
		}
	    if(!adjNodes.get(n2).contains(n1)) {
	    	adjNodes.get(n2).add(n1);
	    }
	}
	
	/**
	 * Method used to remove an edge between two nodes containing the specified tiles
	 * @param tile1
	 * @param tile2
	 */
	public void removeEdge(Tile tile1, Tile tile2) {
		Node n1 = new Node(tile1);
		Node n2 = new Node(tile2);
	    List<Node> eV1 = adjNodes.get(n1);
	    List<Node> eV2 = adjNodes.get(n2);
	    if (eV1 != null)
	        eV1.remove(n2);
	    if (eV2 != null)
	        eV2.remove(n1);
	}
	
	/**
	 * Method used to get the verticies adjacent to the node containing the tile.
	 * @param tile
	 * @return
	 */
	public List<Node> getAdjNodes(Tile tile) {
		Node n = new Node(tile);
	    return adjNodes.get(n);
	}
	
}
