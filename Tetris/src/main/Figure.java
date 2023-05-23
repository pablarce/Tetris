package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Figure {
    private String color;
    private int [][] definition = new int [4][4];
    private ArrayList<Pixel> pixels = new ArrayList<>();
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
    public int setPosX(int posX){
        return this.posX = posX;
    }
    public int getPosY(){
        return posY;
    }
    public int setPosY(int posY){
        return this.posY = posY;
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
    public void assignPixels(int posX, int posY){
        for (int i = 0; i < definition.length; i++) {
            for (int j = 0; j < definition[i].length; j++) {
                if (definition[i][j] == 1){
                    pixels.add(new Pixel(posX + j*30, posY + i*30, getColor()));
                }
            }
        }
    }
    public void reAssignPixels(int posX, int posY){
        int cont = 0;
        for (int i = 0; i < definition.length; i++) {
            for (int j = 0; j < definition[i].length; j++) {
                if (definition[i][j] == 1){
                    pixels.get(cont).setPosX(posX + j*30);
                    pixels.get(cont).setPosY(posY + i*30);
                    pixels.get(cont).getPixel().repaint();
                    cont ++;
                }
            }
        }
    }
    public ArrayList<Pixel> getPixels(){
        return pixels;
    }
    public void changeDefinition(int [][] newDefinition){
        this.definition = newDefinition;
    }

    public boolean canIMoveY(int [][] board){
        for (int i = 0; i < definition.length; i++) {
            for (int j = 0; j < definition[i].length; j++) {
                if (definition[i][j] == 1){
                    if (board[posY/30 + i + 1][posX/30 + j] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean canIMoveX(int [][] board, int direction){
        for (int i = 0; i < definition.length; i++) {
            for (int j = 0; j < definition[i].length; j++) {
                if (definition[i][j] == 1){
                    if (board[posY/30 + i][posX/30 + j + direction] != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
