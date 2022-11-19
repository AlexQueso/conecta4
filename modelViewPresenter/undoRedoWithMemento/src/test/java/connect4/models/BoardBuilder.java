package connect4.models;

import connect4.types.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class BoardBuilder {

    private List<String> rows;

    public BoardBuilder() {
        this.rows = new ArrayList<>();
    }

    public BoardBuilder rows(String... rows) {
        assert rows.length == 6;
        for (String row : rows) {
            assert Pattern.matches("[RY ]{7}", row);
            this.rows.add(row);
        }
        return this;
    }

    public Board build() {
        Board board = new Board();
        if (!this.rows.isEmpty()) {
            for (int i = this.rows.size()-1; i >= 0; i--) {
                String string = this.rows.get(i);
                for (int j = 0; j < string.length(); j++) {
                    if(this.getColor(string.charAt(j)) != Color.NULL) {
                        board.putToken(j, this.getColor(string.charAt(j)));
                    }
                }
            }
        }
        return board;
    }

    private Color getColor(char character) {
        Color result = Color.NULL;
        for (int i = 0; i < Color.values().length - 1; i++) {
            Color color = Color.values()[i];
            if (color.name().equals("" + character)) {
                result = color;
            }
        }
        return result;
    }

    public static String[] middleOfGameRows() {
        return new String[]{
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "RY     ",
        };
    }

    public static Board middleOfGameBoard() {
        Board board = new Board();
        board.putToken(0, Color.R);
        board.putToken(1, Color.Y);
        return board;
    }

    public static String expectedMiddleOfGameOutput() {
        return Arrays.toString(new String[]{
                "---------------",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " | R | Y |   |   |   |   |   | ",
                "---------------"}
        ).replaceAll(", ", "");
    }



}
