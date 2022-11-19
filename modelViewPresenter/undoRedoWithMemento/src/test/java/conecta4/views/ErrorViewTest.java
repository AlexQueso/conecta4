package conecta4.views;

import conecta4.types.Error;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.views.Console;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ErrorViewTest {
    @Mock
    private Console console;
    private ErrorView errorView;

    @BeforeEach
    public void beforeEach() {
        this.errorView = new ErrorView();
    }

    @Test
    public void testGivenNotNullErrorWhenWritelnThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            this.errorView.writeln(Error.WRONG_COLUMN);

            verify(this.console).writeln(ErrorView.MESSAGES[Error.WRONG_COLUMN.ordinal()]);
        }
    }

    @Test
    public void testGivenNullErrorWhenWritelnThenNothingIsPrinted() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            this.errorView.writeln(Error.NULL);

            verify(this.console, never()).writeln(anyString());
        }
    }

}