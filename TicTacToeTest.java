package tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

public class TicTacToeTest {

    private GameBoard board; 

    @Before
    public void setUp() {
        board = new GameBoard();
    }

    @Test
    public void testCreateGameBoard() {
        assertNotNull(board);
    }

    @Test
    public void testGetSpace() {
        assertEquals("", board.getSpace(1));
    }

    @Test
    public void testMove() {
        board.move(1, "X");
        assertEquals("X", board.getSpace(1)); 
    }
}
