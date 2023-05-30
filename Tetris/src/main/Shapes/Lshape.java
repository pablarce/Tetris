package main.Shapes;

import main.Figure;

import java.awt.*;

public class Lshape extends Figure {
    private int [][] newDefinition = new int [4][4];
    private Color lShapeColor = Color.ORANGE;

    public Lshape( int posX, int posY) {
        super( posX, posY);
        newDefinition[1][1] = 1;
        newDefinition[2][1] = 1;
        newDefinition[3][1] = 1;
        newDefinition[3][2] = 1;
        changeDefinition(newDefinition);
        this.color = lShapeColor;
    }
}
