package utils.views;

import conecta4.types.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.models.Command;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuTest {

    private static final String ACTIVE_COMMAND_TITLE = "active command";
    @Mock
    private Console console;
    private Menu menu;

    @BeforeEach
    public void beforeEach() {
        this.menu = new Menu() {};
    }


    @Test
    public void testGivenEmptyMenuWithoutCommandsThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> this.menu.execute());
    }

    @Test
    public void testGivenEmptyMenuWithoutActiveCommandsThenAssertionError() {
        this.menu.addCommand(this.inactiveCommand());
        Assertions.assertThrows(AssertionError.class, () -> this.menu.execute());
    }

    @Test
    public void testGivenMenuWithActiveCommandsWhenExecuteThenPrintAndRead() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readInt("")).thenReturn(1);
            this.menu.addCommand(this.inactiveCommand());
            Command activeCommand = spy(this.activeCommand());
            this.menu.addCommand(activeCommand);

            this.menu.execute();

            verify(this.console).writeln();
            verify(this.console).writeln(Message.MENU_HEADER.toString());
            verify(this.console).writeln("1) " + MenuTest.ACTIVE_COMMAND_TITLE);
            verify(activeCommand).execute();
        }
    }

    private Command inactiveCommand() {
        return new Command("Inactive") {
            @Override
            public boolean isActive() {
                return false;
            }

            @Override
            public void execute() {
            }
        };
    }

    private Command activeCommand() {
        return new Command(ACTIVE_COMMAND_TITLE) {
            @Override
            public boolean isActive() {
                return true;
            }

            @Override
            public void execute() {
            }
        };
    }

}