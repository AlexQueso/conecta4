package connect4.views.console;

import connect4.controllers.PlayController;
import connect4.models.GameBuilder;
import connect4.models.State;
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
class BoardViewTest {
    @Mock
    private Console console;
    private BoardView boardView;
    private PlayController playController;

    @BeforeEach
    public void beforeEach() {
        this.boardView = new BoardView();
    }

    @Test
    public void givenBoardViewWhenPrintThenBoardIsPrinted() {
        try (MockedStatic<Console> mockedConsole = mockStatic(Console.class)) {
            mockedConsole.when(Console::getInstance).thenReturn(this.console);
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            this.playController = new PlayController(new GameBuilder().rows(middleOfGameRows()).build(), new State());

            this.boardView.print(this.playController);

            verify(this.console, atLeast(0)).writeln(argumentCaptor.capture());
            verify(this.console, atLeast(0)).write(argumentCaptor.capture());
            List<String> argumentCaptorValues = argumentCaptor.getAllValues();
            assertThat(formatArgumentList(argumentCaptorValues), is(expectedMiddleOfGameOutput()));
        }
    }

    private String expectedMiddleOfGameOutput() {
        return Arrays.toString(new String[]{
                "---------------",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " | R | Y |   |   |   |   |   | ",
                "---------------"}
        ).replaceAll(", ", "");
    }

    private String[] middleOfGameRows() {
        return new String[]{
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "RY     ",
        };
    }

    private String formatArgumentList(List<String> arguments) {
        arguments.add(arguments.size() - 1, arguments.remove(1));
        return arguments.toString().replaceAll(", ", "");
    }

}