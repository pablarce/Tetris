package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prueba {
    private JFrame frame;
    private JPanel panel;
    private int squareX = 50;
    private int squareY = 50;

    public Prueba() {
        frame = new JFrame("Mi ventana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.YELLOW);
                g.fillRect(squareX, squareY, 20, 20);
                g.setColor(Color.BLACK);
                g.drawRect(squareX, squareY, 20, 20);
            }
        };
        frame.add(panel);
        panel.setFocusable(true);
        panel.requestFocusInWindow();

        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int panelHeight = panel.getHeight();
                int squareHeight = 20;
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_DOWN :
                        if (squareY + squareHeight < panelHeight)
                            {squareY += 20;}
                        break;
                    case KeyEvent.VK_LEFT:
                        squareX -= 20;
                        break;
                    case KeyEvent.VK_RIGHT:
                        squareX += 20;
                        break;
                }
                panel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int panelHeight = panel.getHeight();
                int squareHeight = 20;
                if (squareY + squareHeight < panelHeight) {
                    squareY += 20;
                }
                panel.repaint();
            }
        });
        timer.start();

        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
