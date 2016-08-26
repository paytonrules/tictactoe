package tictactoe.player;

import tictactoe.record.MoveHistory;

/**
 * Created by hanalee on 7/28/16.
 */
public interface GamePlayer {

    StringMarker getMarker();

    void move(MoveHistory record);

}