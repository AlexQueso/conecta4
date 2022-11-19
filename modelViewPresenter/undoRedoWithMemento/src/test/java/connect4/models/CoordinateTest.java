package connect4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.models.Direction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CoordinateTest {
    private Coordinate coordinate;

    @BeforeEach
    public void beforeEach() {
        this.coordinate = new Coordinate(3,4);
    }

    @Test
    public void testGivenNewCoordinateWhenChangeWithDirectionThenReturn() {
        Coordinate newCoordinate = this.coordinate.changeCoordinateWithDirection(Direction.RIGHT.getCoordinate());
        assertThat(newCoordinate.getRow(), is(3));
        assertThat(newCoordinate.getColumn(), is(5));

        newCoordinate = this.coordinate.changeCoordinateWithDirection(Direction.UP.getCoordinate());
        assertThat(newCoordinate.getRow(), is(4));
        assertThat(newCoordinate.getColumn(), is(4));

        newCoordinate = this.coordinate.changeCoordinateWithDirection(Direction.DOWN_LEFT.getCoordinate());
        assertThat(newCoordinate.getRow(), is(2));
        assertThat(newCoordinate.getColumn(), is(3));

        newCoordinate = this.coordinate.changeCoordinateWithDirection(Direction.UP_RIGHT.getCoordinate());
        assertThat(newCoordinate.getRow(), is(4));
        assertThat(newCoordinate.getColumn(), is(5));
    }

    @Test
    public void testGivenWrongCoordinateThenReturnFalse() {
        assertThat(this.coordinate.isValidCoordinate(-1, 0), is(false));
        assertThat(this.coordinate.isValidCoordinate(1, -1), is(false));
    }
}
