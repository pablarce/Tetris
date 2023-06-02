package main.Shapes;

import java.awt.*;

public class Zshape extends main.Figure{
    private int [][] newDefinition = new int [4][4];
    private Color tShapeColor = Color.RED;
    public Zshape( int posX, int posY) {
        super( posX, posY);
        newDefinition[1][1] = 1;
        newDefinition[1][2] = 1;
        newDefinition[2][2] = 1;
        newDefinition[2][3] = 1;
        definition=newDefinition;
        this.color= tShapeColor;
    }
}