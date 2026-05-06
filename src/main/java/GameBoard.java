/**
 * Class that represents a game board
 * @author Leon Chiang
 * @version 1.0.0
 */

public class GameBoard {

    private String[][] board;
    private GamePiece[][] board2;


    /**
     * Default constructor for the GameBoard class
     */


    public GameBoard() {
        this.board = new String[5][5];
        for (int i = 0; (this.board).length>i; i++) {
            for (int j = 0; j < (this.board[i]).length; j++) {
                this.board[i][j] = "Empty";
            }
        }

        this.board[0][0] = "Start";
        this.board[4][4] = "End";
        this.board[0][3] = "Bonus";
        this.board[1][0] = "Penalty";
        this.board[1][2] = "Bonus";
        this.board[2][1] = "Penalty";
        this.board[3][0] = "Bonus";
        this.board[3][4] = "Bonus";
        this.board[3][2] = "Penalty";
        this.board[4][3] = "Penalty";
        this.board2 = new GamePiece[5][5];
    }

    /**
     * Constructor for the GameBoard class given a board in the form of a 2D String array
     * @param board 2D array board that has rows and columns
     * @throws NullPointerException If board is null
     * @throws IllegalArgumentException If board has rows of different sizes
     */

    public GameBoard (String[][] board) throws NullPointerException, IllegalArgumentException {
        if (board == null) {
            throw new NullPointerException("Board cannot be null");
        }
        if (board.length <= 1 && board[0].length <= 1) {
            throw new IllegalArgumentException("Game board must be of valid size greater then 1x1");
        }

        for (String[] i : board) {
            if (i.length != board[0].length) {
                throw new IllegalArgumentException ("Columns sizes must all be equal");
            }
        }

        this.board = board;
        this.board2= new GamePiece[board.length][board[0].length];
    }

    /**
     * Method to get the number of rows in the board
     * @param board 2D String array with rows and columns
     * @return The number of rows in the board as an integer
     */

    public int getRows (String[][] board) {
        return (this.board).length;
    }

    /**
     * Method to get the number of column in the board
     * @param board 2D String array with rows and columns
     * @return The number of columns in the board as an integer
     */

    public int getColumns (String[][] board) {
        return (this.board[0]).length;
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
            return this.board[row-1][col-1];
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
            this.board[row-1][col-1]=type;
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
            this.board2[row-1][col-1] = piece;
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
        
        if (this.board[row-1][col-1] == null) {
            throw new NullPointerException ("Piece must be present on this tile");
        }
        try {
            this.board2[row-1][col-1] = null;
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
            if (this.board2[row-1][col-1] == null) {
                return null;
            }
            GamePiece piece = this.board2[row-1][col-1];
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

    public boolean hasPiece(int row, int col) throws IndexOutOfBoundsException {
        try {
            return !(this.board2[row - 1][col - 1] == null);
        }
        catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Row and Column must be valid");
        }
    }

    /**
     * Method that replaces the tiles of the board with Strings given by the array tiles
     * @param tiles Array of strings with strings that tiles of the board are being replaced by left to right, up to down
     */

    public void fillFrom (String[] tiles) throws NullPointerException {
        if (tiles == null || String.join("", tiles).replaceAll(" ", "").equals("")) {
            throw new NullPointerException("Array to fill from must not be empty or null");
        }
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                this.board[i][j] = tiles[((i * this.board[0].length) + j) % tiles.length];
            }
        }
    }

    /**
     * Method that sets all tiles on the board to empty except for the top left "Start" tile and bottom right "End" tile
     */

    public void resetBoard() {
        for (int i = 0; this.board.length > i; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                this.board[i][j] = "Empty";
            }
        }

        for (int i = 0; this.board2.length > i; i++) {
            for (int j = 0; j < this.board2[i].length; j++) {
                this.board2[i][j] = null;
            }
        }

        this.board[0][0] = "Start";
        this.board[getRows(this.board) - 1][getColumns(this.board) - 1] = "End";
    }

    /**
     * Overrides the toString() method, returns the board printed out
     * @return Returns the board in rows and columns with the type of Tile along with game pieces on the tile printed out
    */

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                out += board[i][j];
                if (board2[i][j] != null) {
                    out += "(" + board2[i][j].toString() + ")";
                }
                out += (j != this.board[0].length - 1) ? " | " : "\n";
            }
        }
        return out;
    }
}
