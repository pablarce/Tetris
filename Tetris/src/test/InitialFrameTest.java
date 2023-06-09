package test;

import main.InitialFrame;
import org.junit.Test;
import javax.swing.JFrame;
import java.awt.Dimension;
import static org.junit.Assert.*;

public class InitialFrameTest {

    @Test
    public void testGetFrame() {
        InitialFrame initialFrame = new InitialFrame();

        JFrame frame = initialFrame.getFrame();
        assertNotNull(frame);
        assertEquals("Tetris", frame.getTitle());
        assertTrue(frame.isVisible());

    }

    @Test
    public void testMinimumSize() {
        InitialFrame initialFrame = new InitialFrame();

        JFrame frame = initialFrame.getFrame();
        Dimension minimumSize = frame.getMinimumSize();
        assertNotNull(minimumSize);
        assertTrue(minimumSize.getWidth() >= 400);
        assertTrue(minimumSize.getHeight() >= 700);
    }


}
