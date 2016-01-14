package cli;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputTest {

    @Test
    public void testExecuteForEmptyParams() throws Exception {
        Input input = new Input(new String[]{});
        assertEquals(input.execute(), "");
    }

    @Test
    public void testExecuteForNull() throws Exception {
        Input input = new Input(null);
        assertEquals(input.execute(), "");
    }

    @Test
    public void testExecuteForWrongValues() throws Exception {
        Input input = new Input(new String[]{"", "", ""});
        assertEquals(input.execute(), "");
    }
}