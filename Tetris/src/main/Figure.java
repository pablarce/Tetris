package main;

import javax.swing.*;
import java.awt.*;

public abstract class Figure {
    private String color;
    private int [][] definition = new int [4][4];
    private int posX;
    private int posY;
    private boolean isSet = false;

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
    public Color getColor(){
        switch(color) {
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "green":
                return Color.GREEN;
            case "yellow":
                return Color.YELLOW;
            case "orange":
                return Color.ORANGE;
            case "purple":
                return new Color(0x800080);
            case "pink":
                return Color.PINK;
            default:
                return Color.BLACK;
        }

    }
    public void changeDefinition(int [][] newDefinition){
        this.definition = newDefinition;
    }
    public boolean isItSet(){
        return isSet;
    }
    public void setIt(){
        isSet = true;
    }


}
