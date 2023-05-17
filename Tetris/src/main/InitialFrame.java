package main;

import javax.swing.*;
import java.awt.*;

public class InitialFrame {
    private JFrame frame = new JFrame("Tetris");
    public InitialFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 800);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(400, 700));
        frame.setVisible(true);
    }
    public JFrame getFrame(){
        return frame;
    }
}
