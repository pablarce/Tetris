package main.Shapes;

import main.Figure;

public class Tshape extends Figure {
    private int [][] newDefinition = new int [4][4];

    public Tshape(String color, int posX, int posY) {
        super(color, posX, posY);
        newDefinition[1][1] = 1;
        newDefinition[1][2] = 1;
        newDefinition[1][3] = 1;
        newDefinition[2][2] = 1;
        changeDefinition(newDefinition);
    }
}
