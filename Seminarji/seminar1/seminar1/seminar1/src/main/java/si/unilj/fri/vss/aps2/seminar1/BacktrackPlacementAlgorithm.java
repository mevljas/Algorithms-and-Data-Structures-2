package si.unilj.fri.vss.aps2.seminar1;

import java.util.HashSet;
import java.util.List;

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
        while (y < board.height) {

            while (x < board.width) {

                for (PuzzlePiece piece : puzzlePieces) {

                    if (board.usedColours.contains(piece.colour)) {
                        continue;
                    }

                    int i = 0;
                    do {
                        piece = piece.rotated(PuzzlePiece.Orientation.values()[i++]);
                        inserted = checkSides(x, y, piece) && checkWhiteSpaces(x, y, piece) && tryPlacingPuzzle(piece, x, y);
                        if (inserted) {
                            board.printBoard();
                            if (placePuzzlePiecesRek(x + 1, y, n + 1)) {
                                return true;
                            } else {
                                board.removeLastPuzzlePiece();
                            }
                        }
                    } while (i < 4);
                }
                x++;
            }
            y++;
            x = 0;
        }
        return false;
    }


    private boolean tryPlacingPuzzle(PuzzlePiece piece, int x, int y) {
        return board.tryPlacePuzzlePiece(piece, board.new Offset(x, y));
    }


    private boolean checkSides(int x, int y, PuzzlePiece piece) {
        if (x == 0) {
            for (int i = 0; i < piece.getHeight() - 1; i++) {
                if ((piece.getAt(0, i) == 0) && piece.getAt(0, i + 1) == 1) {
                    return false;
                }
            }
        }

        if (x + piece.getWidth() == board.getHeight()) {
            for (int i = 0; i < piece.getHeight() - 1; i++) {
                if ((piece.getAt(piece.width - 1, i) == 0) && (piece.getAt(piece.width - 1, i + 1) == 1)) {
                    return false;
                }
            }
        }

        if (y == 0) {
            for (int i = 0; i < piece.getHeight() - 1; i++) {
                for (int j = 0; j < piece.getWidth(); j++) {
                    if ((piece.getAt(j, i) == 0) && (piece.getAt(j, i + 1) == 1)) {
                        return false;
                    }
                }
            }
        }

        if (y + piece.getHeight() == board.getHeight()) {
            for (int i = 0; i < piece.getWidth() - 1; i++) {
                if ((piece.getAt(i, y + piece.getHeight()) == 0) && (piece.getAt(i + 1, y + piece.getHeight()) == 1)) {
                    return false;
                }
            }

            int st = 0;
            int leftX = x - 1;
            while (leftX >= 0 && board.getAt(leftX--, y + piece.getHeight() - 1) == null) {
                st++;
            }

            if (st > 0 && st < 3) {
                return false;
            }
        }
        if (y > 0) {

            for (int i = 0; i < piece.getWidth(); i++) {
                if (board.getAt(i, y - 1) == null) {
                    return false;
                }
                if (board.getAt(i, y - 1) == piece) {
                    int y2 = y - 2;
                    do {
                        if (board.getAt(i, y2) == null) {
                            return false;
                        }
                    } while (board.getAt(i, y2--) == piece);
                }
            }
        }
        if (x > 0) {
            for (int i = 0; i < piece.getHeight(); i++) {
                if (board.getAt(x - 1, y) == null) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean checkWhiteSpaces(int x, int y, PuzzlePiece piece) {
        return checkWhiteSpacesLeft(x, y, piece) && checkWhiteSpacesUp(x, y, piece);
    }

    private boolean checkWhiteSpacesLeft(int x, int y, PuzzlePiece piece) {
        if (x > 0) {
            HashSet<PuzzlePiece> puzzlePieces = new HashSet<>();
            HashSet<PuzzlePiecePlacement> puzzlePiecePlacements = new HashSet<>();

            for (int i = y; i < piece.getHeight(); i++) {
                puzzlePieces.add(board.getAt(x - 1, i));
            }

            for (PuzzlePiecePlacement placement : board.placedPuzzlePieces) {
                if (puzzlePieces.contains(placement.getPuzzlePiece())) {
                    puzzlePiecePlacements.add(placement);
                }
            }

            for (PuzzlePiecePlacement placement : puzzlePiecePlacements) {
                PuzzlePiece leftPiece = placement.getPuzzlePiece();
                int j = 0; //counter for the right piece
                int offsetY = placement.getOffset().getOffsetY();
                if (offsetY + leftPiece.getHeight() >= y && offsetY <= y + piece.getHeight()) {
                    for (int i = 0; i < leftPiece.getHeight() - 1; i++) {
                        if (j >= piece.getHeight()) {
                            break;
                        }

                        if (offsetY + i >= y && offsetY + i <= y + piece.getHeight()) {
                            if (leftPiece.getAt(leftPiece.getWidth() - 1, i) == 0 && leftPiece.getAt(leftPiece.getWidth() - 1, i + 1) == 1) {
                                if (piece.getAt(0, j) == 0) {
                                    return false;
                                }
                            }
                        }

                        if (piece.getAt(0, j) == 0) {
                            if (j < piece.getHeight() - 1) {
                                if (piece.getAt(0, j + 1) == 0) {
                                    if (leftPiece.getAt(leftPiece.getWidth(), i) == 0) {
                                        return false;
                                    }
                                }
                            } else if (leftPiece.getAt(leftPiece.getWidth(), i) == 0) {
                                return false;
                            }
                        }
                        j++;
                    }
                }
            }
        }
        return true;
    }


    private boolean checkWhiteSpacesUp(int x, int y, PuzzlePiece piece) {
        if (y > 0) {
            HashSet<PuzzlePiece> puzzlePieces = new HashSet<>();
            HashSet<PuzzlePiecePlacement> puzzlePiecePlacements = new HashSet<>();

            for (int i = x; i < piece.getWidth(); i++) {
                puzzlePieces.add(board.getAt(i, y - 1));
            }

            for (PuzzlePiecePlacement placement : board.placedPuzzlePieces) {
                if (puzzlePieces.contains(placement.getPuzzlePiece())) {
                    puzzlePiecePlacements.add(placement);
                }
            }

            for (PuzzlePiecePlacement placement : puzzlePiecePlacements) {
                PuzzlePiece upperPiece = placement.getPuzzlePiece();
                int offsetX = placement.getOffset().getOffsetX();
                if (offsetX + upperPiece.getWidth() >= x && offsetX <= x + piece.getWidth()) {
                    for (int i = 0; i < upperPiece.getWidth(); i++) {
                        if (offsetX + i >= x && offsetX + i <= x + piece.getWidth()) {
                            if (upperPiece.getAt(i, y - 1) == 0) {
                                return false;
                            }
                        }
                    }
                }
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