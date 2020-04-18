package si.unilj.fri.vss.aps2.seminar1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Abstract class representing game board. 
 */
public abstract class Board implements Iterable<PuzzlePiece> {
    public static final String EMPTY_BOARD_CELL = "00";

    /**
     * Class for expressing offset either in 2D coordinates or as an
     * 1D index.
     */
    public final class Offset {
        private final int offset;

        public Offset(int i) {
            offset = i;
        }

        public Offset(int x, int y) {
            offset = y * width + x;
        }

        /**
         * 
         * @return 1D offset
         */
        public int getOffset1D() {
            return offset;
        }

        /**
         * 
         * @return Y coordinate offset
         */
        public int getOffsetY() {
            return offset / width;
        }

        /**
         * 
         * @return X coordinate offset
         */
        public int getOffsetX() {
            return offset % width;
        }
    } 

    /**
     * Width of this board
     */
    protected final int width;

    /**
     * Height of this board
     */
    protected final int height;

    /**
     * A deque used as stack to remember the placement order of puzzle pieces. Useful
     * for reverting to the previous state
     */
    protected final Deque<PuzzlePiecePlacement> placedPuzzlePieces;

    /**
     * Remember which colours of puzzle pieces have been used already.
     */
    protected final Set<Character> usedColours;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        placedPuzzlePieces = new ArrayDeque<>(32);
        usedColours = new HashSet<>();
    }

    /**
     * Width of this board
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Height of this board
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Determines if at present board state there is any puzzle piece
     * with the given colour.
     * @param colour to query for
     * @return true if the colour has been used and false otherwise
     */
    public boolean hasColour(final char colour) {
        return usedColours.contains(colour);
    }

    /**
     * Internal method used to check whether the given parameters are 
     * indexing outside of the board
     * @param i 1D offset ranging from 0 to width * height - 1
     * @param x coordinate
     * @param w width of the puzzle piece
     * @param h height of the puzzle piece
     * @return true if the given parameters are indexing outside
     */
    private boolean isOffBorder(final int i, final int x, final int w, final int h) {
        // Placing off the borders?
        return  (i < 0) || 
                ((i + w * h - 1) >= (width * height)) ||
                (x + w - 1 >= width);
    }

    /**
     * Internal helper method to determine whether the given puzzle piece
     * can be placed at the position (x, y) on the board or not. The
     * piece can be placed if all the board cells are empty and the puzzle
     * piece's colour has not been used.
     * @param w the width of the puzzle piece
     * @param h the height of the puzzle piece
     * @param x the left most coordinate of the puzzle piece's bounding box
     * @param y the top most coordinate of the puzzle piece's bounding box
     * @param piece the puzzle piece
     * @return true if the puzzle piece can be placed at (x, y) and false otherwise
     */
    private boolean canPlace(final int w, final int h, final int x, final int y, final PuzzlePiece piece) {
        // Check if the colour of the piece exists already
        if (usedColours.contains(piece.getColour()))
            return false;

        // Check if all the spots on the board are available
        boolean available = true;
        for (int yy = 0; available && yy < h; yy++) {
            for (int xx = 0; available && xx < w; xx++) {
                assert xx + x >= 0 && xx + x < width;
                assert yy + y >= 0 && yy + y < height;
                if (piece.getAt(xx, yy) == PuzzlePiece.FILLED_SQUARE)
                    available = available && isEmptyAt(xx + x, yy + y);
            }
        }
        return available;
    }

    /** 
     * Helper method to perform the actual placement of the puzzle piece on
     * the board.
     * @param w the width of the puzzle piece
     * @param h the height of the puzzle piece
     * @param x the x coordinate of the left-most point of the puzzle piece's 
     *  bounding box
     * @param y the y coordinate of the top-most point of the puzzle piece's 
     *  bounding box
     * @param piece the puzzle piece
     */
    private void place(final int w, final int h, final int x, final int y, final PuzzlePiece piece) {
        for (int yy = 0; yy < h; yy++) {
            for (int xx = 0; xx < w; xx++) {
                assert xx + x >= 0 && xx + x < width;
                assert yy + y >= 0 && yy + y < height;
                if (piece.getAt(xx, yy) == PuzzlePiece.FILLED_SQUARE)
                    setAt(xx + x, yy + y, piece);
            }
        }
    }

    /**
     * Helper method to perform removal of the puzzle piece from the board.
     * @param w the width of the puzzle piece's bonding box
     * @param h the height of the puzzle piece's bounding box
     * @param x the left-most point of the puzzle piece's bounding box
     * @param y the top-most point of the puzzle piece's bounding box
     * @param piece the puzzle piece
     */
    private void remove(final int w, final int h, final int x, final int y, final PuzzlePiece piece) {
        for (int yy = 0; yy < h; yy++) {
            for (int xx = 0; xx < w; xx++) {
                assert xx + x >= 0 && xx + x < width;
                assert yy + y >= 0 && yy + y < height;
                if (piece.getAt(xx, yy) == PuzzlePiece.FILLED_SQUARE)
                    clearAt(xx + x, yy + y);
            }
        }
    }

    /**
     * Tries to place the given puzzle piece at the given offset on this board. The 
     * placement fails if the puzzle piece would fall off the board's borders or if
     * its placement would occlude any other puzzle piece already placed on the board.
     * The placement also fails if any puzzle piece with the same colour as the given 
     * puzzle piece is already placed on the board.  
     * @param piece the puzzle piece to be placed on this board
     * @param offset the offset at which the puzzle piece should be placed
     * @return true if the placement succeeds and false otherwise
     */
    public boolean tryPlacePuzzlePiece(final PuzzlePiece piece, final Offset offset) {
        if (piece == null || offset == null)
            return false;

        final int w = piece.getWidth();
        final int h = piece.getHeight();

        final int x = offset.getOffsetX();
        final int y = offset.getOffsetY();

        final int i = offset.getOffset1D();

        if (isOffBorder(i, x, w, h) || ! canPlace(w, h, x, y, piece))
            return false;

        // We can place
        place(w, h, x, y, piece);

        // Consume colour
        usedColours.add(piece.getColour());
        
        // Push the piece on the stack to remember the placement order
        // This call creates a new object, which can be slow if called often
        placedPuzzlePieces.push(new PuzzlePiecePlacement(piece, offset));
        return true;
    }

    /**
     * Tries to remove the last placed puzzle piece from the board. This method
     * can be called several times and may drain the board of any puzzle pieces.
     * @return true if removal succeeds and false otherwise
     */
    public boolean removeLastPuzzlePiece() {
        if (placedPuzzlePieces.isEmpty())
            return false;
        
        final PuzzlePiecePlacement placement = placedPuzzlePieces.pop();

        final int x = placement.getOffset().getOffsetX();
        final int y = placement.getOffset().getOffsetY();

        final int w = placement.getPuzzlePiece().getWidth();
        final int h = placement.getPuzzlePiece().getHeight();

        remove(w, h, x, y, placement.getPuzzlePiece());

        // Mark colour available
        usedColours.remove(placement.getPuzzlePiece().getColour());

        return true;
    }

    /**
     * Lookup at the 1D index i what is placed there, if anything.
     * @param i the 1D index in the range from 0 to width * height - 1
     * @return the puzzle piece under the given index or null if empty
     */
    public abstract PuzzlePiece getAt(int i);

    /**
     * Same as 1D lookup except that the query parameters are 2D coordinates. 
     * @param x the x coordinate of the board's cell
     * @param y the y coordinate of the board's cell
     * @return the puzzle piece at position (x, y) or null if empty
     */
    public abstract PuzzlePiece getAt(int x, int y);

    /**
     * Set the content of the border's cell at position i (1D index) to the
     * puzzle piece.
     * @param i the index to place at 
     * @param piece the puzzle piece to be set at the given position
     */
    protected abstract void setAt(int i, PuzzlePiece piece);

    /**
     * Set the content of the given puzzle piece to the board's cell at (x, y).
     * @param x the x coordinate of the set position
     * @param y the y coordinate of the set position
     * @param piece the puzzle piece to be set at the given position
     */
    protected abstract void setAt(int x, int y, PuzzlePiece piece);

    /**
     * The position index of the board's cell which should be cleared of any
     * content.
     * @param i 1D index of the positions to be cleared
     */
    protected abstract void clearAt(int i);

    /**
     * The coordinates of the board's cell that should be cleared of any content.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    protected abstract void clearAt(int x, int y);

    /**
     * Query whether the board cell at position i is empty of not.
     * @param i the 1D positional index
     * @return true if the cell at i is empty and false otherwise
     */
    public abstract boolean isEmptyAt(int i);

    /**
     * Query whether the board cell at (x, y) i is empty or not.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return true if the cell at (x, y) is empty and false otherwise
     */
    public abstract boolean isEmptyAt(int x, int y);

    /** 
     * Prints the content of this board. Useful for submission.
     */
    public void printBoard() {
        System.out.println(toString());
    }

    /**
     * String representation of this board.
     * @return a multiline string representation of this board
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        PuzzlePiece piece = null;
        for (int y = 0; y < height; y++) {
            piece = getAt(0, y);
            sb.append((piece == null) ? EMPTY_BOARD_CELL : piece.getShapeName());
            for (int x = 1; x < width; x++) {
                sb.append(" ");
                piece = getAt(x, y);
                sb.append((piece == null) ? EMPTY_BOARD_CELL : piece.getShapeName());
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * Clears the content of this board.
     */
    public void clear() {
        usedColours.clear();
        placedPuzzlePieces.clear();
        for (int i = 0; i < width * height; i++)
            clearAt(i);
    }

    /**
     * The iterator over this board's elements.
     * Note that any individual PuzzlePiece returned by the iterator can be null.
     * Puzzle pieces are traversed in the index-major order.
     * @return iterator over this Board 
     */
    @Override
    public Iterator<PuzzlePiece> iterator() {
        return new Iterator<PuzzlePiece>() {
            private int i = 0;

			@Override
			public boolean hasNext() {
				return i < width * height;
			}

			@Override
			public PuzzlePiece next() {
				return getAt(i++);
			}
        };
    }
}