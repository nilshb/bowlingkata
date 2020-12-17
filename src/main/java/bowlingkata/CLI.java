package bowlingkata;

public class CLI {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Simple CLI for The Bowling Game - v1.0.0");
            System.out.println("Arguments: pins for rolls in a game.");
        } else {
            Game game = new Game();
            for (String pins : args) {
                game.roll(Integer.parseInt(pins));
            }
            System.out.println("Number of rolls: " + args.length);
            System.out.println("Score: " + game.score());
        }

    }

}
