package day5;

public class IntcodeComputer {
    private int cmdPointer;
    private final CommandParser commandParser;
    private Input inputCmd;

    public IntcodeComputer(Input inputCmd) {

        this.inputCmd = inputCmd;
        this.commandParser = new CommandParser();
        this.cmdPointer = 0;
    }

    public String calculate(int[] input) {
        CommandToken cmd = null;
        String output=null;
        do {
            cmd = commandParser.parseCommand(input[cmdPointer]);
            cmdPointer++;
            for (int i = 0; i < cmd.getNumOfParameters(); i++) {
                cmd.setParameter(i, getParamValue(cmdPointer + i, cmd.isImmediate(i), input));
            }
            if (cmd.isWritingToInput()) {
                input[cmd.getTargetInputCell()] = cmd.getResult(input);
            }
            if (cmd.hasOutput()) {
                output=""+cmd.getResult(input);
            }
            if (cmd.isJump()){
                cmdPointer = cmd.getResult(input);
            }
            else {
                cmdPointer += cmd.getNumOfParameters();
            }
        } while (CommandType.HALT != cmd.getType());

        return output;
    }


    private static int getParamValue(int value, boolean isImmediate, int[] input) {
        if (isImmediate) {
            return input[value];
        }
        return input[input[value]];
    }
}
