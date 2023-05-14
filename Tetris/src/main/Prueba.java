package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import main.Shapes.*;

public class Prueba{
    private ArrayList<Figure> figures = new ArrayList<>();
    private JFrame frame;
    private JPanel figurePanel;
    private JPanel gamePanel;
    private int gamePanelWidth = 500;
    private int gamePanelHeight = 600;
    private int pixelX = 50;
    private int pixelY = 10;
    private int pixelWidth = 20;
    private int pixelHeight = 20;
    private int bottomLimit = gamePanelHeight - pixelHeight - 5;

    public Prueba() {
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
                Color selectedColor = new Color(0x00FF00);
                g.setColor(selectedColor);
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
                switch (key) {
                    case KeyEvent.VK_DOWN:
                        if (pixelY + pixelHeight < bottomLimit) {
                            pixelY += 20;
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (pixelX > 10 && pixelY + pixelHeight < bottomLimit) {
                            pixelX -= 20;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (pixelX + pixelWidth < gamePanelWidth - 10 && pixelY + pixelHeight < bottomLimit) {
                            pixelX += 20;
                        }
                        break;
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

    public static Figure generateFigure(){
        Random random = new Random();
        int figure = random.nextInt(7);
        switch (figure) {
            case 0:
                return new Square("red", 0, 0);
            case 1:
                return new Tshape("blue", 10,10);
            case 2:
                return new Straigth("green", 20,20);
            case 3:
                return new Lshape("yellow", 30,30);
            case 4:
                return new Sshape("orange", 40,40);
            case 5:
                return new Zshape("purple", 50,50);
            case 6:
                return new Jshape("pink", 60,60);
            default:
                return null;
        }
    }
}
