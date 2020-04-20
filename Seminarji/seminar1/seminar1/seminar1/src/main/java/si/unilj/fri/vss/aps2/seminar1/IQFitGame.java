package si.unilj.fri.vss.aps2.seminar1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The main class containing the main entry point.
 */
public class IQFitGame {

    private static IQFitGameData readInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            IQFitInputReader inputReader = new IQFitInputReader(br);

            if (! inputReader.parseInput()) {
                System.err.println("An error occurred while parsing input.");
                System.exit(1);
            }
            return inputReader.getGameData();
        }
        catch (IOException ioe) {
            System.err.println("An error occurred while working with the input stream. " + ioe.getMessage());
            ioe.printStackTrace();
            System.exit(2);
        }
        return null;
    }

    private static List<PuzzlePiece> constructPuzzlePieces(IQFitGameData gameData) {
        List<PuzzlePiece> puzzlePieces = new ArrayList<>();
        for (PuzzlePieceData puzzleData : gameData.puzzlePieces)
            puzzlePieces.add(new PuzzlePiece1DArrayImpl(puzzleData));
        return puzzlePieces;
    }

    public static void main(String ... args) {
        // Read input from System.in
        IQFitGameData gameData = readInput();

        // Extract puzzle pieces
        List<PuzzlePiece> puzzlePieces = constructPuzzlePieces(gameData);

        // IMPORTANT: If printing anything else that the board state, use System.err!
        System.err.println(String.format("Board dimensions: width = %d, height = %d",
                gameData.getBoardWidth(), gameData.getBoardHeight()));
        System.err.print("All puzzle pieces:");
        for (PuzzlePiece piece : puzzlePieces) {
            System.err.print(" " + piece);
        }
        System.err.println();
        System.err.println();

        // Initialize board
        Board board = new Board1DArrayImpl(gameData.getBoardWidth(), gameData.getBoardHeight());

        // Select placement algorithm
//        PlacementAlgorithm placementAlgorithm = new DummyPlacementAlgorithm(board, puzzlePieces);
        PlacementAlgorithm placementAlgorithm = new BacktrackPlacementAlgorithm(board, puzzlePieces);

        // Do the placement
        placementAlgorithm.placePuzzlePieces();

        // IMPORTANT: Print for the evaluation. Even better if done at least once in the placement algorithm.
        board.printBoard();

        // Print for your convenience
        System.err.println(String.format("Filled: %.2f%%", placementAlgorithm.evaluate() * 100.0));
    }
}