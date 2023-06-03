package main;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Stack;

import main.Shapes.*;


public class Game{
    private int speed = 1000;
    private int scoreMark = 1000;

    public Game() {
        Stack<Figure> figures = new Stack<>();
        Figure actualFigure = generateFigure();
        figures.push(actualFigure);
        Score score = new Score();
        InitialFrame MyInitialFrame = new InitialFrame();
        JFrame frame = MyInitialFrame.getFrame();
        GamePanel MyGamePanel = new GamePanel();
        frame.add(MyGamePanel.getGamePanel());
        boolean[] isStopped = {false};
        frame.add(score);

        // for que recorre actualFigure.getPixels() y los agrega al gamePanel
        actualFigure.assignPixels(actualFigure.getPosX(), actualFigure.getPosY());

        for (Pixel pixel : actualFigure.getPixels()) {
            MyGamePanel.getGamePanel().add(pixel.getPixel());
        }

        Timer goingDownTimer = new Timer(speed, new ActionListener() {
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

        Timer laterals = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // X axis
                int linesCleared = 0; // Variable para contar las líneas eliminadas

                for (int row = 1; row < MyGamePanel.getPanelStatus().length - 1; row++) {
                    boolean full = true;
                    for (int col = 1; col < MyGamePanel.getPanelStatus()[row].length - 1; col++) {
                        if (MyGamePanel.getPanelStatus()[row][col] == 0) {
                            full = false;
                            break;
                        }
                    }
                    if (full) {
                        linesCleared++;

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
                if (linesCleared > 0) {
                    score.updateScore(linesCleared);
                    score.repaint();
                    if (score.getScore() >= scoreMark) {
                        speed -= 100;
                        scoreMark += 1000;
                        goingDownTimer.setDelay(speed);
                    }
                }
                // Y axis
                for (int col = 1; col < MyGamePanel.getPanelStatus()[0].length - 1; col++) {
                    if (MyGamePanel.getPanelStatus()[1][col] == 1) {
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
        int posX = getRandomX();
        Figure newFigure;
        switch(shape){
            case 1:
                newFigure = new Square(posX, 0);
                break;
            case 2:
                newFigure = new Tshape(posX, 0);
                break;
            case 3:
                newFigure = new Straigth(posX, 0);
                break;
            case 4:
                newFigure = new Lshape(posX, 0);
                break;
            case 5:
                newFigure = new Sshape(posX, 0);
                break;
            case 6:
                newFigure = new Zshape(posX, 0);
                break;
            default:
                newFigure = new Jshape(posX, 0);
                break;
        }
        return newFigure;
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