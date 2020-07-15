package si.unilj.fri.vss.aps2.seminar1;


import java.util.List;

import static si.unilj.fri.vss.aps2.seminar1.PuzzlePiece.FILLED_SQUARE;

public class BacktrackPlacementAlgorithm extends PlacementAlgorithm {

    public BacktrackPlacementAlgorithm(Board board, List<PuzzlePiece> puzzlePieces) {
        super(board, puzzlePieces);
    }

    @Override
    public void placePuzzlePieces() {
        board.clear();
        puzzlePieces.sort((o1, o2) -> {
            int difference = size(o2) - size(o1);
            if (difference == 0) {
                difference = countWhiteSpaces(o1) - countWhiteSpaces(o2);
            }
            return difference;

        });
        placePuzzlePiecesRek(0, 0, 0);
    }

    private boolean placePuzzlePiecesRek(int x, int y, int n) {

        if (n == puzzlePieces.size() / 2) {
            return true;
        }

        boolean inserted;
        boolean emptyPlace = true;
        while (y < board.height) {

            while (x < board.width) {

//                check if current place is empty
                emptyPlace = board.isEmptyAt(x, y);

                for (PuzzlePiece piece : puzzlePieces) {

                    if (board.usedColours.contains(piece.colour)) {
                        continue;
                    }

                    int i = 0;

//                  ignore some rotations
                    if (piece.name == 'X' || piece.name == 'I') {
                        i = 2;
                    }
                    do {
                        piece = piece.rotated(PuzzlePiece.Orientation.values()[i++]);
                        if (!emptyPlace && piece.getAt(0, 0) == FILLED_SQUARE) {
                            continue;
                        }
                        inserted = board.tryPlacePuzzlePiece(piece, board.new Offset(x, y));
                        if (inserted) {
                            if (!isColliding(x, y, piece)) {
                                if (placePuzzlePiecesRek(x + 1, y, n + 1)) {
                                    return true;
                                } else {
                                    board.printBoard();
                                    board.removeLastPuzzlePiece();
                                }
                            } else {
                                board.removeLastPuzzlePiece();
                            }


                        }
                    } while (i < 4);
                }
                x++;
            }
            if (!rowFull(y)) {
                return false;
            }
            y++;
            x = 0;
        }
        return false;
    }


    private boolean isColliding(int x, int y, PuzzlePiece piece) {
        return !(checkSpaceLeft(x, y, piece) && checkSides(x, y, piece));
    }


    private boolean checkSides(int x, int y, PuzzlePiece piece) {
//        left
        if (x == 0) {
            for (int yy = y; yy < y + piece.getHeight(); yy++) {
                if (board.isEmptyAt(0, yy) && !board.isEmptyAt(0, yy + 1)) {
                    return false;
                }
            }
        }


//        right
        if (x + piece.getWidth() == board.getWidth()) {
            for (int yy = y; yy < y + piece.getHeight() ; yy++) {
                if (board.isEmptyAt(board.getWidth() - 1, yy) && !board.isEmptyAt(board.getWidth() - 1, yy + 1)) {
                    return false;
                }
            }
        }

//        top
        for (int xx = x; xx < x + piece.getWidth(); xx++) {
            if (board.isEmptyAt(xx, y)) {
                return false;
            }
        }

//        bottom
        if (y + piece.getHeight() == board.getHeight()) {
            for (int xx = x; xx < x + piece.getWidth(); xx++) {
                if (board.isEmptyAt(xx, board.getHeight() - 1) && !board.isEmptyAt(xx + 1, board.getHeight() - 1)) {
                    return false;
                }
            }

        }


        return true;

    }


    private boolean checkSpaceLeft(int x, int y, PuzzlePiece piece) {
        if (x > 0) {
            for (int yy = y; yy < y + piece.getHeight(); yy++) {
                if (board.isEmptyAt(x - 1, yy)) {
                    return false;
                }
            }
        }
        return true;
    }


    boolean rowFull(int y) {
        for (int x = 0; x < board.getWidth(); x++) {
            if (board.isEmptyAt(x, y)) {
                return false;
            }
        }
        return true;


    }


    private int countWhiteSpaces(PuzzlePiece piece) {
        int ct = 0;
        for (int i = 0; i < piece.height; i++) {
            for (int j = 0; j < piece.width; j++) {
                if (piece.getAt(j, i) == 0) {
                    ct++;
                }
            }
        }
        return ct;
    }

    private int size(PuzzlePiece piece) {
        int ct = 0;
        for (int i = 0; i < piece.height; i++) {
            for (int j = 0; j < piece.width; j++) {
                if (piece.getAt(j, i) == 1) {
                    ct++;
                }
            }
        }
        return ct;
    }

}