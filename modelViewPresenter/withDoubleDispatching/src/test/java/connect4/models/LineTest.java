package connect4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LineTest {
    private Line line;

    @BeforeEach
    public void beforeEach() {
        this.line = new Line(new Coordinate(3,4));
    }

    @Test
    public void testGivenNewLineWhenSetCoordinatesHorizontalThenReturn() {
        this.line.setCoordinates(Direction.RIGHT);
        assertThat(this.line.getCoordinates().length, is(4));

        assertThat(this.line.getCoordinates()[1].getRow(), is(3));
        assertThat(this.line.getCoordinates()[1].getColumn(), is(5));

        this.line.oppositeCoordinates();
        assertThat(this.line.getCoordinates()[1].getRow(), is(3));
        assertThat(this.line.getCoordinates()[1].getColumn(), is(4));
    }

    @Test
    public void testGivenNewLineWhenSetCoordinatesVerticalThenReturn() {
        this.line.setCoordinates(Direction.UP);
        assertThat(this.line.getCoordinates().length, is(4));

        assertThat(this.line.getCoordinates()[1].getRow(), is(4));
        assertThat(this.line.getCoordinates()[1].getColumn(), is(4));

        this.line.oppositeCoordinates();

        assertThat(this.line.getCoordinates()[1].getRow(), is(3));
        assertThat(this.line.getCoordinates()[1].getColumn(), is(4));
    }

    @Test
    public void testGivenNewLineWhenSetCoordinatesAscendingDiagonalThenReturn() {
        this.line.setCoordinates(Direction.UP_RIGHT);
        assertThat(this.line.getCoordinates().length, is(4));

        assertThat(this.line.getCoordinates()[1].getRow(), is(4));
        assertThat(this.line.getCoordinates()[1].getColumn(), is(5));

        this.line.oppositeCoordinates();

        assertThat(this.line.getCoordinates()[1].getRow(), is(3));
        assertThat(this.line.getCoordinates()[1].getColumn(), is(4));
    }

    @Test
    public void testGivenNewLineWhenSetCoordinatesDescendingDiagonalThenReturn() {
        this.line.setCoordinates(Direction.DOWN_RIGHT);
        assertThat(this.line.getCoordinates().length, is(4));

        assertThat(this.line.getCoordinates()[1].getRow(), is(2));
        assertThat(this.line.getCoordinates()[1].getColumn(), is(5));

        this.line.oppositeCoordinates();

        assertThat(this.line.getCoordinates()[1].getRow(), is(3));
        assertThat(this.line.getCoordinates()[1].getColumn(), is(4));
    }
}
