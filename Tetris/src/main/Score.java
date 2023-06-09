package main;

import javax.swing.*;
import java.awt.*;

public class Score{
    private int score;
    private int linesCleared;
    boolean gameOver = false;
    boolean read = false;
    private JPanel scorePanel = new JPanel(){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            g.drawRect(380, 460, 250, 200);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(380, 460, 250, 200);

            Font scoreFont = new Font("Arial", Font.BOLD, 24);
            g.setFont(scoreFont);
            g.setColor(Color.WHITE);

            String scoreText = "Score: " + score;
            int x = 445;
            int y = 500;
            g.drawString(scoreText, x, y);

            String clearText = "";
            Color clearColor = Color.BLACK;

            switch (linesCleared) {
                case 1:
                    clearText = "SINGLE!";
                    clearColor = Color.RED;
                    break;
                case 2:
                    clearText = "DOUBLE!";
                    clearColor = Color.GREEN;
                    break;
                case 3:
                    clearText = "TRIPLE!";
                    clearColor = Color.BLUE;
                    break;
                case 4:
                    clearText = "TETRIS!";
                    clearColor = Color.ORANGE;
                    break;
            }

            g.setColor(clearColor);
            g.drawString(clearText, 455, 550);

            if (gameOver) {
                g.setColor(Color.RED);
                g.drawString("GAME OVER!", 430, 600);
            }
        }
    };

    public Score() {
        scorePanel.setPreferredSize(new Dimension(200, 100));
        score = 0;
        linesCleared = 0;

        scorePanel.setLayout(null);
        scorePanel.setFocusable(true);
        scorePanel.requestFocusInWindow();
        scorePanel.repaint();
    }

    public void updateScore(int linesCleared) {
        switch (linesCleared) {
            case 1:
                score += 100;
                break;
            case 2:
                score += 300;
                break;
            case 3:
                score += 500;
                break;
            case 4:
                score += 800;
                break;
        }
        this.linesCleared = linesCleared;
    }
    public void gameOver() {
        this.gameOver = true;
        if (!this.read){scorePanel.repaint();}
        this.read = true;
    }

    public int getScore() {
        return score;
    }

    public JPanel getScorePanel() {
        return scorePanel;
    }
}
