public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        TileStack tilesStack = new TileStack(new String[]{"1", "2", "3"});
        for (String i : tilesStack.removeAll()) {
            System.out.println(i);
        }
        System.out.println(tilesStack);
        board.fillFrom(new String[]{"Bonus", "House", "Penalty", "Penalty"});
        GamePiece dog = new GamePiece("Dog", "Green", 849);
        GamePiece cat = new GamePiece("Cat", "Blue", 65);
        board.placePiece(dog, 1, 1);
        board.placePiece(cat, 2, 1);
        Player player = new Player("Frank", 16);
        System.out.println(board);
        player.pickUp(board, 1, 1);
        System.out.println(board);
        System.out.println(board.hasPiece(2, 1));
    }
}