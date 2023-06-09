package test;

import main.GamePanel;
import org.junit.Test;
import javax.swing.JPanel;
import java.awt.Color;
import static org.junit.Assert.*;



public class GamePanelTest {
    GamePanel gamePanel = new GamePanel();
    @Test
    public void getGamePanel() {
        JPanel panel = gamePanel.getGamePanel();
        assertNotNull(panel);
    }

    @Test
    public void getPanelStatus() {
        int[][] panelStatus = gamePanel.getPanelStatus();
        assertNotNull(panelStatus);
        assertEquals(22, panelStatus.length);
        assertEquals(12, panelStatus[0].length);
    }

    @Test
    public void paintPanel() {
        int[][] panelStatus = gamePanel.getPanelStatus();

        gamePanel.paintPanel(1, 1, Color.RED);
        assertEquals(2, panelStatus[1][1]);

        gamePanel.paintPanel(2, 2, Color.BLUE);
        assertEquals(3, panelStatus[2][2]);

        gamePanel.paintPanel(3, 3, Color.GREEN);
        assertEquals(4, panelStatus[3][3]);

        gamePanel.paintPanel(4, 4, Color.YELLOW);
        assertEquals(5, panelStatus[4][4]);

        gamePanel.paintPanel(5, 5, Color.ORANGE);
        assertEquals(6, panelStatus[5][5]);

        gamePanel.paintPanel(6, 6, Color.MAGENTA);
        assertEquals(7, panelStatus[6][6]);

        gamePanel.paintPanel(7, 7, Color.CYAN);
        assertEquals(8, panelStatus[7][7]);
    }

}
