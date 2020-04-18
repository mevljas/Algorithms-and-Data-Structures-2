package si.unilj.fri.vss.aps2.seminar1;

import java.util.List;

/**
 * Abstract class serving as a placeholder for the actual inherited 
 * placement algorithm.
 */
public abstract class PlacementAlgorithm {

    /**
     * Reference to the board
     */
    protected final Board board;

    /**
     * List of the puzzle pieces
     */
    protected final List<PuzzlePiece> puzzlePieces;

    public PlacementAlgorithm(Board board, List<PuzzlePiece> puzzlePieces) {
        this.board = board;
        this.puzzlePieces = puzzlePieces;
    }

    /**
     * The main logic of any inherited placement algorithm should go here.
     */
    public abstract void placePuzzlePieces();

    /**
     * Calculates the evaluation score.
     * @return the percentage of the cells filled with puzzle pieces
     */
    public float evaluate() {
        int filled = 0;
        
        for (PuzzlePiece piece : board) {
            if (piece != null) // Can be null if the board cell is empty
                filled++;
        }
        return ((float) filled) / (board.width * board.height);
    }
}