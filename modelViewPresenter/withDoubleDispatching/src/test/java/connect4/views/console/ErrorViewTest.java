package connect4.views.console;

import connect4.controllers.PlayController;
import connect4.models.GameBuilder;
import connect4.models.State;
import connect4.types.Error;
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
class ErrorViewTest {
    @Mock
    private Console console;
    private ErrorView errorView;

    @BeforeEach
    public void beforeEach(){
        this.errorView = new ErrorView();
    }

    @Test
    public void testGivenNotNullErrorWhenWritelnThenPrint(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            this.errorView.writeln(Error.WRONG_COLUMN);

            verify(this.console).writeln(ErrorView.MESSAGES[Error.WRONG_COLUMN.ordinal()]);
        }
    }

    @Test
    public void testGivenNullErrorWhenWritelnThenNothingIsPrinted(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            this.errorView.writeln(Error.NULL);

            verify(this.console, never()).writeln(anyString());
        }
    }

}