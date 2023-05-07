package main.Shapes;

import main.Figure;

public class Square extends Figure {

    private int [][] newDefinition = new int [4][4];

    public Square(String color, int posX, int posY) {
        super(color, posX, posY);
        newDefinition[1][1] = 1;
        newDefinition[1][2] = 1;
        newDefinition[2][1] = 1;
        newDefinition[2][2] = 1;
        changeDefinition(newDefinition);
    }


}


