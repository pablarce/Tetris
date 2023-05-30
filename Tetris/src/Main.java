import main.Figure;
import main.Game;
import main.Shapes.*;

public class Main {
    public static void main(String[] args) {

        Figure figure1, figure2, figure3, figure4, figure5, figure6, figure7;

        figure1 = new Square( 0, 10);
        figure2 = new Tshape( 10,10);
        figure3 = new Straigth( 20,10);
        figure4 = new Lshape( 30,10);
        figure5 = new Sshape( 400,10);
        figure6 = new Zshape( 50,10);
        figure7 = new Jshape( 60,10);

        figure1.draw();
        spacing();
        figure2.draw();
        spacing();
        figure3.draw();
        spacing();
        figure4.draw();
        spacing();
        figure5.draw();
        spacing();
        figure6.draw();
        spacing();
        figure7.draw();

        new Game();

    }
    static void spacing(){
        System.out.println("- ".repeat(6));
    }
}