package main.Shapes;

public class Zshape extends main.Figure{
    private int [][] newDefinition = new int [4][4];

    public Zshape(String color, int posX, int posY) {
        super(color, posX, posY);
        newDefinition[1][1] = 1;
        newDefinition[1][2] = 1;
        newDefinition[2][2] = 1;
        newDefinition[2][3] = 1;
        changeDefinition(newDefinition);
    }
}
