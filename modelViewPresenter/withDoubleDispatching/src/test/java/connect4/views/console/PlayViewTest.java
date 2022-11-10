package connect4.views.console;

import connect4.controllers.PlayController;
import connect4.models.GameBuilder;
import connect4.models.State;
import connect4.types.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.views.Console;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayViewTest {

    @Mock
    private Console console;
    @Mock
    private PlayController playController;
    private PlayView playView;

    @BeforeEach
    public void beforeEach() {
        this.playView = new PlayView();
        when(this.console.readInt(anyString())).thenReturn(1);
        when(this.playController.isColumnFull(anyInt())).thenReturn(false);
        doNothing().when(this.playController).putToken(anyInt());
        doNothing().when(this.playController).next();
        when(this.playController.getColor(any())).thenReturn(Color.R);
        when(this.playController.isGameOver()).thenReturn(true);
    }

    @Test
    public void testGivenPlayViewWhenInteractThenMatchHasAWinner() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.playController.isTie()).thenReturn(false);
            when(this.playController.getActivePlayer()).thenReturn(Color.R);

            this.playView.interact(this.playController);

            verify(this.console).writeln("R player: You win!!! :-)");
        }
    }

    @Test
    public void testGivenPlayViewWhenInteractThenMatchIsATie() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.playController.isTie()).thenReturn(true);

            this.playView.interact(this.playController);

            verify(this.console).writeln("It's a Tie!");
        }
    }
}