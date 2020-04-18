package si.unilj.fri.vss.aps2.seminar1;

import java.io.Reader;
import java.util.Scanner;

/**
 * Contains methods for reading and parsing input from the character stream 
 * such as the standard input.
 */
public class IQFitInputReader {
    private IQFitGameData gameData;

    private Reader reader;
    
    public IQFitInputReader(Reader reader) {
        this.reader = reader;
        gameData = new IQFitGameData();
    }

    /**
     * Get results of parsing in a form of game data model.
     * @return the game data
     */
    public IQFitGameData getGameData() {
        return gameData;
    }

    /**
     * Performs parsing of the input.
     * @return true if parsing succeeds and false otherwise
     */
    public boolean parseInput() {
        try (
            Scanner scanner = new Scanner(reader)) {

            if (! readDimensions(scanner))
                return false;
            
            if (! readPuzzlePieces(scanner))
                return false;
        }
        return true;
    }

    /**
     * Helper method for reading the content of the first non-empty
     * line in the input.
     * @param scanner the instance of the Scanner used for parsing
     * the input
     * @return true of the dimensions are successfully extracted 
     * from the input and false otherwise 
     */
    private boolean readDimensions(Scanner scanner) {
        // Expect input of format: 
        // w h k

        // Board dimensions
        if (! scanner.hasNextInt())
            return false;
        gameData.setBoardWidth(scanner.nextInt());
        if (! scanner.hasNextInt())
            return false;
        gameData.setBoardHeight(scanner.nextInt());
        
        // Number of puzzle pieces and pairs
        if (! scanner.hasNextInt())
            return false;
        int k = scanner.nextInt();
        gameData.setNumberOfPuzzlePairs(k);
        gameData.setNumberOfPuzzles(2 * k);

        return true;
    }

    /**
     * Helper method to read the second and all the following non/empty 
     * lines from the input.
     * @param scanner the scanner of the input
     * @return true if parsing is successful and false otherwise
     */
    private boolean readPuzzlePieces(Scanner scanner) {
        // Expect 2 * k lines, each containing puzzle piece description
        for (int i = 0; i < gameData.getNumberOfPuzzles(); i++) {
            if (! readPuzzlePiece(scanner))
                return false;
        }
        return true;
    }

    /**
     * Helper method for reading one puzzle piece from the input
     * @param scanner the scanner to parse the input with
     * @return true if the puzzle piece is parser successfully and
     * false otherwise.
     */
    private boolean readPuzzlePiece(Scanner scanner) {
        /* Expect a line with the following format:
         * N C W H D
         * with
         * N = name (a single letter; the name of the puzzle piece)
         * C = colour (a single letter; the colour of the puzzle piece)
         * W = width (a number; the width of the puzzle piece)
         * H = height (a number; the height of the puzzle piece)
         * D = data (a sequence of 0s and 1s; the shape data of the puzzle piece)
         */
        if (scanner.hasNext()) {
            String sName = scanner.next();
            assert sName != null;
            assert sName.length() == 1;
            char name = sName.charAt(0);

            String sColour = scanner.next();
            assert sColour != null;
            assert sColour.length() == 1;
            char colour = sColour.charAt(0);

            int w = scanner.nextInt();
            int h = scanner.nextInt();
            assert w > 0;
            assert h > 0;

            String shape = scanner.next();
            assert shape != null;
            assert w * h == shape.length();

            gameData.addPuzzlePiece(name, colour, w, h, shape);
            
            return true;
        }
        return false;
    }
}