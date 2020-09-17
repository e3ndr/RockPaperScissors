package xyz.e3ndr.rockpaperscissors;

public enum ThrowType {
    ROCK,
    PAPER,
    SCISSORS;

    public ThrowType getTypeAfraid() { // Usually I'd just set a variable, but you cannot reference an ENUM before it's defined. No way around this.
        switch (this) {
            case PAPER:
                return SCISSORS;

            case ROCK:
                return PAPER;

            case SCISSORS:
                return ROCK;

            default: // Hush compilier
                return null;
        }
    }

}
