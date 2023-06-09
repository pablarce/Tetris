package test;

import main.Figure;
import main.Game;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void testGenerateFigure() {
        Game game = new Game();
        Figure figure = game.generateFigure();
        assertNotNull(figure);
    }

    @Test
    public void testGetRandomX() {
        Game game = new Game();
        int posX = game.getRandomX();
        assertTrue(posX >= 30 && posX <= 210);
        assertEquals(0, posX % 30);
    }


}

