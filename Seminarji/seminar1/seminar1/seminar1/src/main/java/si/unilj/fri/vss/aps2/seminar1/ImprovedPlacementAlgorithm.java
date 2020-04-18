package si.unilj.fri.vss.aps2.seminar1;

import java.util.List;

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
        lastX = 0;
        lastY = 0;
        maxRowHeight = 0;
        for (PuzzlePiece piece : puzzlePieces) {
            // We can try to fit any colour, even if already placed on the board.
            // The board will refuse placing the same colour.
            if (tryPlacingPuzzle(piece)){
                break;
            }
            else {
                piece = piece.rotated(PuzzlePiece.Orientation.ANGLE90);
                if (tryPlacingPuzzle(piece)){
                    break;
                }
                else {
                    piece = piece.rotated(PuzzlePiece.Orientation.ANGLE90);
                    if (tryPlacingPuzzle(piece)){
                        break;
                    }
                    else {
                        piece = piece.rotated(PuzzlePiece.Orientation.ANGLE90);
                        if (tryPlacingPuzzle(piece)){
                            break;
                        }

                    }
                }
            }
        }
    }

    private boolean tryPlacingPuzzle( PuzzlePiece piece){
        if (board.tryPlacePuzzlePiece(piece, board.new Offset(lastX, lastY))) {
            if (placePuzzle(piece)){
                return true;
            }
        }
        return false;
    }


    private boolean placePuzzle(PuzzlePiece piece){
        lastX += piece.width;
        if (lastX >= board.width) {
            lastX = 0;
            lastY += maxRowHeight;
            maxRowHeight = 0;
            if (lastY >= board.height)
                return true;
        }
        else {
            maxRowHeight = Math.max(maxRowHeight, piece.height);
        }
        return false;
    }
}