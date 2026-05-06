import java.util.ArrayList;
/**
 * Class that defines a player by name, age, and inventory
 * @author Leon Chiang
 * @version 1.0.0
 */

public class Player {
    private String name;
    private int age;
    private ArrayList<GamePiece> inventory;

    /**
     * Constructor for a player given name, age and inventory
     * @param name Name of the player as a String
     * @param age Age of the player as an int
     * @param inventory Inventory of game pieces of the player as a GamePiece array
     */

    public Player (String name, int age, GamePiece [] inventory) {
        this.name = name;
        this.age = age;
        for (int i = 0; i < inventory.length; i++) {
            (this.inventory).add(inventory[i]);
        }
    }

    /**
     * Constructor for a player given name and age, assigning the player a default inventory
     * @param name Name of the player as a String
     * @param age Age of the player as an int
     */

    public Player (String name, int age) {
        this.name = name;
        this.age = age;
        this.inventory = new ArrayList<GamePiece>();
    }

    /**
     * Method to get the name of the player
     * @return Name of the player as a String
     */

    public String getName() {
        return this.name;
    }

    /**
     * Method to get the age of the player
     * @return Age of the player as an int
     */

    public int getAge() {
        return this.age;
    }

    /**
     * Method to get the inventory of the player
     * @return Inventory of the player as a GamePiece array
     */

    public GamePiece[] getInventory() {
        if (this.inventory == null) {
            GamePiece[] x = new GamePiece[0];
            return x;
        }
        GamePiece [] x = new GamePiece [(this.inventory).size()];
        for (int i = 0; i < (this.inventory).size(); i++) {
            x[i]=(this.inventory).get(i);
        }
        return x;
    }

    /**
     * Method to get the number of game pieces in the player's inventory
     * @return Number of game pieces in the player's inventory
     */

    public int size() {
        return (this.inventory).size();
    }

    /**
     * Method that "picks up" a game piece from the game board to the player's inventory
     * @param board Board the game piece comes from
     * @param row Row the game piece was on
     * @param col Column the game piece was on
     * @throws NullPointerException If piece is not at the given tile
     */

    public void pickUp(GameBoard board, int row, int col) throws NullPointerException {
        if (board.getPiece(row, col) == null) {
            throw new NullPointerException ("Piece must exist at that tile");
        }
        (this.inventory).add(board.getPiece(row, col));
        board.removePiece(row, col);
    }

    /**
     * Method that removes the a game piece from a player's inventory
     * @param piece GamePiece that is being removed
     * @throws NullPointerException If piece does not exist in player's inventory
     */

    public void discardPiece(GamePiece piece) throws NullPointerException {
        if ((this.inventory).contains(piece) == false) {
            throw new NullPointerException("Piece must exist in Player's inventory");
        }
        (this.inventory).remove(piece);
    }

    /**
     * Method that removes the piece from the player's inventory and sets in on the given tile
     * @param piece GamePiece being removed from the player's inventory and being added to the game board
     * @param board GameBoard the piece is being added to
     * @param row Row of the given tile
     * @param col Column of the given tile
     * @throws NullPointerException If piece does not exist in Player's inventory
     */

    public void returnPiece(GamePiece piece, GameBoard board, int row, int col) throws NullPointerException, IndexOutOfBoundsException {
        System.out.println(piece);
        if (!(this.inventory).contains(piece)) {
            throw new NullPointerException("Piece must exist in Player's inventory");
        }
        try {
            board.placePiece(piece, row, col);
            (this.inventory).remove(piece);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Row and Column must be valid");
        }
    }

    /**
     * Method that returns the player's age, name and inventory as a singular String
     * @return String of the player's name, age, and inventory
     */

    @Override
    public String toString() {
        String x = "";
        for (int i = 0; i < (this.inventory).size(); i++) {
            x += ", " + (this.inventory).get(i);
        }
        return this.name + ", " + this.age + x;

    }
}