package main;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Stack;

import main.Shapes.*;


public class Prueba{

    public Prueba() {
        Stack<Figure> figures = new Stack<>();
        Figure actualFigure = generateFigure();
        figures.push(actualFigure);
        InitialFrame MyInitialFrame = new InitialFrame();
        JFrame frame = MyInitialFrame.getFrame();
        GamePanel MyGamePanel = new GamePanel();
        boolean[] isStopped = {false};
        frame.add(MyGamePanel.getGamePanel());

        // for que recorre actualFigure.getPixels() y los agrega al gamePanel
        actualFigure.assignPixels(actualFigure.getPosX(), actualFigure.getPosY());

        for (Pixel pixel : actualFigure.getPixels()) {
            MyGamePanel.getGamePanel().add(pixel.getPixel());
        }

        Timer goingDownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (figures.peek().canIMoveY(MyGamePanel.getPanelStatus())) {
                    figures.peek().setPosY(figures.peek().getPosY() + 30);
                    figures.peek().reAssignPixels(figures.peek().getPosX(), figures.peek().getPosY());
                    MyGamePanel.getGamePanel().repaint();
                }
            }
        });
        goingDownTimer.start();

        Timer checkIfStopped = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!figures.peek().canIMoveY(MyGamePanel.getPanelStatus())) {
                    newFigure(MyGamePanel, figures);
                }
            }
        });
        checkIfStopped.start();

        Timer laterals = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // X axis
                for (int row = 1; row < MyGamePanel.getPanelStatus().length - 1; row++) {
                    boolean full = true;
                    for (int col = 1; col < MyGamePanel.getPanelStatus()[row].length - 1; col++) {
                        if (MyGamePanel.getPanelStatus()[row][col] == 0) {
                            full = false;
                            break;
                        }
                    }
                    if (full) {
                        for (int col = 1; col < MyGamePanel.getPanelStatus()[row].length - 1; col++) {
                            MyGamePanel.getPanelStatus()[row][col] = 0;
                        }
                        for (int row2 = row; row2 > 1; row2--) {
                            for (int col = 1; col < MyGamePanel.getPanelStatus()[row2].length - 1; col++) {
                                MyGamePanel.getPanelStatus()[row2][col] = MyGamePanel.getPanelStatus()[row2 - 1][col];
                            }
                        }
                    }
                }

                // Y axis
                for (int col = 1; col < MyGamePanel.getPanelStatus()[0].length - 1; col++) {
                    if (MyGamePanel.getPanelStatus()[0][col] == 1) {
                        isStopped[0] = true;
                        break;
                    }
                }
                MyGamePanel.getGamePanel().repaint();
            }
        });
        laterals.start();

        // add the keyboard movement
        frame.addKeyListener(new KeyAdapter() {
            private boolean wKeyPressed = false;
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                    if (figures.peek().canIMoveY(MyGamePanel.getPanelStatus())){
                        figures.peek().setPosY(figures.peek().getPosY() + 30);
                        figures.peek().reAssignPixels(figures.peek().getPosX(), figures.peek().getPosY());
                        MyGamePanel.getGamePanel().repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                    if (figures.peek().canIMoveX(MyGamePanel.getPanelStatus(), -1)){
                        figures.peek().setPosX(figures.peek().getPosX() - 30);
                        figures.peek().reAssignPixels(figures.peek().getPosX(), figures.peek().getPosY());
                        MyGamePanel.getGamePanel().repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D ) {
                    if (figures.peek().canIMoveX(MyGamePanel.getPanelStatus(), 1)){
                        figures.peek().setPosX(figures.peek().getPosX() + 30);
                        figures.peek().reAssignPixels(figures.peek().getPosX(), figures.peek().getPosY());
                        MyGamePanel.getGamePanel().repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                    if (!wKeyPressed) {
                        figures.peek().rotate();
                        figures.peek().reAssignPixels(figures.peek().getPosX(), figures.peek().getPosY());
                        MyGamePanel.getGamePanel().repaint();
                        wKeyPressed = true;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (isStopped[0]){
                        goingDownTimer.start();
                        isStopped[0] = false;
                    } else {
                        goingDownTimer.stop();
                        isStopped[0] = true;
                    }
                }
            }
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
                    wKeyPressed = false;
                }
            }
        });

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
        int posX = random.nextInt(7);
        return posX*30 + 30;
    }

    public static void newFigure(GamePanel MyGamePanel, Stack<Figure> figures){
        Figure newFigure = generateFigure();
        for (Pixel pixel : figures.peek().getPixels()) {
            MyGamePanel.paintPanel(pixel.getPosX()/30, pixel.getPosY()/30, pixel.getColor());
            MyGamePanel.getGamePanel().remove(pixel.getPixel());
        }
        figures.push(newFigure);
        figures.peek().assignPixels(figures.peek().getPosX(), figures.peek().getPosY());

        for (Pixel pixel : figures.peek().getPixels()) {
            MyGamePanel.getGamePanel().add(pixel.getPixel());
        }
        MyGamePanel.getGamePanel().repaint();
    }


}
