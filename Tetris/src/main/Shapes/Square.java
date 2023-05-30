package main.Shapes;

import main.Figure;

import java.awt.*;

public class Square extends Figure {

    private int [][] newDefinition = new int [4][4];
    private Color squareColor = Color.YELLOW;
    public Square( int posX, int posY) {
        super( posX, posY);
        newDefinition[1][1] = 1;
        newDefinition[1][2] = 1;
        newDefinition[2][1] = 1;
        newDefinition[2][2] = 1;
        definition=newDefinition;
        this.color =squareColor;
    }


}


