package main.Shapes;

import main.Figure;

import java.awt.*;

public class Jshape extends Figure {
    private int [][] newDefinition = new int [4][4];
    private Color jShapeColor = Color.BLUE;
    public Jshape(int posX, int posY) {
        super( posX, posY);
        newDefinition[1][1] = 1;
        newDefinition[2][1] = 1;
        newDefinition[2][2] = 1;
        newDefinition[2][3] = 1;
        definition=newDefinition;
        this.color = jShapeColor;
    }
}