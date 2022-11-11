package connect4.views;

import conecta4.views.Message;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MessageTest {

    @Test
    public void testGivenNewMessageWhenToStringThenReturn() {
        assertThat(Message.ENTER_COLUMN_TO_PUT.toString(), is("Enter a column to put a token:"));
    }
}
