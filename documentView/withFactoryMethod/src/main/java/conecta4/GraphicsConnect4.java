package conecta4;

import conecta4.models.Game;
import conecta4.views.graphics.GraphicsView;

public class GraphicsConnect4 extends Connect4 {

    @Override
    protected GraphicsView createView(Game game) {
        return new GraphicsView(game);
    }

    public static void main(String[] args) {
        new GraphicsConnect4().play();
    }

}
