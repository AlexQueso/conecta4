package conecta4;

import conecta4.views.graphics.GraphicsViewFactory;

public class GraphicsConnect4 extends Connect4{
    @Override
    protected GraphicsViewFactory createViewFactory() {
        return new GraphicsViewFactory();
    }

    public static void main(String[] args) {
        new GraphicsConnect4().play();
    }
}
