package connect4.views.console;

import conecta4.views.Message;
import conecta4.views.console.MessageView;
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
    public void beforeEach(){
        this.messageView = new MessageView();
    }

    @Test
    public void testGivenNewMessageWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.write(Message.ENTER_COLUMN_TO_PUT);
            verify(this.console).write("Enter a column to put a token:");
        }
    }

    @Test
    public void testGivenNewMessageWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.messageView.writeln(Message.ENTER_COLUMN_TO_PUT);
            verify(this.console).writeln("Enter a column to put a token:");
        }
    }

    @Test
    public void givenMessageForSpecificPlayerWhenWritelnThenPrint(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            this.messageView.writeln(Message.PLAYER_WIN, "R");

            verify(this.console).writeln("R player: You win!!! :-)");
        }
    }
}