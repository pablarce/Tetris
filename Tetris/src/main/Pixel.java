package main;

import javax.swing.*;
import java.awt.*;

public class Pixel {
    private int posX;
    private int posY;
    private Color color;
    private JPanel pixel;

    public Pixel(int posX, int posY, Color color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color;

        pixel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(color);
                g.fillRect(posX, posY, 32, 32);
                g.setColor(Color.BLACK);
                g.drawRect(posX, posY, 32, 32);
            }
        };
        pixel.setOpaque(false);
        pixel.setBounds(0, 0, 320, 640);
    }
    public JPanel getPixel() {
        return pixel;
    }
}
