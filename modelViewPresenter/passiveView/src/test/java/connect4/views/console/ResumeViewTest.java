package connect4.views.console;

import conecta4.views.console.ResumeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ResumeViewTest {

    @Mock
    private Console console;
    private ResumeView resumeView;

    @BeforeEach
    public void beforeEach() {
        this.resumeView = new ResumeView();
    }

    @Test
    public void testGivenResumeViewWhenReadThenIsFalse() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn("n");
            assertThat(this.resumeView.read(), is(false));
        }
    }

    @Test
    public void testGivenResumeViewWhenReadThenIsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn("y");
            assertThat(this.resumeView.read(), is(true));
        }
    }
}