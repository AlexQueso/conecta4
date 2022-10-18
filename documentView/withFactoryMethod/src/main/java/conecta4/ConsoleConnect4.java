package conecta4;

import conecta4.models.Game;
import conecta4.views.console.ConsoleView;

public class ConsoleConnect4 extends Connect4{

    @Override
    protected ConsoleView createView(Game game) {
        return new ConsoleView(game);
    }

    public static void main(String[] args) {
        new ConsoleConnect4().play();
    }
}
