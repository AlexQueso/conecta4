package conecta4;

import conecta4.views.console.ConsoleViewFactory;

public class ConsoleConnect4 extends Connect4{
    @Override
    protected ConsoleViewFactory createViewFactory() {
        return new ConsoleViewFactory();
    }

    public static void main(String[] args) {
        new ConsoleConnect4().play();
    }
}
