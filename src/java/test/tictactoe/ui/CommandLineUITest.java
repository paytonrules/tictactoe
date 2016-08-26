package tictactoe.ui;

import org.junit.Before;
import org.junit.Test;
import tictactoe.player.MockGamePlayer;
import tictactoe.Simulator;
import tictactoe.board.SquareBoard;
import tictactoe.player.GamePlayer;
import tictactoe.player.StringMarker;
import tictactoe.record.GameRecord;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

/**
 * Created by hanalee on 8/8/16.
 */
public class CommandLineUITest {
    private ByteArrayOutputStream output;
    private MockInputStream input;
    private CommandLineUI ui;
    private SquareBoard board;
    private GameRecord record;
    private GamePlayer playerOne;
    private GamePlayer playerTwo;

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
        input = new MockInputStream();
        ui = new CommandLineUI(input, output);
        board = new SquareBoard(3);
        StringMarker xMarker = new StringMarker("X");
        StringMarker oMarker = new StringMarker("O");
        playerOne = new MockGamePlayer(xMarker);
        playerTwo = new MockGamePlayer(oMarker);
        record = new GameRecord(board, playerOne, playerTwo);
    }

    @Test
    public void testDisplayMessage() {
        String message = "Tic Tac Toe";
        ui.displayMessage(message);
        assertEquals(message + "\n", output.toString());
    }

    @Test
    public void generateFormattableStringForBoard() {
        String boardString =  " %s | %s | %s \n" +
                              "---+---+---\n" +
                              " %s | %s | %s \n" +
                              "---+---+---\n" +
                              " %s | %s | %s \n";
        assertEquals(boardString, ui.generateBoardAsString(record));
    }

    @Test
    public void generateFormattableStringForSmallBoard() {
        String boardString =  " %s | %s \n" +
                              "---+---\n" +
                              " %s | %s \n";
        SquareBoard twoByTwoBoard = new SquareBoard(2);
        GameRecord twoByTwoRecord = new GameRecord(twoByTwoBoard,
                playerOne, playerTwo);
        assertEquals(boardString, ui.generateBoardAsString(twoByTwoRecord));
    }

    @Test
    public void testConvertEmptyBoardIntoString() {
        String boardString = " 0 | 1 | 2 \n" +
                             "---+---+---\n" +
                             " 3 | 4 | 5 \n" +
                             "---+---+---\n" +
                             " 6 | 7 | 8 \n";
        assertEquals(boardString, ui.convertBoardToString(record));
    }

    @Test
    public void testConvertSmallEmptyBoardIntoString() {
        String boardString = " 0 | 1 \n" +
                             "---+---\n" +
                             " 2 | 3 \n";
        SquareBoard twoByTwoBoard = new SquareBoard(2);
        GameRecord twoByTwoRecord = new GameRecord(twoByTwoBoard,
                playerOne, playerTwo);
        assertEquals(boardString, ui.convertBoardToString(twoByTwoRecord));
    }

    @Test
    public void testConvertNonEmptyBoardIntoString() {
        String boardString = " 0 | O | 2 \n" +
                             "---+---+---\n" +
                             " O | X | X \n" +
                             "---+---+---\n" +
                             " 6 | 7 | 8 \n";
        Simulator.simulateGame(record,
                4, 1, 5, 3);
        assertEquals(boardString, ui.convertBoardToString(record));
    }

    @Test
    public void testDisplayEmptyBoard() {
        String boardString = " 0 | 1 | 2 \n" +
                             "---+---+---\n" +
                             " 3 | 4 | 5 \n" +
                             "---+---+---\n" +
                             " 6 | 7 | 8 \n";
        ui.displayBoard(record);
        assertEquals(boardString, output.toString());
    }

    @Test
    public void testDisplayNonEmptyBoard() {
        String boardString = " 0 | O | 2 \n" +
                             "---+---+---\n" +
                             " O | X | X \n" +
                             "---+---+---\n" +
                             " 6 | 7 | 8 \n";
        Simulator.simulateGame(record,
                4, 1, 5, 3);
        ui.displayBoard(record);
        assertEquals(boardString, output.toString());
    }

    @Test
    public void testGetUserInput() {
        String message = "Tic Tac Toe";
        input.setInputStream(message);
        assertEquals("Tic Tac Toe", ui.getUserInput());
    }

    @Test
    public void testDisplayPrompt() {
        String prompt = "Enter move";
        input.setInputStream("0");
        assertEquals("0", ui.displayPrompt(prompt));
        assertEquals(prompt + "\n", output.toString());
    }
}