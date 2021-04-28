import java.util.Scanner;

public class Main extends GameEngine{

    boolean stop = false;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GameEngine playGame;
        playGame = new GameEngine();
        playGame.play();
    }
}
