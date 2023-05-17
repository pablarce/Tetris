package main.Shapes;

import main.Figure;

public class Straigth extends Figure {
    private int [][] newDefinition = new int [4][4];

    public Straigth(String color, int posX, int posY) {
        super(color, posX, posY);
        newDefinition[0][0] = 1;
        newDefinition[0][1] = 1;
        newDefinition[0][2] = 1;
        newDefinition[0][3] = 1;
        changeDefinition(newDefinition);
    }
}
