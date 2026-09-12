import java.util.*;

public class M1 {

    static String playRound(String p, String c) {
        if (p.equals(c))
            return "Draw";

        if ((p.equals("Rock") && c.equals("Scissors")) ||
            (p.equals("Paper") && c.equals("Rock")) ||
            (p.equals("Scissors") && c.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] player = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        int win = 0, loss = 0, draw = 0;

        for (int i = 0; i < 5; i++) {

            String computer = moves[(int)(Math.random() * 3)];
            String result = playRound(player[i], computer);

            System.out.println(
                "Round " + (i + 1) + ": " +
                player[i] + " | " + computer + " | " + result
            );

            if (result.equals("Player Wins"))
                win++;
            else if (result.equals("Computer Wins"))
                loss++;
            else
                draw++;
        }

        double percentage = win * 100.0 / 5;

        System.out.println("Wins: " + win);
        System.out.println("Losses: " + loss);
        System.out.println("Draws: " + draw);
        System.out.println("Win %: " + percentage);
    }
}