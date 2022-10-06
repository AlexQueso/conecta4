package conecta4;

public enum Direction {

    VERTICAL,
    HORIZONTAL,
    ASCENDING_DIAGONAL,
    DESCENDING_DIAGONAL,
    NULL;

    public boolean isNull() {
        return this == Direction.NULL;
    }

}
