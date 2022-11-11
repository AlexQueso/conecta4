package connect4.controllers;

import conecta4.controllers.Controller;
import conecta4.controllers.PlayController;
import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.types.Color;
import conecta4.types.Error;
import conecta4.views.console.CoordinateView;
import conecta4.views.console.ErrorView;
import conecta4.views.console.PlayerView;
import connect4.models.GameBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest extends ControllerTest {

    @Mock
    private PlayerView playerView;

    @Mock
    private CoordinateView coordinateView;

    @Mock
    private ErrorView errorView;

    private Game game;

    @Override
    protected Controller getController(String... rows) {
        this.game = spy(new GameBuilder().rows(rows).turn(Color.Y).build());
        return new PlayController(this.game, this.viewFactory);
    }

    @Test
    public void testGivenPlayControllerWinnerGameWhenControlThenIsWinnerAndPutToken() {
        this.setUpMocks();
        this.controller = this.getController(
                "       ",
                "       ",
                "       ",
                "       ",
                "R      ",
                "YYYYY  ");

        int column = 5;
        when(this.coordinateView.read(any())).thenReturn(column);
        ((PlayController) this.controller).control();
        verify(this.game).putToken(column);
        verify(this.playerView).writeWinner(Color.Y);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenPutTokenError() {
        this.setUpMocks();
        this.controller = this.getController(
                "Y      ",
                "R      ",
                "Y      ",
                "R      ",
                "Y      ",
                "RYYY   ");

        int column = 0;
        when(this.coordinateView.read(any())).thenReturn(column, 4);
        ((PlayController) this.controller).control();
        verify(this.errorView).writeln(Error.FULL);
    }

    @Test
    public void testGivenPlayControllerTieGameWhenControlThenIsTie() {
        this.setUpMocks();
        this.controller = this.getController(
                "RRYRY R",
                "YYRYRRY",
                "RRRYYYR",
                "YYRYYRY",
                "RRYRRRY",
                "YRRYYRY");

        int column = 5;
        when(this.coordinateView.read(any())).thenReturn(column);
        ((PlayController) this.controller).control();
        verify(this.game).putToken(column);
        verify(this.playerView).writeTie();
    }

    private void setUpMocks() {
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        when(this.viewFactory.createPlayerView()).thenReturn(this.playerView);
        when(this.viewFactory.createCoordinateView()).thenReturn(this.coordinateView);
        when(this.viewFactory.createErrorView()).thenReturn(this.errorView);
    }

}
