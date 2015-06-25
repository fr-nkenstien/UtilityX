package chessx.peices;

import chessx.peices.enums.ChessSide;
import chessx.peices.enums.PieceType;

public abstract class PlayPiece {
    public PlayPiece(PieceType type, ChessSide side) {
        super();
        this.type = type;
        this.side = side;
    }
    private int id;
    private PieceType type;
    private ChessSide side;
    private int[] currentPosition;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public PieceType getType() {
        return type;
    }

    public void setSide(ChessSide side) {
        this.side = side;
    }

    public ChessSide getSide() {
        return side;
    }

    /**
     * @return
     */
    public abstract boolean validateMove();

    public abstract boolean killPiece();

    public abstract boolean movePiece();

    public boolean die() {
        return true;
    }

    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int[] getCurrentPosition() {
        return currentPosition;
    }
}
