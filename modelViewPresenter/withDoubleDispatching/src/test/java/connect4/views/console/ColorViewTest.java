package connect4.views.console;

import connect4.types.Color;
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
class ColorViewTest {

    @Mock
    private Console console;
    private ColorView colorView;

    @BeforeEach
    public void beforeEach(){
        this.colorView = new ColorView();
    }

    @Test
    public void givenColorViewWhenWriteNULLThenPrintEmptySpace(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorView.write(Color.NULL);
            verify(this.console).write(" ");
        }
    }

    @Test
    public void givenColorViewWhenWriteRedOrYellowThenPrintROrY(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorView.write(Color.R);
            this.colorView.write(Color.Y);
            verify(this.console).write("R");
            verify(this.console).write("Y");
        }
    }

}