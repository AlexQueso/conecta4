package connect4.views;

import connect4.controllers.PlayController;
import connect4.types.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UndoCommandTest {

    @Mock
    private PlayController playController;

    private UndoCommand undoCommand;

    @BeforeEach
    public void beforeEach(){
        this.undoCommand = new UndoCommand(playController);
    }

    @Test
    public void testGivenUndoCommandWhenExecuteThenUndo() {
        when(this.playController.getColor(any())).thenReturn(Color.R);
        this.undoCommand.execute();
        verify(this.playController).undo();
    }

}