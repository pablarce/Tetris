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
                g.fillRect(getPosX(), getPosY(), 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(getPosX(), getPosY(), 30, 30);
            }
        };
        pixel.setOpaque(false);
        pixel.setBounds(0, 0, 360, 660);
    }
    public void setPosX(int posX){
        this.posX = posX;
    }
    public void setPosY(int posY){
        this.posY = posY;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public Color getColor(){
        return color;
    }
    public JPanel getPixel() {
        return pixel;
    }
}
