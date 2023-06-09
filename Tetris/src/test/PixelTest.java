package test;

import main.Pixel;
import org.junit.Test;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import static org.junit.Assert.*;

public class PixelTest {

    @Test
    public void getPosX() {
        int expectedPosX = 10;
        Pixel pixel = new Pixel(expectedPosX, 20, Color.RED);

        int actualPosX = pixel.getPosX();
        assertEquals(expectedPosX, actualPosX);
    }

    @Test
    public void getPosY() {
        int expectedPosY = 20;
        Pixel pixel = new Pixel(10, expectedPosY, Color.RED);

        int actualPosY = pixel.getPosY();
        assertEquals(expectedPosY, actualPosY);
    }

    @Test
    public void setPosX() {
        int expectedPosX = 100;
        Pixel pixel = new Pixel(expectedPosX, 10, Color.RED);
        pixel.setPosX(expectedPosX);

        int actualPosX = pixel.getPosX();
        assertEquals(expectedPosX, actualPosX);
    }

    @Test
    public void setPosY() {
        int expectedPosY = 200;
        Pixel pixel = new Pixel(10, 10, Color.RED);
        pixel.setPosY(expectedPosY);

        int actualPosY = pixel.getPosY();
        assertEquals(expectedPosY, actualPosY);
    }

    @Test
    public void getColor() {
        Color expectedColor = Color.RED;
        Pixel pixel = new Pixel(10, 20, expectedColor);

        Color actualColor = pixel.getColor();
        assertEquals(expectedColor, actualColor);
    }

    @Test
    public void getPixel() {
        Pixel pixel = new Pixel(10, 20, Color.RED);

        JPanel actualPanel = pixel.getPixel();
        assertNotNull(actualPanel);
        assertEquals(10, pixel.getPosX());
        assertEquals(20, pixel.getPosY());
        assertEquals(Color.red, pixel.getColor());

    }

}
