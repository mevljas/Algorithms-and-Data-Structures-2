package si.unilj.fri.vss.aps2.seminar1;

import java.util.Arrays;

/**
 * Implementation of puzzle piece with 1D array.
 */
public final class PuzzlePiece1DArrayImpl extends PuzzlePiece {

    private final int[] shapeArray;

    public PuzzlePiece1DArrayImpl(PuzzlePieceData data) {
        this(data.getName(), data.getColour(), data.getWidth(), data.getHeight(), data.getShape());
    }

    public PuzzlePiece1DArrayImpl(char name, char colour, int width, int height, String shape) {
        this(name, colour, width, height, shape, Orientation.ANGLE0);
    }

    public PuzzlePiece1DArrayImpl(char name, char colour, int width, int height, String shape, Orientation orientation) {
        super(name, colour, width, height, shape, orientation);
        
        shapeArray = parseShape();
    }

    protected PuzzlePiece1DArrayImpl(char name, char colour, int width, int height, String shape, Orientation orientation, int[] shapeArray) {
        super(name, colour, width, height, shape, orientation);
        
        this.shapeArray = shapeArray;
    }

    /**
     * From this puzzle piece construct a new 1D puzzle piece shape array. 
     * 
     * Use sparingly, since it copies data. Not recommended to use in
     * exhaustive search algorithms! However, it could be used in advance to
     * precalculate all possible shape orientations as they were all
     * different pieces.
     * @param orientation one of four possible orientations the returned piece 
     *  shape array should transform the output shape array to
     * @return 1D shape array in a given orientation
     */
    @Override
    public PuzzlePiece rotated(final Orientation newOrientation) {
        final Orientation rotationAngle = orientation.rotationAngle(newOrientation);
        
        final int w = (rotationAngle.angleIndex % 2 == 0) ? this.width : this.height;
        final int h = (rotationAngle.angleIndex % 2 == 0) ? this.height : this.width;
        
        final int[] outShapeArray = new int[w * h];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int[] rotatedCoords = rotateCoordinates(x, y, rotationAngle);
                final int x0 = rotatedCoords[0];
                final int y0 = rotatedCoords[1];

                final int i0 = y0 * this.width + x0;
                final int i = y * w + x;
                outShapeArray[i] = shapeArray[i0];
            }
        }
        return new PuzzlePiece1DArrayImpl(name, colour, w, h, shape, newOrientation, outShapeArray);
    }

    private int[] parseShape() {
        int[] shapeArray = new int[width * height];
        for (int i = 0; i < shape.length(); i++)
            shapeArray[i] = shape.charAt(i) - '0';
        return shapeArray;
    }

    @Override
    public int getAt(final int i) {
        if (i < 0 || i >= shapeArray.length)
            return -1;
        return shapeArray[i];
    }

    @Override
    public int getAt(final int x, final int y) {
        if (x < 0 || x >= width)
            return -1;
        if (y < 0 || y >= height)
            return -1;       
        return getAt(y * width + x);
    }

    @Override
    public boolean isSameGeometry(final PuzzlePiece other) {
        if (other == null || ! (other instanceof PuzzlePiece1DArrayImpl))
            return false;
        PuzzlePiece1DArrayImpl other1d = (PuzzlePiece1DArrayImpl) other;
        return Arrays.equals(this.shapeArray, other1d.shapeArray);
    }

    /**
     * Shape array represents this puzzle piece's geometry.
     * @return a copy of internal array representing this puzzle piece's geometry
     */
    public int[] toShapeArray() {
        return Arrays.copyOf(shapeArray, shapeArray.length);
    }
}