package main.Shapes;

import main.Figure;

import java.awt.*;

public class Straigth extends Figure {
    private int [][] newDefinition = new int [4][4];
    private Color straigthColor = Color.CYAN;
    public Straigth( int posX, int posY) {
        super( posX, posY);
        newDefinition[1][0] = 1;
        newDefinition[1][1] = 1;
        newDefinition[1][2] = 1;
        newDefinition[1][3] = 1;
        definition = newDefinition;
        this.color = straigthColor;

    }
}