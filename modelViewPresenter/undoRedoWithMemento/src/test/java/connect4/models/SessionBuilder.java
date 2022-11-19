package connect4.models;

import connect4.types.Color;

public class SessionBuilder {

    private String[] rows;
    private Session session;

    public SessionBuilder(){
        this.rows = new String[]{
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       "};
    }

    public SessionBuilder rows(String... rows){
        this.rows = rows;
        return this;
    }

    public Session build(){
        this.session = new Session();
        this.buildBoard();
        return this.session;
    }

    private void buildBoard() {
        this.putTokens(Color.R);
        this.session.next();
        this.putTokens(Color.Y);
    }

    private void putTokens(Color color) {
        for (int i = this.rows.length-1; i >= 0; i--) {
            String string = this.rows[i];
            for (int j = 0; j < string.length(); j++) {
                if(Character.toString(string.charAt(j)).equals(color.name())) {
                    this.session.putToken(j);
                }
            }
        }
    }
}
