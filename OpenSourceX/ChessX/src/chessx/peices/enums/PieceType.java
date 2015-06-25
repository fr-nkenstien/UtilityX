package chessx.peices.enums;

public enum PieceType {
    KING(0),
    QUEEN(9),
    PAWN(1),
    BISHOP(3),
    KNIGHT(3),
    ROOK(3);
    @SuppressWarnings("compatibility:-7737400072303179111")
    private static final long serialVersionUID = 1L;
    private final int points;

    PieceType(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }
}
