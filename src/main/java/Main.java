public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard(new String[][]{{"Start", "Bonus", "Bonus"}, {"Penalty", "Bonus", "Penalty"}});
        GamePiece dog = new GamePiece("Dog", "Green", 849);
        GamePiece cat = new GamePiece("Cat", "Blue", 65);
        board.placePiece(dog, 1, 1);
        board.placePiece(cat, 2, 1);
        Player player = new Player("Frank", 16);
        player.pickUp(board, 2, 1);
        System.out.println(board.toString());
        player.returnPiece(cat, board, 2, 1);
        System.out.println(board);
    }
}