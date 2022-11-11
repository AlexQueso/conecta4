package connect4.controllers;

import conecta4.controllers.Controller;
import conecta4.models.Coordinate;
import conecta4.types.Color;
import conecta4.views.BoardView;
import conecta4.views.ViewFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class ControllerTest {

    @Mock
    protected BoardView boardView;

    @Mock
    protected ViewFactory viewFactory;

    protected Controller controller;

    @Test
    public void testGivenControllerWhenWriteBoardThenCorrectColorsCaptured() {
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        this.controller = this.getController(
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "RY     ");
        this.controller.writeBoard();
        ArgumentCaptor<Color> argumentCaptor = ArgumentCaptor.forClass(Color.class);
        ArgumentCaptor<Coordinate> argumentCaptorCoordinate = ArgumentCaptor.forClass(Coordinate.class);
        verify(this.boardView, atLeastOnce()).set(argumentCaptorCoordinate.capture(), argumentCaptor.capture());
        String board =
                "RY     " +
                "       " +
                "       " +
                "       " +
                "       " +
                "       ";
        assertThat(argumentCaptor.getAllValues(), is(this.stringToColors(board)));
        verify(this.boardView).print();
    }

    protected abstract Controller getController(String... rows);

    protected List<Color> stringToColors(String board) {
        List<Color> colors = new ArrayList<>();
        for (char character : board.toCharArray()) {
            colors.add(this.charToColor(character));
        }
        return colors;
    }

    private Color charToColor(char character) {
        switch (character) {
            case 'R':
                return Color.R;
            case 'Y':
                return Color.Y;
            default:
                return Color.NULL;
        }
    }

}
