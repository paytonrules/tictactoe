package tictactoe;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.Before;

public class GameBoardTest {

    @Test
    public void testCreateTwoByTwoBoard() {
        GameBoard board = new GameBoard(2);
        assertNotNull(board);
        assertEquals(2, board.getNumRows());
        assertEquals(4, board.getSpaces().length);
    }

    @Test
    public void testCreateThreeByThreeBoard() {
        GameBoard board = new GameBoard();
        assertEquals(3, board.getNumRows());
        assertEquals(9, board.getSpaces().length);
    }

}
