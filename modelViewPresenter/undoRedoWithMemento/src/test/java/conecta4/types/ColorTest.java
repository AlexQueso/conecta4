package conecta4.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ColorTest {

    @Test
    public void testGivenNewColorWhenGetThenReturn() {
        assertThat(Color.get(0), is(Color.R));
        assertThat(Color.get(1), is(Color.Y));
    }

    @Test
    public void testGivenNewColorWhenGetThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> Color.get(2));
        Assertions.assertThrows(AssertionError.class, () -> Color.get(-1));
    }

    @Test
    public void testGivenColorWhenIsNullThenReturn() {
        assertThat(Color.R.isNull(), is(false));
        assertThat(Color.Y.isNull(), is(false));
        assertThat(Color.NULL.isNull(), is(true));
    }

}
