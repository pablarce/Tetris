package main.Shapes;

import java.awt.*;

public class Sshape extends main.Figure{
    private int [][] newDefinition = new int [4][4];
    private Color sShapeColor = Color.GREEN;
    public Sshape( int posX, int posY) {
        super( posX, posY);
        newDefinition[1][2] = 1;
        newDefinition[1][3] = 1;
        newDefinition[2][1] = 1;
        newDefinition[2][2] = 1;
        definition=newDefinition;
        this.color = sShapeColor;
    }
}
