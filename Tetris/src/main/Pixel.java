//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package main;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Pixel {
    private int posX;
    private int posY;
    private Color color;
    private JPanel pixel;

    public Pixel(final int posX, final int posY, final Color color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.pixel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(color);
                g.fillRect(posX, posY, 32, 32);
                g.setColor(Color.BLACK);
                g.drawRect(posX, posY, 32, 32);
            }
        };
        this.pixel.setOpaque(false);
        this.pixel.setBounds(0, 0, 320, 640);
    }

    public JPanel getPixel() {
        return this.pixel;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
