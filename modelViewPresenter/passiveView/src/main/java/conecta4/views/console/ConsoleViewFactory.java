package conecta4.views.console;

import conecta4.views.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {
    @Override
    public BoardView createBoardView() {
        return new BoardView();
    }

    @Override
    public CoordinateView createCoordinateView() {
        return new CoordinateView();
    }

    @Override
    public PlayerView createPlayerView() {
        return new PlayerView();
    }

    @Override
    public ResumeView createResumeView() {
        return new ResumeView();
    }

    @Override
    public StartView createStartView() {
        return new StartView();
    }

    @Override
    public ErrorView createErrorView() {
        return new ErrorView();
    }
}
