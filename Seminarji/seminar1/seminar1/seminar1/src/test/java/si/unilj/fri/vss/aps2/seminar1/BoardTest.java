package si.unilj.fri.vss.aps2.seminar1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import si.unilj.fri.vss.aps2.seminar1.PuzzlePiece.Orientation;

public class BoardTest {
    
    private int w, h;
    private Board board;
    
    private Iterator<Character> printableCharacters;

    @Before
    public void initialize() {
        w = 10;
        h = 5;
        board = new Board1DArrayImpl(w, h);

        printableCharacters = new Iterator<Character>() {
            public static final String PRINTABLE_ASCII_CHARS = 
                "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLM" +
                "NOPQRSTUVWXYZ!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~";
            
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i < PRINTABLE_ASCII_CHARS.length();
            }
    
            @Override
            public Character next() {
                return PRINTABLE_ASCII_CHARS.charAt(i++);
            }
        };
    }

    @Test
    public void testPrintEmptyBoard() {
        board.printBoard();
    }

    @Test
    public void testToStringEmptyBoard() {
        String boardString = board.toString();
        String[] lines = boardString.split(System.lineSeparator());
        Assert.assertEquals(h, lines.length);
        for (String line : lines) {
            String[] cols = line.split(" ");
            Assert.assertEquals(w, cols.length);
            Arrays.stream(cols).forEach(col -> Assert.assertEquals(Board.EMPTY_BOARD_CELL, col));
        }
    }

    @Test
    public void testPlacePuzzle1() {
        char c = printableCharacters.next();

        Deque<PuzzlePiece> pieces = new LinkedList<>();
        
        pieces.addLast(new PuzzlePiece1DArrayImpl('.', c, 1, 1, "1"));
        
        // Placing off-borders should fail
        Assert.assertFalse(board.tryPlacePuzzlePiece(pieces.getLast(), board.new Offset(-1)));
        Assert.assertFalse(board.tryPlacePuzzlePiece(pieces.getLast(), board.new Offset(w * h)));

        // Placing in an empty spot should succeed
        Assert.assertTrue(board.tryPlacePuzzlePiece(pieces.getLast(), board.new Offset(0)));
        
        // Placing piece of the same colours in an empty spot should fail
        Assert.assertFalse(board.tryPlacePuzzlePiece(pieces.getLast(), board.new Offset(1)));

        // Placing a piece with non-existing colour in an empty spot should succeed
        for (int i = 1; i < w * h; i++) {
            c = printableCharacters.next();
            pieces.addLast(new PuzzlePiece1DArrayImpl('.', c, 1, 1, "1"));
            Assert.assertTrue(board.tryPlacePuzzlePiece(pieces.getLast(), board.new Offset(i)));
        }

        // Board is full. Placement should fail.
        c = printableCharacters.next();
        for (int i = 0; i < w * h; i++) {
            Assert.assertFalse(board.isEmptyAt(i));
            int y = i / w;
            int x = i - (i % w);
            Assert.assertFalse(board.isEmptyAt(x, y));
            pieces.addLast(new PuzzlePiece1DArrayImpl('.', c, 1, 1, "1"));
            Assert.assertFalse(board.tryPlacePuzzlePiece(pieces.getLast(), board.new Offset(i)));
        }

        Deque<PuzzlePiece> piecesReversed = new LinkedList<>();
        // Check board state
        for (int i = 0; i < w * h; i++) {
            Assert.assertEquals(pieces.getFirst(), board.getAt(i));
            int y = i / w;
            int x = i - w * (i / w);
            Assert.assertEquals(pieces.getFirst(), board.getAt(x, y));
            piecesReversed.addFirst(pieces.removeFirst()); // reverses the order
        }

        // Addressing off-board returns null
        Assert.assertNull(board.getAt(-1));
        Assert.assertNull(board.getAt(w * h));

        // What would be printed
        String boardString = board.toString();
        String[] lines = boardString.split(System.lineSeparator());
        Assert.assertEquals(h, lines.length);
        for (String line : lines) {
            String[] cols = line.split(" ");
            Assert.assertEquals(w, cols.length);
            Arrays.stream(cols).forEach(col -> {
                Assert.assertEquals(piecesReversed.getLast().getShapeName(), col);
                pieces.addLast(piecesReversed.removeLast());
            });
        }

        // Remove piece by piece
        for (int i = w * h - 1; i >= 0; i--) {
            Assert.assertFalse(board.isEmptyAt(i));
            Assert.assertEquals(pieces.removeLast(), board.getAt(i));
            Assert.assertTrue(board.removeLastPuzzlePiece());
            Assert.assertTrue(board.isEmptyAt(i));
            Assert.assertNull(board.getAt(i));
        }

        // Cannot remove anymore - it's now empty
        Assert.assertFalse(board.removeLastPuzzlePiece());
    }

    @Test
    public void testPlacePuzzle2() {
        List<PuzzlePiece> pieces = new ArrayList<>();
        char c;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x += 5) {
                c = printableCharacters.next();

                PuzzlePiece piece = new PuzzlePiece1DArrayImpl('I', c, 5, 1, "11111");
                pieces.add(piece);

                Assert.assertTrue(board.tryPlacePuzzlePiece(piece, board.new Offset(x, y)));

                // Check the last piece was inserted properly
                for (int xx = x; xx < x + 5; xx++)
                    Assert.assertEquals(piece, board.getAt(xx, y));

                for (int i = x + 5 + y * w; i < w * h; i++) {
                    Assert.assertTrue(board.isEmptyAt(i));
                }
            }    
        }

        // Remove all pieces
        board.printBoard();
        for (int y = h - 1; y >= 0; y--) {
            for (int x = 5; x >= 0; x -= 5) {
                Assert.assertTrue(board.removeLastPuzzlePiece());
                board.printBoard();

                for (int xx = x; xx < w; xx++) {
                    Assert.assertTrue(board.isEmptyAt(xx, y));
                }

                for (int xx = 0; xx < x; xx++) {
                    Assert.assertEquals(pieces.get(y * 2), board.getAt(xx, y));
                }

                for (int yy = 0; yy < y; yy++) {
                    for (int xx = 0; xx < w; xx++) {
                        Assert.assertEquals(pieces.get(yy * 2 + (xx / 5)), board.getAt(xx, yy));
                    }
                }
            }
        }
        Assert.assertFalse(board.removeLastPuzzlePiece());
    }

    @Test
    public void testPlacePuzzle3() {
        List<PuzzlePiece> pieces = new ArrayList<>();
        char c;

        for (int x = 0; x < w; x++) {
            c = printableCharacters.next();
            PuzzlePiece piece = new PuzzlePiece1DArrayImpl('I', c, 1, 5, "11111");
            pieces.add(piece);

            Assert.assertTrue(board.tryPlacePuzzlePiece(piece, board.new Offset(x, 0)));

            // Check the piece was placed correctly
            for (int yy = 0; yy < h; yy++)
                Assert.assertEquals(pieces.get(x), board.getAt(x, yy));
            
            for (int xx = x + 1; xx < w; xx++) {
                for (int yy = 0; yy < h; yy++) {
                    Assert.assertTrue(board.isEmptyAt(xx, yy));
                }
            }
        }

        // Remove all pieces
        for (int x = w - 1; x >= 0; x--) {
            Assert.assertTrue(board.removeLastPuzzlePiece());

            // Check the last piece was removed correctly
            for (int yy = 0; yy < h; yy++) {
                Assert.assertTrue(board.isEmptyAt(x, yy));
            }

            for (int xx = 0; xx < x; xx++) {
                for (int yy = 0; yy < h; yy++) {
                    Assert.assertEquals(pieces.get(xx), board.getAt(xx, yy));
                }
            }
        }
        Assert.assertFalse(board.removeLastPuzzlePiece());
    }

    @Test
    public void testPlacePuzzle4() {
        // Test puzzle with holes
        
        List<PuzzlePiece> pieces = new ArrayList<>();
        char c;
        PuzzlePiece piece;
        
        // Add pieces
        board.printBoard();
        for (int x = 0; x < w; x += 2) {
            c = printableCharacters.next();
            piece = new PuzzlePiece1DArrayImpl('Z', c, 2, 5, "1001100110");
            pieces.add(piece);

            Assert.assertTrue(board.tryPlacePuzzlePiece(piece, board.new Offset(x, 0)));
            board.printBoard();

            // Check the last piece was placed correctly
            for (int xx = x; xx < x + 2; xx++) {
                for (int yy = 0; yy < h; yy++) {
                    if ((xx + yy) % 2 == 0)
                        Assert.assertEquals(piece, board.getAt(xx, yy));
                    else
                        Assert.assertTrue(board.isEmptyAt(xx, yy));
                }
            }

            for (int xx = x + 2; xx < w; xx++) {
                for (int yy = 0; yy < h; yy++) {
                    Assert.assertTrue(board.isEmptyAt(xx, yy));
                }
            }
        }    

        // Add mirrored pieces
        PuzzlePiece pieceR = pieces.get(0).rotated(Orientation.ANGLE180);
        
        Assert.assertEquals(0, pieceR.getAt(0));
        Assert.assertEquals(1, pieceR.getAt(1));
        
        for (int x = 0; x < w; x += 2) {
            // Change colour to pieceR
            c = printableCharacters.next();
            piece = new PuzzlePiece1DArrayImpl('Z', c, 2, 5, "1001100110");
            pieceR = piece.rotated(Orientation.ANGLE180);

            Assert.assertTrue(board.tryPlacePuzzlePiece(pieceR, board.new Offset(x, 0)));
            
            piece = pieces.get(x / 2);
            // Check the last piece was placed correctly
            board.printBoard();
            for (int xx = x; xx < x + 2; xx++) {
                for (int yy = 0; yy < h; yy++) {
                    if ((xx + yy) % 2 == 0)
                        Assert.assertEquals(piece, board.getAt(xx, yy));
                    else
                        Assert.assertEquals(pieceR, board.getAt(xx, yy));
                }
            }
        } 
        
        // Remove pieces
        for (int x = w - 2; x >= 0; x -= 2) {
            Assert.assertTrue(board.removeLastPuzzlePiece());
            piece = pieces.get(x / 2);
            for (int xx = x; xx < x + 2; xx++) {
                for (int yy = 0; yy < h; yy++) {
                    if ((xx + yy) % 2 == 0)
                        Assert.assertEquals(piece, board.getAt(xx, yy));
                    else
                        Assert.assertTrue(board.isEmptyAt(xx, yy));
                }
            }
        }

        for (int x = w - 2; x >= 0; x -= 2) {
            Assert.assertTrue(board.removeLastPuzzlePiece());
            for (int xx = x; xx < x + 2; xx++) {
                for (int yy = 0; yy < h; yy++) {
                    Assert.assertTrue(board.isEmptyAt(xx, yy));
                }
            }
        }
    }
}