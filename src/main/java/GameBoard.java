/**
 * Class that represents a game board
 * @author Leon Chiang
 * @version 1.0.0
 */

public class GameBoard {

    private String[][] Board;
    private GamePiece[][] Board2;


    /**
     * Default constructor for the GameBoard class
     */


    public GameBoard() {
        this.Board = new String[5][5];
        for (int i = 0; (this.Board).length>i; i++) {
            for (int j = 0; j < (this.Board[i]).length; j++) {
                this.Board[i][j] = "Empty";
            }
        }

        this.Board[0][0] = "Start";
        this.Board[4][4] = "End";
        this.Board[0][3] = "Bonus";
        this.Board[1][0] = "Penalty";
        this.Board[1][2] = "Bonus";
        this.Board[2][1] = "Penalty";
        this.Board[3][0] = "Bonus";
        this.Board[3][4] = "Bonus";
        this.Board[3][2] = "Penalty";
        this.Board[4][3] = "Penalty";
        this.Board2 = new GamePiece[5][5];
    }

    /**
     * Constructor for the GameBoard class given a Board in the form of a 2D String array
     * @param Board 2D array board that has rows and columns
     * @throws NullPointerException If Board is null
     * @throws IllegalArgumentException If Board has rows of different sizes
     */

    public GameBoard (String[][] Board) throws NullPointerException, IllegalArgumentException {
        if (Board == null) {
            throw new NullPointerException("Board cannot be null");
        }
        if (Board.length >=1 && Board[0].length >=1) {
            throw new IllegalArgumentException("Game board must be of valid size greater then 1x1");
        }

        for (String[] i : Board) {
            if (i.length != Board[0].length) {
                throw new IllegalArgumentException ("Columns sizes must all be equal");
            }
        }

        this.Board = Board;
        this.Board2= new GamePiece [Board.length][Board[0].length];
    }

    /**
     * Method to get the number of rows in the board
     * @param Board 2D String array with rows and columns
     * @return The number of rows in the board as an integer
     */

    public int getRows (String[][] Board) {
        return (this.Board).length;
    }

    /**
     * Method to get the number of column in the board
     * @param Board 2D String array with rows and columns
     * @return The number of columns in the board as an integer
     */

    public int getColumns (String[][] Board) {
        return (this.Board[0]).length;
    }

    /**
     * Method to get tile type on the board at a specific row and column
     * @param row Row of the tile
     * @param col Column of the tile
     * @return The type of tile at that specific row and column as a String
     * @throws IndexOutOfBoundsException If rows and columns do not exist on the board

     */

    public String getTile (int row, int col) {
        try {
            return this.Board[row-1][col-1];
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Row and Column must be valid");
            return null;
        }
    }

    /**
     * Method to set a type of tile onto a board at a specific row and column
     * @param row Row of the tile
     * @param col Column of the tile
     * @param type Type of tile being set
     * @throws IndexOutOfBoundsException If rows and columns do not exist on the board
     */

    public void setTile (int row, int col, String type){
        try {
            this.Board[row-1][col-1]=type;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Row and Column must be valid");
        }
    }

    /**
     * Method to place a gamepiece on a tile at a specific row and column
     * @param piece Game piece being placed on the tile
     * @param row Row of the tile
     * @param col Column of the tile
     * @throws NullPointerException If game piece is null
     * @throws IndexOutOfBoundsException If rows and columns do not exist on the board
     */

    public void placePiece (GamePiece piece, int row, int col) throws NullPointerException {
        if (piece == null) {
            throw new NullPointerException ("Piece must exist");
        }

        try {
            this.Board2[row-1][col-1] = piece;
        }
        catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Row and Column must be valid");
        }
        
    }

    /**
     * Method to remove a game piece from a tile
     * @param row Row of the tile the game piece is at
     * @param col Column of the tile the game piece is at
     * @throws NullPointerException If game piece is not at that tile
     * @throws IndexOutOfBoundsException If rows and columns do not exist on the board
     */

    public void removePiece (int row, int col) throws NullPointerException {
        
        if (this.Board[row-1][col-1] == null) {
            throw new NullPointerException ("Piece must be present on this tile");
        }
        try {
            this.Board2[row-1][col-1] = null;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Row and Column must be valid");
        }

    }

    /**
     * Method that returns the game piece at a specific tile
     * @param row Row which the tile is at
     * @param col Column which the tile is at
     * @return The game piece at that specific tile, returns null if the game piece is not there
     * @throws IndexOutOfBoundsException Row and column does not exist on the board
     */

    public GamePiece getPiece (int row, int col) throws IndexOutOfBoundsException {
        try {
            if (this.Board2[row-1][col-1] == null) {
                return null;
            }
            GamePiece piece = this.Board2[row-1][col-1];
            return piece;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Row and Column must be valid");
            return null;
        }
    }

    /**
     * Method that returns a boolean based off whether a game piece is present at a tile
     * @param row Row of the tile that is being checked
     * @param col Column of the tile that is being checked
     * @return True if the game piece is present at the tile, else false
     * @throws IndexOutOfBoundsException Row and column does not exist on the board
     */

    public boolean hasPiece(int row, int col) {
        try {
            if (this.Board2[row-1][col-1] == null) {
            return false;
        }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Row and Column must be valid");
        }

        return true;
    }

    /**
     * Method that replaces the tiles of the board with Strings given by the array tiles
     * @param tiles Array of strings with strings that tiles of the board are being replaced by left to right, up to down
     */

    public void fillFrom (String[] tiles) {
        int count = tiles.length;
        if (count<=0) {
            for (int i = 0; i < this.Board.length; i++) {
                for (int j = 0; j < this.Board[i].length; j++) {
                    this.Board[i][j] = tiles[tiles.length - count];
                    count--;
                    if (count <= 0) {
                        j=this.Board[i].length;
                        i=this.Board.length;
                    }
                }
            }
        }
    }

    /**
     * Method that sets all tiles on the board to empty except for the top left "Start" tile and bottom right "End" tile
     */

    public void resetBoard() {
        for (int i = 0; (this.Board).length>i; i++) {
            for (int j = 0; j < (this.Board[i]).length; j++) {
                this.Board[i][j] = "Empty";
            }
        }

        for (int i = 0; (this.Board2).length>i; i++) {
            for (int j = 0; j < (this.Board2[i]).length; j++) {
                this.Board2[i][j] = null;
            }
        }

        this.Board[0][0] = "Start";
        this.Board[4][4] = "End";
    }

    /**
     * Overrides the toString() method, returns the board printed out
     * @return Returns the board in rows and columns with the type of Tile along with game pieces on the tile printed out
    */

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < this.Board.length; i++) {
            for (int j = 0; j < this.Board[0].length; j++) {
                out += Board[i][j];
                if (Board2[i][j] != null) {
                    out += "(" + Board2[i][j].toString() + ")";
                }
                out += (j != this.Board[0].length - 1) ? " | " : "\n";
            }
        }
        return out;
    }
}
