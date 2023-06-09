package test;

import main.Score;
import org.junit.Test;
import javax.swing.JPanel;
import java.awt.*;

import static org.junit.Assert.*;

public class ScoreTest {

    @Test
    public void testUpdateScore() {
        Score score = new Score();
        int initialScore = score.getScore();
        int linesCleared = 1;

        score.updateScore(linesCleared);
        int updatedScore = score.getScore();

        switch (linesCleared) {
            case 1:
                assertEquals(initialScore + 100, updatedScore);
                break;
            case 2:
                assertEquals(initialScore + 300, updatedScore);
                break;
            case 3:
                assertEquals(initialScore + 500, updatedScore);
                break;
            case 4:
                assertEquals(initialScore + 800, updatedScore);
                break;
        }
    }

    @Test
    public void testGetScore() {
        Score score = new Score();
        int expectedScore = 0;

        int actualScore = score.getScore();

        assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testGetScorePanel() {
        Score score = new Score();
        JPanel scorePanel = score.getScorePanel();

        assertNotNull(scorePanel);
        assertEquals(new Dimension(200, 100), scorePanel.getPreferredSize());
        // Agrega más aserciones si hay propiedades adicionales que debas verificar
    }

    @Test
    public void testPaintComponent() {
        Score score = new Score();
        JPanel scorePanel = score.getScorePanel();

        // Simulamos la llamada al método paintComponent() para verificar la representación visual
        Graphics graphics = scorePanel.getGraphics();
        scorePanel.paintComponents(graphics);
        // Agrega aserciones para verificar la representación visual esperada
    }

    // Agrega más pruebas según sea necesario para otros métodos y comportamientos de la clase Score
}
