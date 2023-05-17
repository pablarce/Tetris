package main.Shapes;

import main.Figure;

public class Ishape extends Figure {
    private int [][] newDefinition = new int [4][4];

    public Ishape(String color, int posX, int posY) {
        super(color, posX, posY);
        newDefinition[0][0] = 1;
        newDefinition[0][1] = 1;
        newDefinition[0][2] = 1;
        newDefinition[0][3] = 1;
        changeDefinition(newDefinition);
    }
}
