package si.unilj.fri.vss.aps2.seminar1;

import si.unilj.fri.vss.aps2.seminar1.Board.Offset;

/**
 * Container for puzzle piece and offset.
 * 
 * Used to remember the placement order on the board.  
 */
public final class PuzzlePiecePlacement {

    private final PuzzlePiece piece;
    private final Offset offset;

    public PuzzlePiecePlacement(PuzzlePiece piece, Offset offset) {
        this.piece = piece;
        this.offset = offset;
    }

    public PuzzlePiece getPuzzlePiece() {
        return piece;
    }

    public Offset getOffset() {
        return offset;
    }
}