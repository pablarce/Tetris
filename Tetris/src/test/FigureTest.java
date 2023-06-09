package test;

import main.Figure;
import main.Pixel;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;
import java.util.ArrayList;
import static org.junit.Assert.*;


public class FigureTest {
   Figure figure;

    @Test
    public void testGetSetPosX() {
         figure = new Figure(0, 0) {
            @Override
            public void draw() {
                super.draw();
            }
        }; // Reemplaza ConcreteFigure por el nombre de la clase concreta que extiende Figure
        assertEquals(0, figure.getPosX());
        figure.setPosX(100);
        assertEquals(100, figure.getPosX());
    }

    @Test
    public void testGetSetPosY() {
         figure = new Figure(0, 0) {
            @Override
            public void draw() {
                super.draw();
            }
        }; // Reemplaza ConcreteFigure por el nombre de la clase concreta que extiende Figure
        assertEquals(0, figure.getPosY());
        figure.setPosY(200);
        assertEquals(200, figure.getPosY());
    }

    @Test
    public void testGetColor() {
         figure = new Figure(0, 0) {
            @Override
            public void draw() {
                super.draw();
            }
        }; // Reemplaza ConcreteFigure por el nombre de la clase concreta que extiende Figure
        assertEquals(Color.BLACK, figure.getColor()); // Cambia Color.BLACK por el color esperado de la figura
    }

    @Test
    public void testAssignPixels() {
        Figure figure = new Figure(0, 0) {
            @Override
            public void draw() {
                super.draw();
            }
        }; // Reemplaza ConcreteFigure por el nombre de la clase concreta que extiende Figure
        figure.assignPixels(100, 200); // Cambia los valores de posición según sea necesario

        ArrayList<Pixel> pixels = figure.getPixels();
        assertNotNull(pixels);
        assertFalse(pixels.isEmpty());
        // Agrega más aserciones para verificar la posición y el color de los píxeles asignados
    }

    @Test
    public void testRotate() {
         figure = new Figure(0, 0) {
            @Override
            public void draw() {
                super.draw();
            }
        }; // Reemplaza ConcreteFigure por el nombre de la clase concreta que extiende Figure
        int[][] originalDefinition = figure.getDefinition();

        figure.rotate();

        int[][] rotatedDefinition = figure.getDefinition();
        assertNotNull(rotatedDefinition);

    }

}
