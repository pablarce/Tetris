package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import main.Shapes.*;


public class Prueba{
    private final JPanel figurePanel;
    private final int pixelWidth = 32;
    private final int pixelHeight = 32;

    public Prueba() {
        Figure actualFigure = generateFigure();
        InitialFrame MyInitialFrame = new InitialFrame();
        JFrame frame = MyInitialFrame.getFrame();
        GamePanel MyGamePanel = new GamePanel();
        JPanel gamePanel = MyGamePanel.getGamePanel();
        final int bottomLimit = gamePanel.getHeight();
        final int rightLimit = gamePanel.getWidth();
        final boolean[] isStopped = {false};
        frame.add(gamePanel);

        figurePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(actualFigure.getColor());
                g.fillRect(actualFigure.getPosX(), actualFigure.getPosY(), pixelWidth, pixelHeight);
                g.setColor(Color.BLACK);
                g.drawRect(actualFigure.getPosX(), actualFigure.getPosY(), pixelWidth, pixelHeight);
            }
        };
        figurePanel.setOpaque(false);
        figurePanel.setBounds(0, 0, gamePanel.getWidth(), gamePanel.getHeight());
        gamePanel.add(figurePanel);


        //// This is the code that moves the figure
        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    if (actualFigure.getPosY() + pixelHeight < bottomLimit) {
                        actualFigure.setPosY(actualFigure.getPosY() + 32);
                    }
                } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    if (actualFigure.getPosX() > 0) {
                        actualFigure.setPosX(actualFigure.getPosX() - 32);
                    }
                } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    if (actualFigure.getPosX() + pixelWidth < rightLimit) {
                        actualFigure.setPosX(actualFigure.getPosX() + 32);
                    }
                }
                figurePanel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        Timer goingDownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (actualFigure.getPosY() + pixelHeight < bottomLimit) {
                    actualFigure.setPosY(actualFigure.getPosY() + 32);
                }
                gamePanel.repaint();
            }
        });
        goingDownTimer.start();
        Timer collisionTimer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (actualFigure.getPosY() + pixelHeight == bottomLimit) {
                    isStopped[0] = true;
                    goingDownTimer.stop();
                }
            }
        });

        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        frame.setVisible(true);

    }



    //// This method is used to generate a random figure
    public static Figure generateFigure(){
        Random random = new Random();
        int shape = random.nextInt(7);
        String color = getRandomColor();
        int posX = getRandomX();
        Figure newFigure;
        switch(shape){
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
        // random number from 64 to 288, only multiples of 32
        Random random = new Random();
        int posX = random.nextInt(8);
        posX *= 32;
        posX += 32;
        return posX;
    }
}
