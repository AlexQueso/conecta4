package connect4.views;

import connect4.controllers.PlayController;
import connect4.types.Error;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.views.Console;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerViewTest {

    @Mock
    private Console console;
    @Mock
    private PlayController playController;
    private PlayerView playerView;

    @BeforeEach
    public void beforeEach() {
        this.playerView = new PlayerView(this.playController);
    }

    @Test
    public void testGivenValidEmptyColumnWhenInteractThenPutToken() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            when(this.playController.isColumnFull(0)).thenReturn(false);
            doNothing().when(playController).putToken(0);

            this.playerView.interact();

            verify(this.playController).putToken(0);
        }
    }

    @Test
    public void testGivenValidFullColumnWhenInteractThenPutTokenError() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1, 2);
            when(this.playController.isColumnFull(anyInt())).thenReturn(true, false);
            doNothing().when(playController).putToken(1);

            this.playerView.interact();

            verify(this.console).writeln(ErrorView.MESSAGES[Error.FULL.ordinal()]);
        }
    }
}