package chessx.players;

import chessx.peices.PlayPiece;

public abstract class Player {
    public Player() {
        super();
    }

    public abstract boolean movePiece(PlayPiece piece, int[] target);

}
