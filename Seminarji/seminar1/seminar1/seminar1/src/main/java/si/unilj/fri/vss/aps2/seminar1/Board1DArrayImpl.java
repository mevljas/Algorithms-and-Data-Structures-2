package si.unilj.fri.vss.aps2.seminar1;

/**
 * Board implementation using 1D array as the representation. 
 */
public class Board1DArrayImpl extends Board {

    private final PuzzlePiece[] board;

    public Board1DArrayImpl(int width, int height) {
        super(width, height);
        board = new PuzzlePiece[width * height];
    }

    @Override
    public PuzzlePiece getAt(final int i) {
        if (i < 0 || i >= width * height)
            return null;
        return board[i];
    }

    @Override
    public PuzzlePiece getAt(final int x, final int y) {
        return getAt(x + y * width);
    }

    @Override
    protected void setAt(final int i, final PuzzlePiece piece) {
        if (i < 0 || i >= width * height)
            return;
        board[i] = piece;
    }

    @Override
    protected void setAt(final int x, final int y, final PuzzlePiece piece) {
        setAt(x + y * width, piece);
    }

    @Override
    protected void clearAt(final int i) {
        setAt(i, null);
    }

    @Override
    protected void clearAt(final int x, final int y) {
        clearAt(x + y * width);
    }

    @Override
    public boolean isEmptyAt(final int i) {
        if (i < 0 || i >= width * height)
            return false;
        return board[i] == null;
    }

    @Override
    public boolean isEmptyAt(final int x, final int y) {
        return isEmptyAt(x + y * width);
    }
}