package si.unilj.fri.vss.aps2.seminar1;

/**
 * Abstract class representing puzzle piece.
 */
public abstract class PuzzlePiece {

    public static final int EMPTY_SQUARE = 0;
    public static final int FILLED_SQUARE = 1;

    /**
     * All possible orientations of a puzzle piece.
     */
    public enum Orientation {
        ANGLE0   (0),
        ANGLE90  (1),
        ANGLE180 (2),
        ANGLE270 (3);

        public final int angleIndex;
        private static final Orientation[] values = values();

        Orientation(int angleIdx) {
            angleIndex = angleIdx;
        }

        /**
         * Subtract the given orientation from this orientation, resulting in
         * the rotation angle
         * @param newOrientation the target orientation
         * @return the orientation as the rotation angle
         */
        public Orientation rotationAngle(Orientation newOrientation) {
            int angleDifference = Math.floorMod(newOrientation.angleIndex - angleIndex, 4); // or (y + 4 - x) % 4
            assert angleDifference >= 0 && angleDifference < 4;
            return values[angleDifference];
        }

        public Orientation add(Orientation orientation) {
            int angleSum = (this.angleIndex + orientation.angleIndex) % 4;
            assert angleSum >= 0 && angleSum < 4;
            return values[angleSum];
        }
    }

    /**
     * The width of the bounding box of this puzzle piece
     */
    protected final int width;

    /** 
     * The height of the bounding box of this puzzle piece
     */
    protected final int height;
    
    /**
     * The name of this puzzle piece
     */
    protected final char name;

    /**
     * The colour of this puzzle piece
     */
    protected final char colour;

    /**
     * String representation of this puzzle piece's geometry. This is
     * immutable and preserved even when the puzzle piece is rotated.
     */
    protected final String shape; 

    /**
     * The name of the puzzle piece, composed of two characters: the name and the
     * colour
     */
    protected final String shapeName;

    /**
     * Holds orientation of this puzzle piece. When first created, the orientation
     * is always angle 0.
     */
    protected final Orientation orientation;

    /**
     * Construct puzzle piece given the puzzle piece data read from
     * the input
     * @param data the puzzle piece data, populated by reading from the 
     * standard input 
     */
    public PuzzlePiece(PuzzlePieceData data) {
        this(data.getName(), data.getColour(), data.getWidth(), data.getHeight(), data.getShape());
    }

    /**
     * Constructor for this puzzle piece. 
     * @param name the name of this puzzle piece
     * @param colour the colour of this puzzle piece
     * @param width the width of the shape of this puzzle piece
     * @param height the height of the shape of this puzzle piece
     * @param shape the shape string of 1s and 0s
     */
    public PuzzlePiece(char name, char colour, int width, int height, String shape) {
       this(name, colour, width, height, shape, Orientation.ANGLE0);
    }

    /**
     * Constructor for this puzzle piece. 
     * @param name the name of this puzzle piece
     * @param colour the colour of this puzzle piece
     * @param width the width of the shape of this puzzle piece
     * @param height the height of the shape of this puzzle piece
     * @param shape the shape string of 1s and 0s
     * @param orientation the orientation of this puzzle piece
     */
    public PuzzlePiece(char name, char colour, int width, int height, String shape, Orientation orientation) {
        this.name = name;
        this.colour = colour;
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.orientation = orientation;

        this.shapeName = new String(new char[] {name, colour});

        assert shape != null;
        assert width * height == shape.length();
    }

    /**
     * Obtains the width of this puzzle piece.
     * @return the width of this puzzle piece
     */
    public int getWidth() {
        return width;
    }

    /**
     * Obtains the height of this puzzle piece.
     * @return the height of this puzzle piece
     */
    public int getHeight() {
        return height;
    }

    /**
     * Obtains this puzzle piece's name, in one character.
     * @return the name of this puzzle piece
     */
    public char getName() {
        return name;
    }

    /**
     * Obtains a member field storing this puzzle piece's colour. 
     * Useful for distinguishing puzzle pairs. 
     * @return the colour of this puzzle piece
     */
    public char getColour() {
        return colour;
    }

    /**
     * Obtains this puzzle piece's full name, of length two, concatenated
     * from its name and colour.  Useful for printing out this puzzle 
     * piece's full name;
     * @return The full name of this puzzle piece, concatenated from its
     * name and colour
     */
    public String getShapeName() {
        return this.shapeName;
    }

    /**
     * Obtains the original shape representation string as read from input. 
     * @return string representation of this puzzle piece's shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * Returns a copy of this puzzle piece that has rotated geometry
     * in the given target orientation. Calling this method often in 
     * a tight loop is not recommended due to copy.
     * @param newOrientation the new orientation of this puzzle piece's
     * geometry
     * @return the new rotated puzzle piece
     */
    public abstract PuzzlePiece rotated(final Orientation newOrientation);

    /**
     * Get the puzzle piece's geometry part at the given index.
     * @param i the index
     * @return 1 if puzzle piece's part is non-empty and 0 otherwise
     */
    public abstract int getAt(final int i);

    /**
     * Get the puzzle piece's geometry part at the given coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return 1 if puzzle piece's part is non-empty and 0 otherwise
     */
    public abstract int getAt(final int x, final int y);

    /**
     * Compares this puzzle piece to the other in their colours.
     * @param other the other puzzle piece
     * @return true if the pieces match in colour and false otherwise
     */
    public boolean isSameColour(final PuzzlePiece other) {
        return (other != null) && (other.colour == this.colour);
    }

    /**
     * Same as <code>isSameColour</code>
     * @param other the other puzzle piece
     * @return true if this puzzle piece pairs with the other and
     * false otherwise
     */
    public boolean isSamePair(final PuzzlePiece other) {
        return isSameColour(other);
    }

    /**
     * Check whether this puzzle piece equals the other puzzle piece in the name, the colour 
     * and the orientation angle. However, this method only checks the internal orientation 
     * attribute but not their actual geometry.
     * @param other the other puzzle piece
     * @return true if this and the other puzzle piece are equal and identically oriented
     */
    public boolean isSameOrientation(final PuzzlePiece other) {
        return this.equals(other) && (this.orientation == other.orientation);
    }

    /**
     * Compares the geometry of this and the other puzzle piece. The two
     * pieces have the same geometry when they describe the same shape in the
     * same rotation. 
     * @param other the other puzzle piece
     * @return true if the two puzzle pieces share the same geometry and false
     * otherwise
     */
    public abstract boolean isSameGeometry(final PuzzlePiece other);

    /**
     * Compares the name and the colour of this puzzle piece to the other.
     * @param other the other puzzle piece
     * @return true if this and the other puzzle piece match in name and colour
     */
    @Override
    public boolean equals(final Object other) {
        return (other != null) && (other instanceof PuzzlePiece) && 
            ((PuzzlePiece) other).shapeName.equals(this.shapeName);
    }

    /**
     * Get this puzzle piece's full name, suitable for print.
     * @return string representation of this object
     */
    @Override
    public String toString() {
        return this.shapeName;
    }

    /**
     * Transform coordinates to by the given rotation.
     * @param x coordinate x in the given orientation
     * @param y coordinate y in the given orientation
     * @param orientation one of the angles: 0, 90, 180 or 270
     * @return int array of length 2, containing the transformed 
     * x and y
     */
    protected int[] rotateCoordinates(final int x, final int y, final Orientation rotation) {
        int x0 = 0, y0 = 0;
        switch (rotation) {
            case ANGLE0:
                x0 = x;
                y0 = y;
                break;
            case ANGLE90:
                x0 = this.width - 1 - y;
                y0 = x;
                break;
            case ANGLE180:
                x0 = this.width - 1 - x;
                y0 = this.height - 1 - y;
                break;
            case ANGLE270:
                x0 = y;
                y0 = this.height - 1 - x;
                break;
        }
        assert x0 >= 0 && x0 < this.width;
        assert y0 >= 0 && y0 < this.height;

        return new int[] {x0, y0};
    }

    /**
     * Prints the geometry of this puzzle piece on the standard output.
     */
    public void printShape() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (this.getAt(x, y) == FILLED_SQUARE)
                    System.out.print(shapeName + " ");
                else
                    System.out.print("00 ");
            }
            System.out.println();
        }
    }
}
