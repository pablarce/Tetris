package main;

public abstract class Figure {
    private String color;
    private int [][] definition = new int [4][4];
    private int posX;
    private int posY;

    public Figure(String color, int posX, int posY) {
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }
    public void draw(){ //Only for testing purposes
        for (int i = 0; i < definition.length; i++) {
            for (int j = 0; j < definition[i].length; j++) {
                System.out.print(definition[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public String getColor(){
        return color;
    }
    public void changeDefinition(int [][] newDefinition){
        this.definition = newDefinition;
    }


}
