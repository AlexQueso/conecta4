package conecta4.models;

import conecta4.types.Color;
import conecta4.types.Direction;
import conecta4.views.Message;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final Color color;
    private final Board board;

    private final List<Goal> goals;

    public Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
        goals = new ArrayList<>();
    }

    public Color getColor() {
        return color;
    }

    public void addTokenToGoals(Coordinate coordinate) {
        List<Goal> surroundingGoals = board.surroundingGoals(coordinate, color);
        for (Goal surroundingGoal : surroundingGoals) {
            if (surroundingGoal.getCoordinates().size() == 2) {
                addTripleMatchToGoals(surroundingGoal, coordinate);
            } else {
                addDoubleMatchToGoals(surroundingGoal, coordinate);
            }
        }
    }

    private void addTripleMatchToGoals(Goal surroundingGoal, Coordinate coordinate) {
        List<Goal> directionGoals = filterGoalsByDirection(surroundingGoal.getDirection());
        if (directionGoals.isEmpty()) {
            ArrayList<Coordinate> tripleMatch = new ArrayList<>(surroundingGoal.getCoordinates());
            tripleMatch.add(coordinate);
            goals.add(new Goal(surroundingGoal.getDirection(), tripleMatch));
        } else {
            boolean extendedExistingGoal = false;
            for (Goal directionGoal : directionGoals) {
                if (directionGoal.containsCoordinate(surroundingGoal.getFirstCoordinate())) {
                    directionGoal.addCoordinate(coordinate);
                    directionGoal.addCoordinate(surroundingGoal.getCoordinates().get(1));
                    extendedExistingGoal = true;
                } else if (directionGoal.containsCoordinate(surroundingGoal.getCoordinates().get(1))) {
                    directionGoal.addCoordinate(coordinate);
                    directionGoal.addCoordinate(surroundingGoal.getFirstCoordinate());
                    extendedExistingGoal = true;
                }
            }
            if (!extendedExistingGoal) {
                ArrayList<Coordinate> tripleMatch = new ArrayList<>(surroundingGoal.getCoordinates());
                tripleMatch.add(coordinate);
                goals.add(new Goal(surroundingGoal.getDirection(), tripleMatch));
            }
        }
    }

    private void addDoubleMatchToGoals(Goal surroundingGoal, Coordinate coordinate) {
        Coordinate matchingCoordinate = surroundingGoal.getFirstCoordinate();
        List<Goal> directionGoals = filterGoalsByDirection(surroundingGoal.getDirection());
        if (directionGoals.isEmpty()) {
            ArrayList<Coordinate> doubleMatch = new ArrayList<>(surroundingGoal.getCoordinates());
            doubleMatch.add(coordinate);
            goals.add(new Goal(surroundingGoal.getDirection(), doubleMatch));
        } else {
            boolean extendedExistingGoal = false;
            for (Goal directionGoal : directionGoals) {
                if (directionGoal.containsCoordinate(matchingCoordinate)) {
                    directionGoal.addCoordinate(coordinate);
                    extendedExistingGoal = true;
                }
            }
            if (!extendedExistingGoal) {
                ArrayList<Coordinate> doubleMatch = new ArrayList<>(surroundingGoal.getCoordinates());
                doubleMatch.add(coordinate);
                goals.add(new Goal(surroundingGoal.getDirection(), doubleMatch));
            }
        }
    }

    private List<Goal> filterGoalsByDirection(Direction direction) {
        return goals.stream().filter(goal -> goal.getDirection() == direction).toList();
    }

    public boolean isConecta4() {
        for (Goal goal : goals) {
            if (goal.isConecta4()) {
                return true;
            }
        }
        return false;
    }
}
