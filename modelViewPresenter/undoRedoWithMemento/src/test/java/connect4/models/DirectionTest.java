package connect4.models;

import org.junit.jupiter.api.Test;
import utils.models.Direction;

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

    @Test
    public void testGivenDirectionWhenGetOppositeThenReturn() {
        assertThat(Direction.RIGHT.getOpposite(), is(Direction.LEFT));
        assertThat(Direction.UP.getOpposite(), is(Direction.DOWN));
        assertThat(Direction.UP_RIGHT.getOpposite(), is(Direction.DOWN_LEFT));
        assertThat(Direction.UP_LEFT.getOpposite(), is(Direction.DOWN_RIGHT));
    }
}
