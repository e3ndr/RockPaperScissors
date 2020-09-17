package xyz.e3ndr.rockpaperscissors.controllers;

import java.util.concurrent.ThreadLocalRandom;

import xyz.e3ndr.rockpaperscissors.RockPaperScissors;
import xyz.e3ndr.rockpaperscissors.ThrowType;

public class RobotController implements IController {

    @Override
    public Play blockRead() {
        ThrowType played;

        if (RockPaperScissors.cheat) {
            played = ThrowType.SCISSORS;
        } else {
            played = ThrowType.values()[ThreadLocalRandom.current().nextInt(ThrowType.values().length)];
        }

        return new Play(this.getName(), played);
    }

    @Override
    public String getName() {
        return "Robot";
    }

}
