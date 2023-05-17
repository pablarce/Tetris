package main.Shapes;

public class Sshape extends main.Figure{
    private int [][] newDefinition = new int [4][4];

    public Sshape(String color, int posX, int posY) {
        super(color, posX, posY);
        newDefinition[1][2] = 1;
        newDefinition[1][3] = 1;
        newDefinition[2][1] = 1;
        newDefinition[2][2] = 1;
        changeDefinition(newDefinition);
    }
}
