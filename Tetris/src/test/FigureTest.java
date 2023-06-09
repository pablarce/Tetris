package test;

import main.Figure;
import main.Pixel;
import main.Shapes.*;
import org.junit.Test;
import java.awt.Color;
import java.util.ArrayList;
import static org.junit.Assert.*;


public class FigureTest {
    Figure figure = new Square(0,0);
    // Figure is abstract, so we test with a random concrete figure

    @Test
    public void setAndGetPosX() {
        figure.setPosX(100);
        assertEquals(100, figure.getPosX());
    }

    @Test
    public void setAndGetPosY() {
        figure.setPosY(100);
        assertEquals(100, figure.getPosY());
    }

    @Test
    public void checkDefinitions(){
        ArrayList<Figure> figures = new ArrayList<Figure>();
        figures.add(new Square(0, 10));
        figures.add(new Tshape(10,10));
        figures.add(new Straigth(20,10));
        figures.add(new Lshape(30,10));
        figures.add(new Sshape(400,10));
        figures.add(new Zshape(50,10));
        figures.add(new Jshape(60,10));
        for (Figure figure : figures) {
            figure.draw();
            System.out.println();
        }
    }

    @Test
    public void getColor() {
        Color expected = Color.YELLOW; //It is a square
        assertEquals(expected, figure.getColor());
    }

    @Test
    public void getPixelsAndAssignPixels() {
        figure.assignPixels(0, 0);
        ArrayList<Pixel> expected = new ArrayList<>();
        expected.add(new Pixel(30, 30, Color.YELLOW));
        expected.add(new Pixel(60, 30, Color.YELLOW));
        expected.add(new Pixel(30, 60, Color.YELLOW));
        expected.add(new Pixel(60, 60, Color.YELLOW));

        ArrayList<Pixel> actual = figure.getPixels();
        for (int i = 0; i < expected.size(); i++) {
            Pixel expectedPixel = expected.get(i);
            Pixel actualPixel = actual.get(i);

            assertEquals(expectedPixel.getPosX(), actualPixel.getPosX());
            assertEquals(expectedPixel.getPosY(), actualPixel.getPosY());
            assertEquals(expectedPixel.getColor(), actualPixel.getColor());
        }
    }

    @Test
    public void reAssignPixels() {
        figure.assignPixels(0, 0);
        figure.reAssignPixels(100, 100);
        ArrayList<Pixel> expected = new ArrayList<>();
        expected.add(new Pixel(130, 130, Color.YELLOW));
        expected.add(new Pixel(160, 130, Color.YELLOW));
        expected.add(new Pixel(130, 160, Color.YELLOW));
        expected.add(new Pixel(160, 160, Color.YELLOW));

        ArrayList<Pixel> actual = figure.getPixels();
        for (int i = 0; i < expected.size(); i++) {
            Pixel expectedPixel = expected.get(i);
            Pixel actualPixel = actual.get(i);

            assertEquals(expectedPixel.getPosX(), actualPixel.getPosX());
            assertEquals(expectedPixel.getPosY(), actualPixel.getPosY());
            assertEquals(expectedPixel.getColor(), actualPixel.getColor());
        }
    }

    @Test
    public void rotate() {
        Figure straight = new Straigth(0,0);
        straight.rotate();

        int [][] expected = new int [4][4];
        expected[0][2] = 1;
        expected[1][2] = 1;
        expected[2][2] = 1;
        expected[3][2] = 1;

        assertEquals(expected, straight.getDefinition());
    }

    @Test
    public void canIMoveY(){
        int [][] board = new int [4][4];
        assertTrue(figure.canIMoveY(board));
    }

    @Test
    public void canIMoveX(){
        int [][] board = new int [4][4];
        assertTrue(figure.canIMoveX(board, 1));
        assertTrue(figure.canIMoveX(board, -1));

        // The Square is in the middle of the board,
        // so it could move anywhere
    }

}
