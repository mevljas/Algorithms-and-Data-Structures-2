package si.unilj.fri.vss.aps2.seminar1;

import org.junit.Test;

import si.unilj.fri.vss.aps2.seminar1.PuzzlePiece.Orientation;

import org.junit.Assert;

public class PuzzlePieceTest {

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
    public void testPuzzlePiece1DArrayImpl1() {
        PuzzlePiece piece1 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011");

        Assert.assertEquals('c', piece1.getName());
        Assert.assertEquals('Y', piece1.getColour());
        Assert.assertEquals(2, piece1.getWidth());
        Assert.assertEquals(3, piece1.getHeight());
        Assert.assertEquals("111011", piece1.getShape());
        Assert.assertEquals("cY", piece1.getShapeName());
        Assert.assertEquals(Orientation.ANGLE0, piece1.orientation);

        Assert.assertArrayEquals(new int[] {1, 1, 1, 0, 1, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(0, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(1, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece1DArrayImpl2() {
        PuzzlePiece piece1 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE180);

        Assert.assertEquals('c', piece1.getName());
        Assert.assertEquals('Y', piece1.getColour());
        Assert.assertEquals(2, piece1.getWidth());
        Assert.assertEquals(3, piece1.getHeight());
        Assert.assertEquals("111011", piece1.getShape());
        Assert.assertEquals("cY", piece1.getShapeName());
        Assert.assertEquals(Orientation.ANGLE180, piece1.orientation);

        Assert.assertArrayEquals(new int[] {1, 1, 1, 0, 1, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(0, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(1, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece1DArrayImpl3() {
        PuzzlePiece piece1 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE180, new int[] {1, 0, 1, 1, 1, 0});

        Assert.assertEquals('c', piece1.getName());
        Assert.assertEquals('Y', piece1.getColour());
        Assert.assertEquals(2, piece1.getWidth());
        Assert.assertEquals(3, piece1.getHeight());
        Assert.assertEquals("111011", piece1.getShape());
        Assert.assertEquals("cY", piece1.getShapeName());
        Assert.assertEquals(Orientation.ANGLE180, piece1.orientation);

        Assert.assertArrayEquals(new int[] {1, 0, 1, 1, 1, 0}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(0, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(1, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(0, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece1DArrayImpl4() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE0);

        Assert.assertArrayEquals(new int[] {1, 1, 1, 0, 1, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(0, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(1, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece1DArrayImpl5() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertArrayEquals(new int[] {1, 0, 1, 1, 1, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(0, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(2, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(1, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(2, 1));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(3, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 2));
    }

    @Test
    public void testPuzzlePiece1DArrayImpl6() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertArrayEquals(new int[] {1, 1, 0, 1, 1, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(0, piece1.getAt(0, 1));
        Assert.assertEquals(1, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(1, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece1DArrayImpl7() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertArrayEquals(new int[] {1, 1, 1, 1, 0, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(2, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(0, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(2, 1));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(3, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 2));
    }

    @Test
    public void testPuzzlePiece1DArrayImpl8() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE90);

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertArrayEquals(new int[] {1, 1, 1, 0, 1, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
    }

    @Test
    public void testPuzzlePiece1DArrayImpl9() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE90);

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertArrayEquals(new int[] {1, 0, 1, 1, 1, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
    }

    @Test
    public void testPuzzlePiece1DArrayImpl10() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE270);

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertArrayEquals(new int[] {1, 1, 0, 1, 1, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
    }

    @Test
    public void testPuzzlePiece1DArrayImpl11() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE270);

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertArrayEquals(new int[] {1, 1, 1, 1, 0, 1}, ((PuzzlePiece1DArrayImpl) piece1).toShapeArray());
    }

    @Test
    public void testPuzzlePiece2DArrayImpl1() {
        PuzzlePiece piece1 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011");

        Assert.assertEquals('c', piece1.getName());
        Assert.assertEquals('Y', piece1.getColour());
        Assert.assertEquals(2, piece1.getWidth());
        Assert.assertEquals(3, piece1.getHeight());
        Assert.assertEquals("111011", piece1.getShape());
        Assert.assertEquals("cY", piece1.getShapeName());
        Assert.assertEquals(Orientation.ANGLE0, piece1.orientation);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(0, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(1, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl2() {
        PuzzlePiece piece1 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE180);

        Assert.assertEquals('c', piece1.getName());
        Assert.assertEquals('Y', piece1.getColour());
        Assert.assertEquals(2, piece1.getWidth());
        Assert.assertEquals(3, piece1.getHeight());
        Assert.assertEquals("111011", piece1.getShape());
        Assert.assertEquals("cY", piece1.getShapeName());
        Assert.assertEquals(Orientation.ANGLE180, piece1.orientation);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(0, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(1, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl3() {
        PuzzlePiece piece1 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE180, 
            new int[][] {{1, 0}, {1, 1}, {1, 0}});

        Assert.assertEquals('c', piece1.getName());
        Assert.assertEquals('Y', piece1.getColour());
        Assert.assertEquals(2, piece1.getWidth());
        Assert.assertEquals(3, piece1.getHeight());
        Assert.assertEquals("111011", piece1.getShape());
        Assert.assertEquals("cY", piece1.getShapeName());
        Assert.assertEquals(Orientation.ANGLE180, piece1.orientation);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(0, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(1, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(0, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl4() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE0);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(0, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(1, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl5() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(0, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(2, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(1, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(2, 1));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(3, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 2));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl6() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(0, piece1.getAt(0, 1));
        Assert.assertEquals(1, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(0, 2));
        Assert.assertEquals(1, piece1.getAt(1, 2));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(2, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 3));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl7() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertEquals(-1, piece1.getAt(-1));
        Assert.assertEquals(-1, piece1.getAt(6));

        Assert.assertEquals(1, piece1.getAt(0, 0));
        Assert.assertEquals(1, piece1.getAt(1, 0));
        Assert.assertEquals(1, piece1.getAt(2, 0));
        Assert.assertEquals(1, piece1.getAt(0, 1));
        Assert.assertEquals(0, piece1.getAt(1, 1));
        Assert.assertEquals(1, piece1.getAt(2, 1));
        
        Assert.assertEquals(-1, piece1.getAt(-1, 0));
        Assert.assertEquals(-1, piece1.getAt(0, -1));
        Assert.assertEquals(-1, piece1.getAt(3, 0));
        Assert.assertEquals(-1, piece1.getAt(0, 2));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl8() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE90);

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl9() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE90);

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE180);
        
        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl10() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE270);

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));
    }

    @Test
    public void testPuzzlePiece2DArrayImpl11() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('c', 'Y', 2, 3, "111011", Orientation.ANGLE270);

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));
    }

    @Test
    public void testPuzzlePiece1DArrayImpl12() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('.', 'Y', 2, 3, "100000");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(1, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(1, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece2DArrayImpl12() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('.', 'Y', 2, 3, "100000");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(1, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(1, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(1, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece1DArrayImpl13() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('.', 'Y', 2, 3, "010000");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(1, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(1, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece2DArrayImpl13() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('.', 'Y', 2, 3, "010000");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(1, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(1, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(1, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece1DArrayImpl14() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('.', 'Y', 2, 3, "001000");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(1, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(1, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece2DArrayImpl14() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('.', 'Y', 2, 3, "001000");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(1, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(1, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(1, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece1DArrayImpl15() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('.', 'Y', 2, 3, "000100");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(1, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(1, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece2DArrayImpl15() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('.', 'Y', 2, 3, "000100");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(1, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(1, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(1, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece1DArrayImpl16() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('.', 'Y', 2, 3, "000010");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(1, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(1, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece2DArrayImpl16() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('.', 'Y', 2, 3, "000010");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(0, piece2.getAt(0));
        Assert.assertEquals(1, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(1, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(0, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece1DArrayImpl17() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('.', 'Y', 2, 3, "000001");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        Assert.assertTrue(piece1.orientation == Orientation.ANGLE90);

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(1, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(1, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece2DArrayImpl17() {
        PuzzlePiece piece0 = new PuzzlePiece2DArrayImpl('.', 'Y', 2, 3, "000001");

        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE90);

        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(1, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(0, piece1.getAt(5));

        Assert.assertTrue(piece1.orientation == Orientation.ANGLE90);

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);

        Assert.assertEquals(1, piece2.getAt(0));
        Assert.assertEquals(0, piece2.getAt(1));
        Assert.assertEquals(0, piece2.getAt(2));
        Assert.assertEquals(0, piece2.getAt(3));
        Assert.assertEquals(0, piece2.getAt(4));
        Assert.assertEquals(0, piece2.getAt(5));

        Assert.assertTrue(piece2.isSameGeometry(piece1.rotated(Orientation.ANGLE180)));
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
        Assert.assertEquals(Orientation.ANGLE90, piece1.rotated(Orientation.ANGLE90).orientation);

        PuzzlePiece piece3 = piece0.rotated(Orientation.ANGLE270);

        Assert.assertEquals(0, piece3.getAt(0));
        Assert.assertEquals(0, piece3.getAt(1));
        Assert.assertEquals(0, piece3.getAt(2));
        Assert.assertEquals(1, piece3.getAt(3));
        Assert.assertEquals(0, piece3.getAt(4));
        Assert.assertEquals(0, piece3.getAt(5));

        Assert.assertTrue(piece3.isSameGeometry(piece2.rotated(Orientation.ANGLE270)));
        Assert.assertEquals(Orientation.ANGLE270, piece3.orientation);
        Assert.assertEquals(Orientation.ANGLE180, piece1.rotated(Orientation.ANGLE180).orientation);
    }

    @Test
    public void testPuzzlePiece1DArrayImpl18() {
        PuzzlePiece piece0 = new PuzzlePiece1DArrayImpl('.', 'Y', 2, 3, "000001");
        Assert.assertEquals(Orientation.ANGLE0, piece0.orientation);
        
        PuzzlePiece piece1 = piece0.rotated(Orientation.ANGLE0);
        Assert.assertEquals(Orientation.ANGLE0, piece1.orientation);
        Assert.assertEquals(0, piece1.getAt(0));
        Assert.assertEquals(0, piece1.getAt(1));
        Assert.assertEquals(0, piece1.getAt(2));
        Assert.assertEquals(0, piece1.getAt(3));
        Assert.assertEquals(0, piece1.getAt(4));
        Assert.assertEquals(1, piece1.getAt(5));

        Assert.assertTrue(piece0.isSameGeometry(piece1));

        PuzzlePiece piece2 = piece0.rotated(Orientation.ANGLE180);
        Assert.assertEquals(Orientation.ANGLE180, piece2.orientation);
    }
}