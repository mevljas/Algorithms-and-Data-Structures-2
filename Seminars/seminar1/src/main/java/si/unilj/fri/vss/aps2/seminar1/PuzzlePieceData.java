package si.unilj.fri.vss.aps2.seminar1;

public class PuzzlePieceData {
    private final char name;
    private final char colour;
    private final int width;
    private final int height;
    private final String shape;
    private final String shapeName;

    public PuzzlePieceData(char name, char colour, int width, int height, String shape) {
        this.name = name;
        this.colour = colour;
        this.width = width;
        this.height = height;
        this.shape = shape;
        this.shapeName = new String(new char[] {name, colour});
    }

    public char getName() {
        return name;
    }

    public char getColour() {
        return colour;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getShapeName() {
        return shapeName;
    }

    public String getShape() {
        return shape;
    }
}