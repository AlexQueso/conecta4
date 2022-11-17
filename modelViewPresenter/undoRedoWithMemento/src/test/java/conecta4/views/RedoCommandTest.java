package conecta4.views;

import conecta4.controllers.PlayController;
import conecta4.types.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RedoCommandTest {

    @Mock
    private PlayController playController;

    private RedoCommand redo;

    @BeforeEach
    public void beforeEach(){
        this.redo = new RedoCommand(playController);
    }

    @Test
    public void testGivenUndoCommandWhenExecuteThenUndo() {
        when(this.playController.getColor(any())).thenReturn(Color.R);
        this.redo.execute();
        verify(this.playController).redo();
    }
}