package connect4.models;

import connect4.types.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TurnTest {

    private Turn turn;

    @BeforeEach
    public void beforeEach() {
        this.turn = new Turn(new Board());
    }

    @Test
    public void testGivenNewTurnWhenNullBoardThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> new Turn(null));
    }

    @Test
    public void testGivenTurnWhenPrepareTurnThenActivePlayerIsR() {
        this.turn.reset();
        assertThat(this.turn.getColorActivePlayer(), is(Color.R));
    }

    @Test
    public void testGivenNewTurnWhenGetActivePlayerThenActivePlayerIsR() {
        assertThat(this.turn.getColorActivePlayer(), is(Color.R));
    }

    @Test
    public void testGivenTurnWhenToggleActivePlayerThenNextPlayer() {
        this.turn.toggleActivePlayer();
        assertThat(this.turn.getColorActivePlayer(), is(Color.Y));
        this.turn.toggleActivePlayer();
        assertThat(this.turn.getColorActivePlayer(), is(Color.R));
    }

}
