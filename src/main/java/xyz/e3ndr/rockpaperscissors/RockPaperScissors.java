package xyz.e3ndr.rockpaperscissors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import xyz.e3ndr.rockpaperscissors.controllers.ConsoleController;
import xyz.e3ndr.rockpaperscissors.controllers.IController;
import xyz.e3ndr.rockpaperscissors.controllers.Play;
import xyz.e3ndr.rockpaperscissors.controllers.RobotController;

public class RockPaperScissors {
    public static final Scanner scanner = new Scanner(System.in);
    public static boolean cheat = false;

    // https://i.imgur.com/jiAyMuv.gif
    public static void main(String[] args) {
        while (true) {
            play();
            System.out.println("\n\nPlay again? (y/n)");
            String again = scanner.next();

            if (!again.equalsIgnoreCase("y")) {
                break;
            }

            System.out.println('\n');
        }

        scanner.close();
    }

    private static void play() {
        List<IController> controllers = Arrays.asList(new ConsoleController("Player"), new RobotController());
        List<Play> plays = new ArrayList<>();
        Set<Play> same = new HashSet<>();

        controllers.forEach((controller) -> plays.add(controller.blockRead()));

        plays.forEach((play) -> {
            List<Play> beat = new ArrayList<>();

            plays.forEach((otherPlay) -> {
                if (otherPlay != play) {
                    if (otherPlay.getPlayed().getTypeAfraid() == play.getPlayed()) {
                        beat.add(otherPlay);
                    } else if (otherPlay.getPlayed() == play.getPlayed()) {
                        same.add(otherPlay);
                    }
                }
            });

            beat.forEach((otherPlay) -> {
                System.out.printf(String.format("%s's %s beats %s's %s!\n", play.getName(), play.getPlayed().name().toLowerCase(), otherPlay.getName(), otherPlay.getPlayed().name().toLowerCase()));
            });
        });

        StringBuilder sb = new StringBuilder();

        same.forEach((play) -> {
            sb.append(" and ").append(play.getName());
        });

        if (!sb.toString().isEmpty()) {
            Play samePlay = same.iterator().next();

            System.out.printf("%s both played %s.\n", sb.substring(5), samePlay.getPlayed().name().toLowerCase());
        }
    }

}
