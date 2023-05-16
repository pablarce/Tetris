package main;

import javax.swing.*;
import java.awt.*;

public class InitialFrame {
    private JFrame frame = new JFrame("Tetris");
    public InitialFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(320, 640));
    }
    public JFrame getFrame(){
        return frame;
    }
}
