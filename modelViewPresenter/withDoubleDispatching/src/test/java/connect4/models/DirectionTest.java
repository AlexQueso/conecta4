package connect4.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DirectionTest {

    @Test
    public void testGivenNewDirectionWhenGetValuesThenReturn() {
        assertThat(Direction.getValues().length, is(8));
    }

    @Test
    public void testGivenNewDirectionWhenGetValuesWithoutOppositesThenReturn() {
        assertThat(Direction.getDirectionsWithoutOpposites().length, is(4));
    }

    @ParameterizedTest
    @MethodSource("provideDirectionAndOpposite")
    public void testGivenDirectionWhenGetOppositeThenReturn(Direction initialDirection, Direction oppositeDirection) {
        assertThat(initialDirection.getOpposite(), is(oppositeDirection));
    }

    private static Stream<Arguments> provideDirectionAndOpposite() {
        return Stream.of(
                Arguments.of(Direction.RIGHT, Direction.LEFT),
                Arguments.of(Direction.UP, Direction.DOWN),
                Arguments.of(Direction.UP_RIGHT, Direction.DOWN_LEFT),
                Arguments.of(Direction.UP_LEFT, Direction.DOWN_RIGHT)
        );
    }
}
