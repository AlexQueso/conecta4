package conecta4.models;

import conecta4.types.Color;

import java.util.Random;

public class MachinePlayer extends Player{

    @Override
    public void accept(PlayerVisitor playerVisitor) {
        playerVisitor.visit(this);
    }

    public MachinePlayer(Color color, Board board) {
        super(color, board);
    }

    public int getRandomColumn(){
        Random rn = new Random();
        return rn.nextInt(7);
    }
}
