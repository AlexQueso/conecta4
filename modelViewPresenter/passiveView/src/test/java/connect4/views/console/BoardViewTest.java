package connect4.views.console;

import conecta4.models.Board;
import conecta4.models.Coordinate;
import conecta4.types.Color;
import conecta4.views.console.BoardView;
import connect4.models.GameBuilder;
import org.junit.jupiter.api.Assertions;
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

    @BeforeEach
    public void beforeEach() {
        this.boardView = new BoardView();
    }

    @Test
    public void testGivenBoardViewWhenSetTooManyTimesThenAssertionError() {
        for(int i = 0; i < Board.ROWS; i++) {
            for(int j = 0; j<Board.COLUMNS; j++){
                this.boardView.set(new Coordinate(i, j), Color.NULL);
            }
        }

        Assertions.assertThrows(AssertionError.class, () -> this.boardView.set(new Coordinate(0,0), Color.NULL));
    }

    @Test
    public void testGivenBoardViewWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

            this.addColors();
            this.boardView.print();

            verify(this.console, atLeast(0)).writeln(argumentCaptor.capture());
            verify(this.console, atLeast(0)).write(argumentCaptor.capture());
            List<String> argumentCaptorValues = argumentCaptor.getAllValues();
            assertThat(this.formatArgumentList(argumentCaptorValues), is(expectedMiddleOfGameOutput()));
        }
    }

    private void addColors() {
        this.boardView.set(new Coordinate(0, 0), Color.R);
        this.boardView.set(new Coordinate(0, 1), Color.Y);

        for(int i = 0; i<Board.ROWS; i++){
            for(int j = 0; j<Board.COLUMNS; j++){
                if(i != 0 || j != 0 && j != 1) {
                    this.boardView.set(new Coordinate(i, j), Color.NULL);
                }
            }
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

    private String formatArgumentList(List<String> arguments) {
        arguments.add(arguments.size() - 1, arguments.remove(1));
        return arguments.toString().replaceAll(", ", "");
    }

}