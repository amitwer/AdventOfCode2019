package day5;

public class Day5 {
    public static void main(String[] args) {
        String input = "3,0,4,0,99";

        CommandParser commandParser = new CommandParser(input);
        while (commandParser.hasNextToken()){
            CommandToken cmd = commandParser.getNextCommand();

        }
    }
}
