package day5;

public class CommandParser {

    public CommandToken parseCommand(int opCode) {
        int cmd=opCode%100;
        int modes = opCode/100;

        CommandType type = CommandType.identifyByNum(cmd);
        return new CommandToken(type,modes);


    }
}
