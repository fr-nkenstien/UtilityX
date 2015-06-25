package chessx.peices.enums;

public enum ChessSide {
    BLACK(0),
    WHITE(1);
    @SuppressWarnings("compatibility:4902979070250272794")
    private static final long serialVersionUID = 1L;
    private final int side;

    ChessSide(int side) {
        this.side = side;
    }

    public int getPoints() {
        return this.side;
    }
}
