package si.unilj.fri.vss.aps2.seminar1;

import java.util.ArrayList;
import java.util.List;

/**
 * Game data container for parameters read from input file.
 */
public class IQFitGameData {
    /**
     * the width of the board
     */
    private int boardWidth;

    /**
     * The height of the board
     */
    private int boardHeight;

    /**
     * The number of puzzle pieces
     */
    private int numberOfPuzzles;

    /** 
     * The number of puzzle piece pairs
     * 
     */
    private int numberOfPuzzlePairs;

    /**
     * The list of puzzle piece's data
     */
    final List<PuzzlePieceData> puzzlePieces;

    public IQFitGameData() {
        puzzlePieces = new ArrayList<>(20);
    }

    /**
     * Get the width of the board.
     * @return the width the board
     */
    public int getBoardWidth() {
        return boardWidth;
    }

    /**
     * Get the height of the board.
     * @return the height of the board
     */
    public int getBoardHeight() {
        return boardHeight;
    }

    /**
     * Get the number of puzzle pieces.
     * @return the number of puzzle pieces
     */
    public int getNumberOfPuzzles() {
        return numberOfPuzzles;
    }

    /**
     * Get the number of puzzle pieces' pairs.
     * @return the number of pairs
     */
    public int getNumberOfPuzzlePairs() {
        return numberOfPuzzlePairs;
    }

    /**
     * Set the width of the board.
     * @param w the width parameter
     */
    public void setBoardWidth(int w) {
        boardWidth = w;
    }

    /**
     * Set the height of the board.
     * @param h the height parameter
     */
    public void setBoardHeight(int h) {
        boardHeight = h;
    }

    /**
     * Set the number of puzzle pieces.
     * @param kk the number of puzzle pieces
     */
    public void setNumberOfPuzzles(int kk) {
        numberOfPuzzles = kk;
    }

    /**
     * Set the number of puzzle pieces' pairs.
     * @param k the number of pairs
     */
    public void setNumberOfPuzzlePairs(int k) {
        numberOfPuzzlePairs = k;
    }

    /**
     * Get the list of puzzle pieces' data.
     * @return the list
     */
    public List<PuzzlePieceData> getPuzzlePieces() {
        return puzzlePieces;
    }

    /**
     * Add one puzzle piece datum.
     * @param name the name of the puzzle piece
     * @param colour the colour of the puzzle piece
     * @param width the width of the puzzle piece's bounding box
     * @param height the height of the puzzle piece's bounding box
     * @param shape the shape string of the respective puzzle piece
     */
    public void addPuzzlePiece(char name, char colour, int width, int height, String shape) {
        puzzlePieces.add(new PuzzlePieceData(name, colour, width, height, shape));
    }
}
