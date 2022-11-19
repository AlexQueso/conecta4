package conecta4.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class RegistryTest {

    private Registry registry;
    private Game game;

    @BeforeEach
    public void beforeEach(){
        this.game = new Game();
        this.registry = new Registry(game);
    }

    @Test
    public void testGivenRegistryWhenResetThenIsNotUndoableNorRedoable(){
        this.registry.reset();

        assertThat(this.registry.isUndoable(), is(false));
        assertThat(this.registry.isRedoable(), is(false));
    }

    @Test
    public void testGivenRegistryWhenRegisterThenIsUndoable(){
        this.game.putToken(0);
        this.registry.register();

        assertThat(this.registry.isUndoable(), is(true));
    }

    @Test
    public void testGivenRegistryWhenRegisterIsNotRedoable(){
        this.game.putToken(0);
        this.registry.register();
        this.registry.undo();
        this.game.putToken(1);
        this.registry.register();

        assertThat(this.registry.isRedoable(), is(false));
    }

    @Test
    public void testGivenRegistryWhenRedoThenIsUndoable(){
        this.game.putToken(0);
        this.registry.register();
        this.registry.undo();
        this.registry.redo();

        assertThat(this.registry.isUndoable(), is(true));
    }

    @Test
    public void testGivenRegistryWhenUndoThenIsRedoable(){
        this.game.putToken(0);
        this.registry.register();
        this.registry.undo();

        assertThat(this.registry.isRedoable(), is(true));
    }

    @Test
    public void testGivenRegistryWhenIsNotRedoableThenAssertionError(){
        Assertions.assertThrows(AssertionError.class, () -> this.registry.redo());
    }

    @Test
    public void testGivenRegistryWhenIsNotUndoableThenAssertionError(){
        Assertions.assertThrows(AssertionError.class, () -> this.registry.undo());
    }

}