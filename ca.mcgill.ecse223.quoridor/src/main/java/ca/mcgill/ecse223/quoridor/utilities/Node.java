package ca.mcgill.ecse223.quoridor.utilities;

import java.util.List;

import ca.mcgill.ecse223.quoridor.model.Tile;

/**
 * Node class containing a unique tile from the game board
 * Used in the implementation of the Graph class, which was
 * strongly inspired from https://www.baeldung.com/java-graphs
 * @author Tristan Bouchard
 *
 */
public class Node {
    public Tile tile;
    
    /**
     * Public constructor for the node
     * @param tile - Node to add to the tile
     */
    public Node(Tile tile) {
    	this.tile = tile;
    }
}
