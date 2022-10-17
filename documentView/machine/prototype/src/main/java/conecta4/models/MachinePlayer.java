package conecta4.models;

import conecta4.types.Color;
import conecta4.types.PlayerType;

import java.util.Random;

public class MachinePlayer extends Player{

    public MachinePlayer(Color color, Board board) {
        super(color, board);
        this.type = PlayerType.MACHINE;
    }

    public int getRandomColumn(){
        Random rn = new Random();
        return rn.nextInt(7);
    }
}
