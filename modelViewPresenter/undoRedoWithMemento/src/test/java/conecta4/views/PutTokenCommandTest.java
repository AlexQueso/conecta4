package conecta4.views;

import conecta4.controllers.PlayController;
import conecta4.models.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.views.Console;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PutTokenCommandTest {

    @Mock
    private Console console;

    private PlayController playController;
    private PutTokenCommand putTokenCommand;

    @BeforeEach
    public void beforeEach() {
        this.playController = spy(new PlayController(new Session()));
        this.putTokenCommand = new PutTokenCommand(playController);
    }

    @Test
    public void testGivenPutTokenCommandWhenExecuteThenPutToken() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(1);
            this.putTokenCommand.execute();
            verify(this.playController).putToken(0);
            verify(this.playController).next();
        }
    }
}