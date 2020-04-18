package si.unilj.fri.vss.aps2.seminar1;

import java.io.StringReader;
import java.util.Iterator;

import org.junit.Test;
import org.junit.Assert;

public class IQFitInputReaderTest {

     /*
    "c Y 2 3 111011" +
    "l Y 2 3 101011" +
    "b G 2 3 101111" +
    "t G 2 3 011101" +
    "d P 2 3 011111" +
    "j P 2 3 010111" +
    "c B 2 3 111011" +
    "t B 2 3 011101" +
    "P y 2 4 11111010" +
    "J y 2 4 01010111" +
    "7 o 2 4 11011101" +
    "1 o 2 4 01110101" +
    "L r 2 4 11010101" +
    "C r 2 4 11101011" +
    "9 p 2 4 11110101" +
    "I p 2 4 10111010" +
    "F b 2 4 11101110" +
    "L b 2 4 11010101" +
    "D c 2 4 10111110" +
    "1 c 2 4 01110101");
    */
    @Test
    public void testReadDimensions() {
        // Assume Java < 12 => no raw string literals
        String input = String.format("10 5 10%n" +
            "c Y 2 3 111011%n" +
            "l Y 2 3 101011%n" +
            "b G 2 3 101111%n" +
            "t G 2 3 011101%n" +
            "d P 2 3 011111%n" +
            "j P 2 3 010111%n" +
            "c B 2 3 111011%n" +
            "t B 2 3 011101%n" +
            "P y 2 4 11111010%n" +
            "J y 2 4 01010111%n" +
            "7 o 2 4 11011101%n" +
            "1 o 2 4 01110101%n" +
            "L r 2 4 11010101%n" +
            "C r 2 4 11101011%n" +
            "9 p 2 4 11110101%n" +
            "I p 2 4 10111010%n" +
            "F b 2 4 11101110%n" +
            "L b 2 4 11010101%n" +
            "D c 2 4 10111110%n" +
            "1 c 2 4 01110101%n");

        StringReader stringReader = new StringReader(input);
        IQFitInputReader reader = new IQFitInputReader(stringReader);
        
        boolean success = reader.parseInput();

        Assert.assertTrue(success);

        IQFitGameData gameData = reader.getGameData();
        
        // Board dimensions and number of puzzle pieces
        Assert.assertEquals(10, gameData.getBoardWidth());
        Assert.assertEquals( 5, gameData.getBoardHeight());
        Assert.assertEquals(10, gameData.getNumberOfPuzzlePairs());
        Assert.assertEquals(20, gameData.getNumberOfPuzzles());
        
        // Puzzle pieces
        Assert.assertEquals(20, gameData.puzzlePieces.size());
        Iterator<PuzzlePieceData> pieces = gameData.puzzlePieces.iterator();
        PuzzlePieceData piece = null;

        // Piece 1
        // c Y 2 3 111011
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('c', piece.getName());
        Assert.assertEquals('Y', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(3, piece.getHeight());
        Assert.assertEquals("cY", piece.getShapeName());
        Assert.assertEquals("111011", piece.getShape());

        // Piece 2
        // l Y 2 3 101011
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('l', piece.getName());
        Assert.assertEquals('Y', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(3, piece.getHeight());
        Assert.assertEquals("lY", piece.getShapeName());
        Assert.assertEquals("101011", piece.getShape());

        // Piece 3
        // b G 2 3 101111
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('b', piece.getName());
        Assert.assertEquals('G', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(3, piece.getHeight());
        Assert.assertEquals("bG", piece.getShapeName());
        Assert.assertEquals("101111", piece.getShape());

        // Piece 4
        // t G 2 3 011101
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('t', piece.getName());
        Assert.assertEquals('G', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(3, piece.getHeight());
        Assert.assertEquals("tG", piece.getShapeName());
        Assert.assertEquals("011101", piece.getShape());

        // Piece 5
        // d P 2 3 011111
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('d', piece.getName());
        Assert.assertEquals('P', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(3, piece.getHeight());
        Assert.assertEquals("dP", piece.getShapeName());
        Assert.assertEquals("011111", piece.getShape());

        // Piece 6
        // j P 2 3 010111
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('j', piece.getName());
        Assert.assertEquals('P', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(3, piece.getHeight());
        Assert.assertEquals("jP", piece.getShapeName());
        Assert.assertEquals("010111", piece.getShape());

         // Piece 7
        // c B 2 3 111011
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('c', piece.getName());
        Assert.assertEquals('B', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(3, piece.getHeight());
        Assert.assertEquals("cB", piece.getShapeName());
        Assert.assertEquals("111011", piece.getShape());

        // Piece 8
        // t B 2 3 011101
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('t', piece.getName());
        Assert.assertEquals('B', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(3, piece.getHeight());
        Assert.assertEquals("tB", piece.getShapeName());
        Assert.assertEquals("011101", piece.getShape());

        // Piece 9
        // P y 2 4 11111010
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('P', piece.getName());
        Assert.assertEquals('y', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("Py", piece.getShapeName());
        Assert.assertEquals("11111010", piece.getShape());

        // Piece 10
        // J y 2 4 01010111
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('J', piece.getName());
        Assert.assertEquals('y', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("Jy", piece.getShapeName());
        Assert.assertEquals("01010111", piece.getShape());

        // Piece 11
        // 7 o 2 4 11011101
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('7', piece.getName());
        Assert.assertEquals('o', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("7o", piece.getShapeName());
        Assert.assertEquals("11011101", piece.getShape());

        // Piece 12
        // 1 o 2 4 01110101
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('1', piece.getName());
        Assert.assertEquals('o', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("1o", piece.getShapeName());
        Assert.assertEquals("01110101", piece.getShape());
 
        // Piece 13
        // L r 2 4 11010101
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('L', piece.getName());
        Assert.assertEquals('r', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("Lr", piece.getShapeName());
        Assert.assertEquals("11010101", piece.getShape());
  
        // Piece 14
        // C r 2 4 11101011
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('C', piece.getName());
        Assert.assertEquals('r', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("Cr", piece.getShapeName());
        Assert.assertEquals("11101011", piece.getShape());
   
        // Piece 15
        // 9 p 2 4 11110101
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('9', piece.getName());
        Assert.assertEquals('p', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("9p", piece.getShapeName());
        Assert.assertEquals("11110101", piece.getShape());
    
        // Piece 16
        // I p 2 4 10111010
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('I', piece.getName());
        Assert.assertEquals('p', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("Ip", piece.getShapeName());
        Assert.assertEquals("10111010", piece.getShape());
    
        // Piece 17
        // F b 2 4 11101110
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('F', piece.getName());
        Assert.assertEquals('b', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("Fb", piece.getShapeName());
        Assert.assertEquals("11101110", piece.getShape());
     
        // Piece 18
        // L b 2 4 11010101
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('L', piece.getName());
        Assert.assertEquals('b', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("Lb", piece.getShapeName());
        Assert.assertEquals("11010101", piece.getShape());
      
        // Piece 19
        // D c 2 4 10111110
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('D', piece.getName());
        Assert.assertEquals('c', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("Dc", piece.getShapeName());
        Assert.assertEquals("10111110", piece.getShape());
       
        // Piece 20
        // 1 c 2 4 01110101
        Assert.assertTrue(pieces.hasNext());
        piece = pieces.next();
        Assert.assertNotNull(piece);
        Assert.assertEquals('1', piece.getName());
        Assert.assertEquals('c', piece.getColour());
        Assert.assertEquals(2, piece.getWidth());
        Assert.assertEquals(4, piece.getHeight());
        Assert.assertEquals("1c", piece.getShapeName());
        Assert.assertEquals("01110101", piece.getShape());

        Assert.assertNotNull(pieces.hasNext());
    }
}