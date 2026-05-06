/**
 * Class the defines a game piece by name, color, and point value
 * @author Leon Chiang
 * @version 1.0.0
 */

public class GamePiece {

    private String label;
    private String color;
    private int pointValue;

    /**
     * Constructor for GamePiece class
     * @param label Name of the piece
     * @param color Color of the piece
     * @param pointValue Scoring value of the piece
     * @throws IllegalArgumentException If label or color are null or empty strings
     */

    public GamePiece(String label, String color, int pointValue) throws IllegalArgumentException {
        if (label == null || color == null || label.strip().equals("") || color.strip().equals("")) {
            throw new IllegalArgumentException("Label and color must not be null or empty strings");
        }

        this.label = label;
        this.color = color;
        this.pointValue = pointValue;
    }

    /**
     * Method to get the name of the piece
     * @return The name of the piece as a String
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Method to get the color of the piece
     * @return The color of the piece as a String
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Method to get the scoring value of a piece
     * @return The scoring value of a piece as an int
     */
    public int getPointValue() {
        return this.pointValue;
    }

    /**
     * Overrides the toString() method, returns the game piece as a string
     * @return Returns the color and name of the piece
     */
    @Override
    public String toString() {
        return this.color + " " + this.label;
    }

    /**
     * Overrides the equals() method, checks if two pieces share the same name, color, and scoring value
     * @param obj Object that the piece is being compared to
     * @return Returns true if name, color, and scoring value are equal, otherwise false 
     * @throws IllegalArgumentException If obj is not of type GamePIece
     */
    @Override
    public boolean equals(Object obj) throws IllegalArgumentException {
        if (!(obj instanceof GamePiece)) {
            throw new IllegalArgumentException("Argument for equals() must be of type GamePiece");
        }
        GamePiece GamePiece = (GamePiece) obj;
        return this.label.equals(GamePiece.getLabel()) && this.color.equals(GamePiece.getColor()) && this.pointValue == GamePiece.getPointValue();
    }
    
    


}