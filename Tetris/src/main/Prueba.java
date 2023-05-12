package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prueba{
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
                g.setColor(Color.WHITE);
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
                g.setColor(Color.YELLOW);
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
                        if (pixelX > 10) {
                            pixelX -= 20;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (pixelX + pixelWidth < gamePanelWidth - 10) {
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
}
