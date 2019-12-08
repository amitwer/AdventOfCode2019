package day5;

public class CommandParser {
    private final String[] input;
    private final int currentIndex;

    public CommandParser(String input) {
        this.input= input.split(",");
        this.currentIndex=0;
    }

    public boolean hasNextToken() {
        return Integer.parseInt(this.input[this.currentIndex])!=99;
    }
}
