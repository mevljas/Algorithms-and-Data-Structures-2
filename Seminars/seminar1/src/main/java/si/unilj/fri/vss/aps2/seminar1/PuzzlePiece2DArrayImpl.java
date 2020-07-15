package si.unilj.fri.vss.aps2.seminar1;

import java.util.Arrays;

/**
 * Implementation of puzzle piece with 2D array.
 */
public final class PuzzlePiece2DArrayImpl extends PuzzlePiece {

    private final int[][] shapeArray;

    public PuzzlePiece2DArrayImpl(PuzzlePieceData data) {
        this(data.getName(), data.getColour(), data.getWidth(), data.getHeight(), data.getShape());
    }

    public PuzzlePiece2DArrayImpl(char name, char colour, int width, int height, String shape) {
        this(name, colour, width, height, shape, Orientation.ANGLE0);
    }

    public PuzzlePiece2DArrayImpl(char name, char colour, int width, int height, String shape, Orientation orientation) {
        super(name, colour, width, height, shape, orientation);

        shapeArray = parseShape();
    }

    protected PuzzlePiece2DArrayImpl(char name, char colour, int width, int height, String shape, Orientation orientation, int[][] shapeArray) {
        super(name, colour, width, height, shape, orientation);

        this.shapeArray = shapeArray;
    }

    /**
     * From this puzzle piece construct a new 2D puzzle piece shape array. 
     * 
     * Use sparingly, since it copies data. Not recommended to use in
     * exhaustive search algorithms! However, it could be used in advance to
     * precalculate all possible shape orientations as they were all
     * different pieces.
     * @param orientation one of four possible orientations the returned piece 
     *  shape array should transform the output shape array to
     * @return 2D shape array in a given orientation
     */
    @Override
    public PuzzlePiece rotated(final Orientation newOrientation) {
        final Orientation rotationAngle = orientation.rotationAngle(newOrientation);

        final int w = (rotationAngle.angleIndex % 2 == 0) ? this.width : this.height;
        final int h = (rotationAngle.angleIndex % 2 == 0) ? this.height : this.width;
        
        final int[][] outShapeArray = new int[h][w];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                final int[] rotatedCoords = rotateCoordinates(x, y, rotationAngle);
                final int x0 = rotatedCoords[0];
                final int y0 = rotatedCoords[1];

                outShapeArray[y][x] = shapeArray[y0][x0];
            }
        }
        return new PuzzlePiece2DArrayImpl(name, colour, w, h, shape, newOrientation, outShapeArray);
    }

    private int[][] parseShape() {
        final int[][] shapeArray = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int i = y * width + x;
                shapeArray[y][x] = shape.charAt(i) - '0';
            }
        }
        return shapeArray;
    }

    @Override
    public int getAt(final int i) {
        if (i < 0 || i >= width * height)
            return -1;
        return getAt(i - width * (i / width), i / width);
    }

    @Override
    public int getAt(final int x, final int y) {
        if (x < 0 || x >= width)
            return -1;
        if (y < 0 || y >= height)
            return -1;
        return shapeArray[y][x];
    }

    @Override
    public boolean isSameGeometry(final PuzzlePiece other) {
        if (other == null || ! (other instanceof PuzzlePiece2DArrayImpl))
            return false;
        PuzzlePiece2DArrayImpl other2d = (PuzzlePiece2DArrayImpl) other;
        return Arrays.deepEquals(this.shapeArray, other2d.shapeArray);
    }
}