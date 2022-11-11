package connect4.views.console;

import conecta4.types.Error;
import conecta4.views.ErrorView;
import conecta4.views.console.CoordinateView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoordinateViewTest {

    @Mock
    private Console console;
    private CoordinateView coordinateView;

    private static final int BOARD_COLUMNS = 7;

    @BeforeEach
    public void beforeEach() {
        this.coordinateView = new CoordinateView();
    }

    @Test
    public void testGivenCoordinateWhenReadThenCorrect() {
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(BOARD_COLUMNS);

            int column = this.coordinateView.read("");

            assertThat(column, is(BOARD_COLUMNS-1));
        }
    }

    @Test
    public void testGivenCoordinateWhenReadThenIncorrect() {
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt(anyString())).thenReturn(BOARD_COLUMNS + 1, BOARD_COLUMNS);

            int column = this.coordinateView.read("");

            verify(this.console).writeln(ErrorView.MESSAGES[Error.WRONG_COLUMN.ordinal()]);
        }
    }

}