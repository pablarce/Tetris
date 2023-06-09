import main.Figure;
import main.Game;
import main.Shapes.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to our game!");
        System.out.println("");
        System.out.println("The controls are very simple: ");
        System.out.println("To move from side to side along the horizontal axis: [A][D] or [←][→]");
        System.out.println("To make the piece drop faster: [S] or [↓]");
        System.out.println("To rotate the piece: [W] or [↑]");
        System.out.println("To pause the falling piece: [P]");
        System.out.println("\nEvery 1000 score u get, the figure will drop faster and faster");
        System.out.println("Good luck!");

        new Game();

    }

}