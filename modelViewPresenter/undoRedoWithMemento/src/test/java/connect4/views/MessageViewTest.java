package connect4.views;

import connect4.types.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.views.Console;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessageViewTest {

    @Mock
    private Console console;
    private MessageView messageView;

    @BeforeEach
    public void beforeEach() {
        this.messageView = new MessageView();
    }

    @Test
    public void testGivenMessageWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            this.messageView.write(Message.TIE);

            verify(this.console).write("It's a Tie!");
        }
    }

    @Test
    public void testGivenMessageWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            this.messageView.writeln(Message.TIE);

            verify(this.console).writeln("It's a Tie!");
        }
    }


    @Test
    public void testGivenMessageForSpecificPlayerWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            this.messageView.writeln(Message.PLAYER_WIN, "R");

            verify(this.console).writeln("R player: You win!!! :-)");
        }
    }
}