package si.unilj.fri.vss.aps2.seminar1;

import java.util.List;

/**
 * An example implementation of the placement algorithm using a very
 * simple greedy algorithm.
 */
public class DummyPlacementAlgorithm extends PlacementAlgorithm {

    public DummyPlacementAlgorithm(Board board, List<PuzzlePiece> puzzlePieces) {
        super(board, puzzlePieces);
    }

    @Override
    public void placePuzzlePieces() {
        board.clear();

        // Fill in a greedy manner using only bounding boxes alignment.
        int lastX = 0, lastY = 0, maxRowHeight = 0;
        for (PuzzlePiece piece : puzzlePieces) {
            // We can try to fit any colour, even if already placed on the board.
            // The board will refuse placing the same colour.
            if (board.tryPlacePuzzlePiece(piece, board.new Offset(lastX, lastY))) {
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
}