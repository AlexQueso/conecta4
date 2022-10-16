package conecta4.types;


public enum Message {
    TITLE("--- CONECTA 4 ---"),
    HORIZONTAL_LINE("---------------"),
    VERTICAL_LINE(" | "),
    ENTER_COLUMN_TO_PUT("Enter a column to put a token:"),
    PLAYER_WIN("#player player: You win!!! :-)"),
    RESUME("Do you want to continue"),
    TIE("It's a Tie!"),

    COLUMN("Column: ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}