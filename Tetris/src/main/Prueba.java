package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import main.Shapes.*;

public class Prueba{
    private JFrame frame;
    private JPanel figurePanel;
    private JPanel gamePanel;
    private int gamePanelWidth = 500;
    private int gamePanelHeight = 600;
    private int pixelX;
    private int pixelY;
    private int pixelWidth = 20;
    private int pixelHeight = 20;
    private int bottomLimit = gamePanelHeight - pixelHeight - 5;

    public Prueba() {
        Figure figure = generateFigure();
        pixelX = figure.getPosX();
        pixelY = figure.getPosY();
        frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(520, 640));

        gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.white);
                g.fillRect(0, 0, gamePanelWidth, gamePanelHeight);
                g.setColor(Color.BLACK);
                g.drawRect(0, 0, gamePanelWidth, gamePanelHeight);
            }
        };
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
        figurePanel.setBounds(0, 0, gamePanelWidth, gamePanelHeight);
        gamePanel.add(figurePanel);

        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    if (pixelY + pixelHeight < bottomLimit) {
                        pixelY += 20;
                    }
                } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    if (pixelX > 10 && pixelY + pixelHeight < bottomLimit) {
                        pixelX -= 20;
                    }
                } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    if (pixelX + pixelWidth < gamePanelWidth - 10 && pixelY + pixelHeight < bottomLimit) {
                        pixelX += 20;
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
                    pixelY += 20;
                }
                gamePanel.repaint();
            }
        });
        timer.start();

        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        frame.setVisible(true);
    }

    public static Figure generateFigure(){ //Does nothing yet, on progress to be implemented. The idea is to generate a random figure.
        Random random = new Random(); // that will be added to an array of figures. Then, the figure will be drawn on the gamePanel.
        int figure = random.nextInt(6);
        String color = getRandomColor();
        int posX = getRandomX();
        Figure newFigure;
        switch(figure){
            case 1:
                newFigure = new Square(color, posX, 10);
                break;
            case 2:
                newFigure = new Tshape(color, posX, 10);
                break;
            case 3:
                newFigure = new Straigth(color, posX, 10);
                break;
            case 4:
                newFigure = new Lshape(color, posX, 10);
                break;
            case 5:
                newFigure = new Sshape(color, posX, 10);
                break;
            case 6:
                newFigure = new Zshape(color, posX, 10);
                break;
            default:
                newFigure = new Jshape(color, posX, 10);
                break;
        }
        return newFigure;
    }
    public static String getRandomColor(){
        Random random = new Random();
        int color = random.nextInt(6);
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
        // random number from 100 to 400, only multiples of 20
        Random random = new Random();
        int posX = random.nextInt(16);
        posX *= 20;
        posX += 100;
        return posX;
    }
}
