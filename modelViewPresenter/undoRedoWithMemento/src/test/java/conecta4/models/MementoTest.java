package conecta4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MementoTest {

    private Memento memento;

    @BeforeEach
    public void beforeEach() {
        this.memento = new Memento(new GameBuilder().rows(BoardBuilder.middleOfGameRows()).build());
    }

    @Test
    public void testGivenMementoWhenGetBoardThenReturn() {
        assertThat(this.memento.getBoard(), equalTo(BoardBuilder.middleOfGameBoard()));
    }

    @Test
    public void testGivenMementoWhenGetActivePlayerThenReturn() {
        assertThat(this.memento.getActivePlayer(), is(1));
    }

}