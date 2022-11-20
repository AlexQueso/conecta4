package connect4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CoordinateTest {
    private Coordinate coordinate;

    @BeforeEach
    public void beforeEach() {
        this.coordinate = new Coordinate(3,4);
    }

    @ParameterizedTest
    @MethodSource("provideDirectionRowAndColumn")
    public void testGivenNewCoordinateWhenChangeWithDirectionThenReturn(Coordinate coordinate, int row, int column) {
        Coordinate newCoordinate = this.coordinate.changeCoordinateWithDirection(coordinate);
        assertThat(newCoordinate.getRow(), is(row));
        assertThat(newCoordinate.getColumn(), is(column));
    }

    @Test
    public void testGivenWrongCoordinateThenReturnFalse() {
        assertThat(this.coordinate.isValidCoordinate(-1, 0), is(false));
        assertThat(this.coordinate.isValidCoordinate(1, -1), is(false));
    }

    private static Stream<Arguments> provideDirectionRowAndColumn() {
        return Stream.of(
                Arguments.of(Direction.RIGHT.getCoordinate(), 3, 5),
                Arguments.of(Direction.UP.getCoordinate(), 4, 4),
                Arguments.of(Direction.DOWN_LEFT.getCoordinate(), 2, 3),
                Arguments.of(Direction.UP_RIGHT.getCoordinate(), 4, 5)
        );
    }
}
