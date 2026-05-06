/**
 * Class that represents a stack of event tiles
 * @author Leon Chiang
 * @version 1.0.0
 */

import java.util.ArrayList;
public class TileStack {

    private ArrayList<String> stack;

    /**
     * Constructor for TileStack class given a String array 
     * @param stack
     */
    public TileStack (String[] stack) {
        for (int i = 0; stack.length > i; i++) {
            (this.stack).add(stack[i]);
        }
    } 

    /**
     * Default constructor for TileStack
     */

    public TileStack () {

    }

    /**
     * Method to get the stack of event tiles
     * @return Stack of event tiles in an array of Strings
     */

    public String[] getTileStack() {
        return (this.stack).toArray(new String[this.stack.size()]);
    }

    /**
     * Method to check the number of tiles in the stack
     * @return Size of the stack of event tiles
     */

    public int size() {
        return (this.stack).size();
    }

    /**
     * Method that adds the provided tile to the top of the stack
     * @param tile Tile being added to the stack
     */

    public void push(String tile) {
        if (tile != null || tile == "") {
            (this.stack).add(tile);
        }
    }

    /**
     * Method that removes and returns the top tile from the stack
     * @return Tile on the top of the stack, returns null if tile is null
     */

    public String pop() {
        if ((this.stack).size()<=0) {
            return null;
        }
        String x = (this.stack).get((this.stack).size()-1);
        (this.stack).remove((this.stack).size()-1);
        return x;
    }

    /**
     * Method that checks and returns the top tile
     * @return The top tile of the stack
     */

    public String peek() {
        if ((this.stack).size() <= 0) {
            return null;
        }

        return (this.stack).get((this.stack).size()-1);
    }

    /**
     * Method that returns the stack of event tiles and empties the stack
     * @return Stack of event tiles, returns an empty String array
     */

    public String [] removeAll() {
        if ((this.stack).size() <= 0) {
            return new String[0];
        }
        String [] x = (this.stack).toArray(new String[this.stack.size()]);
        (this.stack).clear();
        return x;
    }

    /**
     * Overrides the toString() method, returns all tiles in the stack as a String
     * @return Returns all tiles in the stack from top to bottom as a String
     */

    @Override
    public String toString() {
        String x = "";
        for (int i = (this.stack).size(); i > 0; i--) {
            x += (this.stack).get(i) + ", ";
        }
        x.substring(0, (this.stack).size()-2);
        return x;
    }
}