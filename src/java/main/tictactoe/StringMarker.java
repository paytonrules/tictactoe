package tictactoe;

/**
 * Created by hanalee on 8/15/16.
 */
public class StringMarker implements PlayerMarker {

    String marker;

    public StringMarker(String marker) {
        this.marker = marker;
    }

    public String toString() {
        return marker;
    }

}