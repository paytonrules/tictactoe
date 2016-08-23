package tictactoe;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

/**
 * Created by hanalee on 8/17/16.
 */
public interface MoveHistory {

    GamePlayer getPlayerOne();

    GamePlayer getPlayerTwo();

    Board getBoard();

    boolean isValidMove(int move);

    void newMove(int move, GamePlayer player);

    int getLastMove();

    GamePlayer getLastPlayer();

    Optional<GamePlayer> whoPlayedMove(int move);

    List<Integer> getAllMoves();

    Hashtable<GamePlayer, ArrayList<Integer>> getMovesByPlayer();

    MoveHistory copyRecord();

}
