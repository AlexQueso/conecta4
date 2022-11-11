package connect4.views.console;

import conecta4.types.Color;
import conecta4.views.console.PlayerView;
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
    private PlayerView playerView;

    @BeforeEach
    public void beforeEach() {
        this.playerView = new PlayerView();
    }

    @Test
    public void testGivenPlayerViewWhenWriteWinnerThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playerView.writeWinner(Color.R);
            this.playerView.writeWinner(Color.Y);
            verify(this.console).writeln("R player: You win!!! :-)");
            verify(this.console).writeln("Y player: You win!!! :-)");
        }
    }

    @Test
    public void testGivenPlayerViewWhenTieThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.playerView.writeTie();
            verify(this.console).writeln("It's a Tie!");
        }
    }
}