package main.Shapes;

import main.Figure;

public class Jshape extends Figure {
    private int [][] newDefinition = new int [4][4];

    public Jshape(String color, int posX, int posY) {
        super(color, posX, posY);
        newDefinition[1][2] = 1;
        newDefinition[2][2] = 1;
        newDefinition[3][2] = 1;
        newDefinition[3][1] = 1;
        changeDefinition(newDefinition);
    }
}
