package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import main.Shapes.*;


public class Prueba{
    private final int pixelWidth = 30;
    private final int pixelHeight = 30;

    public Prueba() {
        Figure actualFigure = generateFigure();
        InitialFrame MyInitialFrame = new InitialFrame();
        JFrame frame = MyInitialFrame.getFrame();
        GamePanel MyGamePanel = new GamePanel();
        final boolean[] isStopped = {false};
        frame.add(MyGamePanel.getGamePanel());

        // for que recorre actualFigure.getPixels() y los agrega al gamePanel
        actualFigure.assignPixels(actualFigure.getPosX(), actualFigure.getPosY());

        for (Pixel pixel : actualFigure.getPixels()) {
            MyGamePanel.getGamePanel().add(pixel.getPixel());
        }

        Timer goingDownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (actualFigure.canIMoveY(MyGamePanel.getPanelStatus())) {
                    actualFigure.setPosY(actualFigure.getPosY() + 30);
                    actualFigure.reAssignPixels(actualFigure.getPosX(), actualFigure.getPosY());
                    MyGamePanel.getGamePanel().repaint();
                }
            }
        });
        goingDownTimer.start();

        //

    }



    //// This method is used to generate a random figure
    public static Figure generateFigure(){
        Random random = new Random();
        int shape = random.nextInt(7);
        String color = getRandomColor();
        int posX = getRandomX();
        Figure newFigure;
        switch(shape){
            case 1:
                newFigure = new Square(color, posX, 0);
                break;
            case 2:
                newFigure = new Tshape(color, posX, 0);
                break;
            case 3:
                newFigure = new Straigth(color, posX, 0);
                break;
            case 4:
                newFigure = new Lshape(color, posX, 0);
                break;
            case 5:
                newFigure = new Sshape(color, posX, 0);
                break;
            case 6:
                newFigure = new Zshape(color, posX, 0);
                break;
            default:
                newFigure = new Jshape(color, posX, 0);
                break;
        }
        return newFigure;
    }
    public static String getRandomColor(){
        Random random = new Random();
        int color = random.nextInt(7);
        String newColor;
        switch(color){
            case 1:
                newColor = "blue";
                break;
            case 2:
                newColor = "green";
                break;
            case 3:
                newColor = "yellow";
                break;
            case 4:
                newColor = "orange";
                break;
            case 5:
                newColor = "purple";
                break;
            case 6:
                newColor = "pink";
                break;
            default:
                newColor = "red";
                break;
        }
        return newColor;
    }
    public static int getRandomX(){
        // random number from 30 to 210, 30 as step
        Random random = new Random();
        int posX = random.nextInt(8);
        return posX*30;
    }
}
