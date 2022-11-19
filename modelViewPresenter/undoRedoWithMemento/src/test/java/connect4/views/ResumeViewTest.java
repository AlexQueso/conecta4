package connect4.views;

import connect4.controllers.ResumeController;
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
    @Mock
    private ResumeController resumeController;
    private ResumeView resumeView;

    @BeforeEach
    public void beforeEach() {
        this.resumeView = new ResumeView();
    }

    @Test
    public void testGivenResumeViewWhenAffirmativeAnswerThenGameReset() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn("y");
            doNothing().when(this.resumeController).reset();

            this.resumeView.interact(this.resumeController);

            verify(resumeController).reset();
            verify(resumeController, never()).nextState();
        }
    }

    @Test
    public void testGivenResumeViewWhenNegativeAnswerThenGameOver() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(anyString())).thenReturn("n");
            doNothing().when(this.resumeController).nextState();

            this.resumeView.interact(this.resumeController);

            verify(resumeController, never()).reset();
            verify(resumeController).nextState();
        }
    }
}