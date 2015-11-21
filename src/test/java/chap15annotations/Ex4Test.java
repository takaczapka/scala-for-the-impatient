package chap15annotations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ex4Test {

    @Test
    public void callScalaMethodSum() {
        assertEquals(15, Ex4.sum(1, 2, 3, 4, 5));
    }
}

