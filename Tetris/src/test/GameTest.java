package test;

import main.Figure;
import main.Game;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    Game game = new Game();

    @Test
    public void generateFigure() {
        Figure figure = game.generateFigure();
        assertNotNull(figure);
    }

    @Test
    public void getRandomX() {
        int posX = game.getRandomX();
        assertTrue(posX >= 30 && posX <= 210);
        assertEquals(0, posX % 30);
    }


}

