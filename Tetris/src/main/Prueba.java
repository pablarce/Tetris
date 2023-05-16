package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import main.Shapes.*;

public class Prueba{
    private JPanel figurePanel;
    private int gamePanelWidth = 320; // We could get this from gamePanel, but if we do that we get a not accurate value
    private int gamePanelHeight = 640; // and the program doesn't work if you call gamePanel.getHeight() / gamePanel.getWidth()
    private int pixelX;
    private int pixelY;
    private int pixelWidth = 32;
    private int pixelHeight = 32;
    private int bottomLimit = gamePanelHeight;

    public Prueba() {
        Figure figure = generateFigure();
        pixelX = figure.getPosX();
        pixelY = figure.getPosY();
        InitialFrame MyInitialFrame = new InitialFrame();
        JFrame frame = MyInitialFrame.getFrame();
        GamePanel MyGamePanel = new GamePanel();
        JPanel gamePanel = MyGamePanel.getGamePanel();
        gamePanel.setSize(gamePanelWidth, gamePanelHeight);
        gamePanel.setLayout(null);
        frame.add(gamePanel);

        figurePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(figure.getColor());
                g.fillRect(pixelX, pixelY, pixelWidth, pixelHeight);
                g.setColor(Color.BLACK);
                g.drawRect(pixelX, pixelY, pixelWidth, pixelHeight);
            }
        };
        figurePanel.setOpaque(false);
        figurePanel.setBounds(0, 0, gamePanel.getWidth(), gamePanel.getHeight());
        gamePanel.add(figurePanel);

        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    if (pixelY + pixelHeight < bottomLimit) {
                        pixelY += 32;
                    }
                } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    if (pixelX > 0) {
                        pixelX -= 32;
                    }
                } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    if (pixelX + pixelWidth < gamePanelWidth) {
                        pixelX += 32;
                    }
                }
                figurePanel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pixelY + pixelHeight < bottomLimit) {
                    pixelY += 32;
                }
                gamePanel.repaint();
            }
        });
        timer.start();

        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        frame.setVisible(true);

    }

    public static Figure generateFigure(){
        Random random = new Random();
        int figure = random.nextInt(7);
        String color = getRandomColor();
        int posX = getRandomX();
        Figure newFigure;
        switch(figure){
            case 1:
                newFigure = new Square(color, posX, 32);
                break;
            case 2:
                newFigure = new Tshape(color, posX, 32);
                break;
            case 3:
                newFigure = new Straigth(color, posX, 32);
                break;
            case 4:
                newFigure = new Lshape(color, posX, 32);
                break;
            case 5:
                newFigure = new Sshape(color, posX, 32);
                break;
            case 6:
                newFigure = new Zshape(color, posX, 32);
                break;
            default:
                newFigure = new Jshape(color, posX, 32);
                break;
        }
        return newFigure;
    }
    public static String getRandomColor(){
        Random random = new Random();
        int color = random.nextInt(7);
        String newColor;
        switch(color){
            case 1:
                newColor = "blue";
                break;
            case 2:
                newColor = "green";
                break;
            case 3:
                newColor = "yellow";
                break;
            case 4:
                newColor = "orange";
                break;
            case 5:
                newColor = "purple";
                break;
            case 6:
                newColor = "pink";
                break;
            default:
                newColor = "red";
                break;
        }
        return newColor;
    }
    public static int getRandomX(){
        // random number from 96 to 416, only multiples of 32
        Random random = new Random();
        int posX = random.nextInt(13);
        posX *= 32;
        return posX;
    }
}
