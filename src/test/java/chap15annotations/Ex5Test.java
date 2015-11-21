package chap15annotations;

import helpers.FileHelpers;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Ex5Test {

    @Test
    public void callScalaMethodInNormalConditions() {
        String content = "" +
                "Empty your mind, be formless. Shapeless, like water. If you put water into a cup, " +
                "it becomes the cup. You put water into a bottle and it becomes the bottle. You put " +
                "it in a teapot, it becomes the teapot. Now, water can flow or it can crash. Be water, " +
                "my friend.";

        File file = FileHelpers.createTempFile(content);

        try {
            assertEquals(content, Ex5.lines(file));
        } catch (IOException e) {
            fail("Caught IOException: " + e.getMessage());
        }

    }

    @Test(expected = IOException.class)
    public void callScalaMethodThrowingAnException() throws IOException {
        Ex5.lines(new File("Idontreallyexist.txt"));
    }
}
