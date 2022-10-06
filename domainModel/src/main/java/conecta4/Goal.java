package conecta4;

import java.util.ArrayList;
import java.util.List;

public class Goal {

    private final Direction direction;
    private List<Coordinate> coordinates;

    public Goal(Direction direction, List<Coordinate> coordinates) {
        this.direction = direction;
        this.coordinates = coordinates;
    }

    public void addCoordinate(Coordinate coordinate) {
        coordinates.add(coordinate);
    }

    public Direction getDirection(){
        return direction;
    }

    public List<Coordinate> getCoordinates(){
        return coordinates;
    }

    public boolean containsCoordinate(Coordinate coordinate){
        return coordinates.contains(coordinate);
    }

    public boolean isConecta4(){
        return coordinates.size() >= 4;
    }

    public Coordinate getFirstCoordinate(){
        assert !coordinates.isEmpty();
        return coordinates.get(0);
    }
}
