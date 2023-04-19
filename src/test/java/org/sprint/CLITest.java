package org.sprint;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CLITest {

    @Test
    public void testCLIMain() {
        String input = "10 5 15 3 7 13 20";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        CLI.main(new String[]{});
        String prompt = "Enter a series of numbers separated by spaces:" + System.lineSeparator();
        String expectedOutput = "{\"data\":10,\"left\":{\"data\":5,\"left\":{\"data\":3},\"right\":{\"data\":7}},\"right\":{\"data\":15,\"left\":{\"data\":13},\"right\":{\"data\":20}}}" + System.lineSeparator();
        assertEquals(prompt + expectedOutput,outContent.toString());

        System.setIn(System.in);
        System.setOut(originalOut);
    }


}
