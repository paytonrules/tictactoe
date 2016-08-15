package tictactoe;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by hanalee on 7/28/16.
 */
public class CommandLineUI implements GameUI {

    private PrintStream outputStream;
    private InputStream inputStream;

    public CommandLineUI() {
        this.inputStream = System.in;
        this.outputStream = System.out;
    }

    public CommandLineUI(InputStream input, OutputStream output) {
        this.inputStream = input;
        this.outputStream = new PrintStream(output);
    }

    private String generateBoardElementsAsString(String space,
                                                 String separator,
                                                 int multiplier) {
        String[] spaces = new String[multiplier];
        Arrays.fill(spaces, space);
        String spacesWithSeparators = String.join(separator, spaces);
        return spacesWithSeparators;
    }

    public String generateBoardAsString(GameRecord record) {
        int numRows = record.getBoard().getNumRows();
        String boardSpaces = generateBoardElementsAsString(" %s ", "|", numRows);
        String boardRows = generateBoardElementsAsString("---", "+", numRows);
        String board = generateBoardElementsAsString(boardSpaces + "\n",
                boardRows + "\n",
                numRows);
        return board;
    }

    public String convertBoardToString(GameRecord record) {
        int numRows = record.getBoard().getNumRows();
        Object[] labels = new String[(numRows * numRows)];
        for (int space = 0; space < (numRows * numRows); space++) {
            labels[space] = String.format("%d", space);
        }
        Hashtable<GamePlayer, ArrayList<Integer>> movesByPlayer = record.getMovesByPlayer();
        if (movesByPlayer != null) {
            for (GamePlayer player : movesByPlayer.keySet()) {
                for (int move : movesByPlayer.get(player)) {
                    labels[move] = player.getMarker();
                }
            }
        }
        return String.format(generateBoardAsString(record), labels);
    }

    @Override
    public void displayMessage(String message) {
        outputStream.println(message);
    }

    @Override
    public void displayBoard(GameRecord record) {
        outputStream.print(convertBoardToString(record));
    }

    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextLine();
    }

    public String displayPrompt(String prompt) {
        displayMessage(prompt);
        return getUserInput();
    }

}