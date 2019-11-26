package ca.mcgill.ecse223.quoridor.utilities;

import java.util.ArrayList;
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
	public Map<Node, List<Node>> adjVertices;
	
	/**
	 * Method used to add a node to our graph.
	 * @param tile
	 */
	void addNode(Tile tile) {
	    adjVertices.putIfAbsent(new Node(tile), new ArrayList<>());
	}
	 
	/**
	 * Method used to remove a node from our graph based on a given tile
	 * @param tile
	 */
	void removeNode(Tile tile) {
	    Node v = new Node(tile);
	    adjVertices.values().stream().forEach(e -> e.remove(v));
	    adjVertices.remove(new Node(tile));
	}
	
	/**
	 * Method used to add an edge between nodes containing the tiles
	 * @param tile1
	 * @param tile2
	 */
	void addEdge(Tile tile1, Tile tile2) {
	    Node v1 = new Node(tile1);
	    Node v2 = new Node(tile2);
	    adjVertices.get(v1).add(v2);
	    adjVertices.get(v2).add(v1);
	}
	
	/**
	 * Method used to remove an edge between two nodes containing the specified tiles
	 * @param tile1
	 * @param tile2
	 */
	void removeEdge(Tile tile1, Tile tile2) {
	    Node v1 = new Node(tile1);
	    Node v2 = new Node(tile2);
	    List<Node> eV1 = adjVertices.get(v1);
	    List<Node> eV2 = adjVertices.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}
	
	/**
	 * Method used to get the verticies adjacent to the node containing the tile.
	 * @param tile
	 * @return
	 */
	List<Node> getAdjVertices(Tile tile) {
	    return adjVertices.get(new Node(tile));
	}
	
}
