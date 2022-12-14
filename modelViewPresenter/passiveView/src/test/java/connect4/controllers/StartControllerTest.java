package connect4.controllers;

import conecta4.controllers.Controller;
import conecta4.controllers.StartController;
import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.types.Color;
import conecta4.views.console.StartView;
import connect4.models.GameBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StartControllerTest extends ControllerTest {
    @Mock
    private StartView startView;

    @Override
    protected Controller getController(String... rows) {
        return new StartController(new GameBuilder().rows(rows).build(), this.viewFactory);
    }

    @Test
    public void testGivenStartControllerWhenControlThenCorrectInteractions() {
        when(this.viewFactory.createStartView()).thenReturn(this.startView);
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        this.controller = new StartController(new Game(), this.viewFactory);
        ((StartController) this.controller).control();
        verify(this.startView).write();
        String board =
                        "       " +
                        "       " +
                        "       " +
                        "       " +
                        "       " +
                        "       ";

        ArgumentCaptor<Color> argumentCaptor = ArgumentCaptor.forClass(Color.class);
        ArgumentCaptor<Coordinate> argumentCaptorCoordinate = ArgumentCaptor.forClass(Coordinate.class);
        verify(this.boardView, atLeastOnce()).set(argumentCaptorCoordinate.capture(), argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues(), is(this.stringToColors(board)));
        verify(this.boardView).print();
    }

}
