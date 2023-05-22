package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private int[][] panelStatus = new int[22][12]; // Matriz de 22x12

    private final int gamePanelWidth = 360; // 12 * 30
    private final int gamePanelHeight = 660; // 22 * 30
    private final int cellWidth = 30;
    private final int cellHeight = 30;

    private JPanel gamePanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            Color backgroundColor = new Color(240, 240, 240);
            Color gridColor = new Color(200, 200, 200);
            Color borderColor = Color.GRAY; // Color del borde

            super.paintComponent(g);
            g.setColor(backgroundColor);
            g.fillRect(0, 0, gamePanelWidth, gamePanelHeight);
            g.setColor(gridColor);

            // Dibujar los bordes y los bloques internos
            for (int row = 0; row < panelStatus.length; row++) {
                for (int col = 0; col < panelStatus[row].length; col++) {
                    int x = col * cellWidth;
                    int y = row * cellHeight;
                    g.setColor(gridColor);
                    g.drawRect(x, y, cellWidth, cellHeight);

                    if (panelStatus[row][col] == 1) {
                        g.setColor(borderColor);
                        g.fillRect(x, y, cellWidth, cellHeight);
                    } else if (panelStatus[row][col] == 2) {
                        g.setColor(Color.RED);
                        g.fillRect(x, y, cellWidth, cellHeight);
                        g.setColor(Color.BLACK);
                        g.drawRect(x, y, cellWidth, cellHeight);
                    }
                }
            }
        }
    };

    public GamePanel() {
        // Inicializar los bordes con 3
        for (int i = 0; i < panelStatus.length; i++) {
            panelStatus[i][0] = 1; // Lado izquierdo
            panelStatus[i][panelStatus[i].length - 1] = 1; // Lado derecho
        }
        for (int i = 0; i < panelStatus[0].length; i++) {
            panelStatus[0][i] = 1; // Lado superior
            panelStatus[panelStatus.length - 1][i] = 1; // Lado inferior
        }
        panelStatus[10][7] = 2; //example
        panelStatus[10][8] = 2; //example

        gamePanel.setSize(gamePanelWidth, gamePanelHeight);
        gamePanel.setLayout(null);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public int[][] getPanelStatus() {
        return panelStatus;
    }
}
