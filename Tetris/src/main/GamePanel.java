package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private int[][] panelStatus = new int[20][10];
    private int gamePanelWidth = 320;
    private int gamePanelHeight = 640;
    private Color backgroundColor = new Color(240, 240, 240);
    private Color gridColor = new Color(200, 200, 200);
    private Color blockColor = new Color(100, 100, 100);
    private JPanel gamePanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(backgroundColor);
            g.fillRect(0, 0, gamePanelWidth, gamePanelHeight);
            g.setColor(gridColor);
            int cellWidth = gamePanelWidth / panelStatus[0].length;
            int cellHeight = gamePanelHeight / panelStatus.length;

            for (int row = 0; row < panelStatus.length; row++) {
                for (int col = 0; col < panelStatus[row].length; col++) {
                    int x = col * cellWidth;
                    int y = row * cellHeight;
                    g.drawRect(x, y, cellWidth, cellHeight);
                    if (panelStatus[row][col] == 1) {
                        g.setColor(blockColor);
                        g.fillRect(x + 1, y + 1, cellWidth - 1, cellHeight - 1);
                    }
                }
            }
        }
    };

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public int getGamePanelWidth() {
        return gamePanelWidth;
    }

    public int getGamePanelHeight() {
        return gamePanelHeight;
    }
}
