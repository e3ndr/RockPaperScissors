package xyz.e3ndr.rockpaperscissors.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import xyz.e3ndr.rockpaperscissors.RockPaperScissors;
import xyz.e3ndr.rockpaperscissors.ThrowType;

@AllArgsConstructor
public class ConsoleController implements IController {
    private @Getter String name;

    @Override
    public Play blockRead() {
        String message = this.buildMessage();

        System.out.println(message);

        String read = null;

        while (!isValid(read)) {
            read = RockPaperScissors.scanner.next();
        }

        ThrowType played = ThrowType.valueOf(read.trim().toUpperCase());

        return new Play(this.name, played);
    }

    private static boolean isValid(String read) {
        try {
            ThrowType.valueOf(read.trim().toUpperCase());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String buildMessage() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(", Pick one: ");

        for (ThrowType type : ThrowType.values()) {
            sb.append(type.name().toLowerCase()).append(", ");
        }

        return sb.substring(0, sb.length() - 2);
    }

}
