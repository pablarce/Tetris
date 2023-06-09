import main.Figure;
import main.Game;
import main.Shapes.*;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Welcome to our game. We are a group called DuoSacapuntos composed of Pablo Arce and Rubén Setién, who have developed our own version of the famous game TETRIS.");
        System.out.printf("");
        System.out.printf("The controls are very simple. ");
        System.out.printf("To move from side to side along the horizontal axis: [A][D] or [←][→]");
        System.out.printf("To make the piece drop faster: [S] or [↓]");
        System.out.printf("To rotate the piece: [W] or [↑]");

        new Game();

    }

}