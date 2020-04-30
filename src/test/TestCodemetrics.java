package test;

import main.Main;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCodemetrics {
    @Test
    public void testInputJar() {
        Main test = new Main();
        assertTrue(test.inputJar());
    }
}
