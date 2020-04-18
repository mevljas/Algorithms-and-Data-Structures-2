package si.unilj.fri.vss.aps2.seminar1;

import java.util.List;
import java.util.Stack;

/**
 * An example implementation of the placement algorithm using a very
 * simple greedy algorithm.
 */
public class ImprovedPlacementAlgorithm extends PlacementAlgorithm {

    static int lastX = 0, lastY = 0, maxRowHeight = 0;

    public ImprovedPlacementAlgorithm(Board board, List<PuzzlePiece> puzzlePieces) {
        super(board, puzzlePieces);
    }

    @Override
    public void placePuzzlePieces() {
        board.clear();

        // Fill in a greedy manner using only bounding boxes alignment.

        boolean inserted = false;
        for (PuzzlePiece piece : puzzlePieces) {
            // We can try to fit any colour, even if already placed on the board.
            // The board will refuse placing the same colour.
            if (tryPlacingPuzzle(piece)){
                inserted = true;
            }
            else{
                piece = piece.rotated(PuzzlePiece.Orientation.ANGLE90);
                if (tryPlacingPuzzle(piece)){
                    inserted = true;
                }
                else{
                    piece = piece.rotated(PuzzlePiece.Orientation.ANGLE90);
                    if (tryPlacingPuzzle(piece)){
                        inserted = true;
                    }
                    else{
                        piece = piece.rotated(PuzzlePiece.Orientation.ANGLE90);
                        tryPlacingPuzzle(piece);
                    }
                }
            }

            if (inserted){
                inserted = false;
                lastX += piece.width;
                if (lastX >= board.width) {
                    lastX = 0;
                    lastY += maxRowHeight;
                    maxRowHeight = 0;
                    if (lastY >= board.height)
                        break;
                }
                else {
                    maxRowHeight = Math.max(maxRowHeight, piece.height);
                }
            }

        }
    }

    private boolean tryPlacingPuzzle( PuzzlePiece piece){
        return board.tryPlacePuzzlePiece(piece, board.new Offset(lastX, lastY));
    }



}