package conecta4.models;

import conecta4.types.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    private conecta4.models.BoardBuilder boardBuilder;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
    }

    @Test
    public void testGivenNewBoardWhenPutNewTokenThenIsColumnFullIsTrue() {
        Board board = this.boardBuilder.rows(
                "Y      ",
                "R      ",
                "Y      ",
                "R      ",
                "Y      ",
                "R      ").build();

        assertThat(board.isColumnFull(0), is(true));
    }

    @Test
    public void testGivenBoardWhenGetColorThenReturn() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "R      ").build();
        assertThat(board.getColor(new Coordinate(0, 0)), is(Color.R));
    }

    @Test
    public void testGivenBoardWhenGetColorFromNullCoordinateThenReturn() {
        Board board = this.boardBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> board.getColor(null));
    }

    @Test
    public void testGivenBoardWhenisConnect4NullColorThenAssertionError() {
        Board board = this.boardBuilder.build();
        Assertions.assertThrows(AssertionError.class, () -> board.isConnect4(Color.NULL));
    }

    @Test
    public void testGivenOneTokenOnBoardWhenconecta4ThenIsFalse() {
        Board board = this.boardBuilder.build();

        board.putToken(0, Color.R);

        assertThat(board.isConnect4(Color.R), is(false));
        assertThat(board.isConnect4(Color.Y), is(false));
    }

    @Test
    public void testGivenBoardWhenIsVerticalconecta4ThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "R      ",
                "R      ",
                "R      ",
                "R      ",
                "R      ").build();
        assertThat(board.isConnect4(Color.R), is(true));
    }

    @Test
    public void testGivenBoardWhenIsHorizontalconecta4ThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "RRRRR  ").build();
        assertThat(board.isConnect4(Color.R), is(true));
    }

    @Test
    public void testGivenBoardWhenIsAscendingDiagonalconecta4ThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "   R   ",
                "  R    ",
                " R     ",
                "R      ").build();
        assertThat(board.isConnect4(Color.R), is(true));
    }

    @Test
    public void testGivenBoardWhenIsDescendingDiagonalconecta4ThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "R      ",
                " R     ",
                "  R    ",
                "   R   ").build();
        assertThat(board.isConnect4(Color.R), is(true));
    }

    @Test
    public void testGivenBoardWhenIsNotconecta4ThenIsFalse() {
        Board board = this.boardBuilder.rows(
                "       ",
                "       ",
                "R      ",
                "YR     ",
                "YYY    ",
                "RYYRR  ").build();
        assertThat(board.isConnect4(Color.R), is(false));
    }

    @Test
    public void testGivenBoardWhenIsTieThenIsTrue() {
        Board board = this.boardBuilder.rows(
                "RRYRYYR",
                "YYRYRRY",
                "RRRYYYR",
                "YYRYYRY",
                "RRYRRRY",
                "YRRYYRY").build();
        assertThat(board.isTie(), is(true));
    }

}
