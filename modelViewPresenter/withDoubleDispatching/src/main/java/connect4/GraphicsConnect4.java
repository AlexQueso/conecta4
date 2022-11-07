package connect4;

import connect4.views.graphics.GraphicsView;

public class GraphicsConnect4 extends Connect4{
    @Override
    protected GraphicsView createView(){
        return new GraphicsView();
    }

    public static void main(String[] args) {
        new GraphicsConnect4().play();
    }
}
