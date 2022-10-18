package conecta4.views.graphics;

import conecta4.models.Game;
import conecta4.types.Error;
import conecta4.views.ErrorView;
import conecta4.views.Message;

import javax.swing.*;
import java.awt.*;

class PlayView extends JFrame {
    private CoordinatePutView coordinatePutView;
    private Game game;
    private GameView gameView;

    PlayView(Game game) {
        super(Message.TITLE.toString());
        assert game != null;

        this.game = game;
        this.getContentPane().setLayout(new GridBagLayout());
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameView = new GameView(game);
        this.getContentPane().add(this.gameView);
        this.gameView.write();
        this.setVisible(true);
        this.coordinatePutView = new CoordinatePutView();
        this.getContentPane().add(this.coordinatePutView, new Constraints(0, 1, 3, 1));
        this.gameView.removeAll();
        this.setVisible(true);
    }

    void interact() {
        this.gameView.removeAll();
        this.gameView.write();
        this.setVisible(true);
        do {
            this.put();
            this.game.next();
            this.gameView.write();
            this.setVisible(true);
        } while (!this.game.isGameOver());
        if(this.game.isTie()){
            this.getContentPane().add(new JLabel(Message.TIE.toString()), new Constraints(0, 1, 4, 1));
        } else {
            this.getContentPane().add(new JLabel(this.game.getActivePlayer().toString() + Message.PLAYER_WIN),
                    new Constraints(0, 1, 4, 1));
        }
        this.setVisible(true);
    }

    private void put() {
        int column;
        boolean error;
        do {
            this.setVisible(true);
            do {
                column = this.coordinatePutView.getColumn();
            } while (column == -1);
            error = this.game.isColumnFull(column);
            if (error) {
                JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[Error.FULL.ordinal()], "ERROR",
                        JOptionPane.WARNING_MESSAGE);
                this.coordinatePutView.resetCoordinate();
            }
        } while (error);
        this.game.putToken(column);
        this.coordinatePutView.resetCoordinate();
    }

}
