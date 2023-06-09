package test;

import main.Pixel;
import org.junit.Test;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import static org.junit.Assert.*;

public class PixelTest {

    @Test
    public void testGetPosX() {
        int expectedPosX = 10;
        Pixel pixel = new Pixel(expectedPosX, 20, Color.RED);

        int actualPosX = pixel.getPosX();
        assertEquals(expectedPosX, actualPosX);
    }

    @Test
    public void testGetPosY() {
        int expectedPosY = 20;
        Pixel pixel = new Pixel(10, expectedPosY, Color.RED);

        int actualPosY = pixel.getPosY();
        assertEquals(expectedPosY, actualPosY);
    }

    @Test
    public void testGetColor() {
        Color expectedColor = Color.RED;
        Pixel pixel = new Pixel(10, 20, expectedColor);

        Color actualColor = pixel.getColor();
        assertEquals(expectedColor, actualColor);
    }

    @Test
    public void testGetPixel() {
        Pixel pixel = new Pixel(10, 20, Color.RED);

        JPanel actualPanel = pixel.getPixel();
        assertNotNull(actualPanel);
        assertTrue(actualPanel.isOpaque());
        assertEquals(0, actualPanel.getBounds().x);
        assertEquals(0, actualPanel.getBounds().y);
        assertEquals(360, actualPanel.getBounds().width);
        assertEquals(660, actualPanel.getBounds().height);

    }

    @Test
    public void testPaintComponent() {
        Pixel pixel = new Pixel(10, 20, Color.RED);
        JPanel panel = pixel.getPixel();

        Graphics graphics = panel.getGraphics();
        pixel.getPixel().paintComponents(graphics);
    }

}
