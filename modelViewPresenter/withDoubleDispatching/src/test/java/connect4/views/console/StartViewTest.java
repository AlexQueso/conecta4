package connect4.views.console;

import connect4.controllers.StartController;
import connect4.models.Game;
import connect4.models.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import utils.views.Console;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StartViewTest {

    @Mock
    private Console console;
    private StartView startView;
    private StartController startController;

    @BeforeEach
    void setUp() {
        this.startController = new StartController(new Game(), new State());
        this.startView = new StartView();
    }

    @Test
    void givenStartViewWhenInteractThenInteract() {
        try (MockedStatic<Console> mockedConsole = mockStatic(Console.class)) {
            mockedConsole.when(Console::getInstance).thenReturn(this.console);
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

            this.startView.interact(this.startController);

            verify(this.console, atLeast(0)).writeln(argumentCaptor.capture());
            verify(this.console, atLeast(0)).write(argumentCaptor.capture());
            List<String> argumentCaptorValues = argumentCaptor.getAllValues();
            assertThat(formatArgumentList(argumentCaptorValues), is(expectedStartOfGameOutput()));
        }
    }

    private String expectedStartOfGameOutput() {
        return Arrays.toString(new String[]{
                "--- CONECTA 4 ---",
                "---------------",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                " |   |   |   |   |   |   |   | ",
                "---------------"}
        ).replaceAll(", ", "");
    }

    private String formatArgumentList(List<String> arguments) {
        arguments.add(arguments.size() - 1, arguments.remove(1));
        return arguments.toString().replaceAll(", ", "");
    }

}