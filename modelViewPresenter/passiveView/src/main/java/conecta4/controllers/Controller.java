package conecta4.controllers;

import conecta4.models.Board;
import conecta4.models.Coordinate;
import conecta4.models.Game;
import conecta4.views.BoardView;
import conecta4.views.ViewFactory;

public abstract class Controller {

    protected Game game;
    protected ViewFactory viewFactory;

    public Controller (Game game, ViewFactory viewFactory) {
        this.game = game;
        this.viewFactory = viewFactory;
    }

    public void writeBoard() {
        BoardView boardView = this.viewFactory.createBoardView();
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                boardView.set(new Coordinate(i, j), this.game.getColor(new Coordinate(i, j)));
            }
        }
        boardView.print();
    }
}
