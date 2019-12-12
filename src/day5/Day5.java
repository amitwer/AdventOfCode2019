package day5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day5 {
    public static void main(String[] args) {
        int[] input = new int[]{3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
//        int[] input = new int[]{3, 225, 1, 225, 6, 6, 1100, 1, 238, 225, 104, 0, 101, 71, 150, 224, 101, -123, 224, 224, 4, 224, 102, 8, 223, 223, 101, 2, 224, 224, 1, 224, 223, 223, 2, 205, 209, 224, 1001, 224, -3403, 224, 4, 224, 1002, 223, 8, 223, 101, 1, 224, 224, 1, 223, 224, 223, 1101, 55, 24, 224, 1001, 224, -79, 224, 4, 224, 1002, 223, 8, 223, 101, 1, 224, 224, 1, 223, 224, 223, 1, 153, 218, 224, 1001, 224, -109, 224, 4, 224, 1002, 223, 8, 223, 101, 5, 224, 224, 1, 224, 223, 223, 1002, 201, 72, 224, 1001, 224, -2088, 224, 4, 224, 102, 8, 223, 223, 101, 3, 224, 224, 1, 223, 224, 223, 1102, 70, 29, 225, 102, 5, 214, 224, 101, -250, 224, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 3, 224, 1, 223, 224, 223, 1101, 12, 52, 225, 1101, 60, 71, 225, 1001, 123, 41, 224, 1001, 224, -111, 224, 4, 224, 102, 8, 223, 223, 1001, 224, 2, 224, 1, 223, 224, 223, 1102, 78, 66, 224, 1001, 224, -5148, 224, 4, 224, 1002, 223, 8, 223, 1001, 224, 2, 224, 1, 223, 224, 223, 1101, 29, 77, 225, 1102, 41, 67, 225, 1102, 83, 32, 225, 1101, 93, 50, 225, 1102, 53, 49, 225, 4, 223, 99, 0, 0, 0, 677, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1105, 0, 99999, 1105, 227, 247, 1105, 1, 99999, 1005, 227, 99999, 1005, 0, 256, 1105, 1, 99999, 1106, 227, 99999, 1106, 0, 265, 1105, 1, 99999, 1006, 0, 99999, 1006, 227, 274, 1105, 1, 99999, 1105, 1, 280, 1105, 1, 99999, 1, 225, 225, 225, 1101, 294, 0, 0, 105, 1, 0, 1105, 1, 99999, 1106, 0, 300, 1105, 1, 99999, 1, 225, 225, 225, 1101, 314, 0, 0, 106, 0, 0, 1105, 1, 99999, 1107, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 329, 101, 1, 223, 223, 7, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 344, 1001, 223, 1, 223, 7, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 359, 101, 1, 223, 223, 1108, 226, 226, 224, 1002, 223, 2, 223, 1005, 224, 374, 1001, 223, 1, 223, 8, 226, 677, 224, 1002, 223, 2, 223, 1006, 224, 389, 1001, 223, 1, 223, 1108, 226, 677, 224, 1002, 223, 2, 223, 1006, 224, 404, 101, 1, 223, 223, 1107, 677, 226, 224, 102, 2, 223, 223, 1006, 224, 419, 101, 1, 223, 223, 1007, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 434, 101, 1, 223, 223, 7, 677, 226, 224, 102, 2, 223, 223, 1006, 224, 449, 1001, 223, 1, 223, 1008, 226, 677, 224, 1002, 223, 2, 223, 1006, 224, 464, 101, 1, 223, 223, 8, 677, 677, 224, 1002, 223, 2, 223, 1006, 224, 479, 101, 1, 223, 223, 108, 226, 226, 224, 102, 2, 223, 223, 1005, 224, 494, 101, 1, 223, 223, 1107, 226, 677, 224, 1002, 223, 2, 223, 1006, 224, 509, 101, 1, 223, 223, 107, 226, 226, 224, 1002, 223, 2, 223, 1006, 224, 524, 1001, 223, 1, 223, 107, 677, 677, 224, 1002, 223, 2, 223, 1005, 224, 539, 101, 1, 223, 223, 1007, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 554, 101, 1, 223, 223, 108, 677, 677, 224, 102, 2, 223, 223, 1005, 224, 569, 101, 1, 223, 223, 107, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 584, 101, 1, 223, 223, 1008, 226, 226, 224, 102, 2, 223, 223, 1006, 224, 599, 101, 1, 223, 223, 1108, 677, 226, 224, 1002, 223, 2, 223, 1006, 224, 614, 101, 1, 223, 223, 8, 677, 226, 224, 102, 2, 223, 223, 1005, 224, 629, 1001, 223, 1, 223, 1008, 677, 677, 224, 102, 2, 223, 223, 1006, 224, 644, 101, 1, 223, 223, 1007, 226, 677, 224, 102, 2, 223, 223, 1005, 224, 659, 101, 1, 223, 223, 108, 226, 677, 224, 102, 2, 223, 223, 1006, 224, 674, 101, 1, 223, 223, 4, 223, 99, 226};
        CommandParser commandParser = new CommandParser();
        CommandToken cmd = null;
        int cmdPointer = 0;
        do {
            cmd = commandParser.parseCommand(input[cmdPointer]);
            cmdPointer++;
            for (int i = 0; i < cmd.getNumOfParameters(); i++) {
                cmd.setParameter(i, getParamValue(cmdPointer + i, cmd.isParamByValue(i), input));
            }
            if (cmd.isWritingToInput()) {
                input[cmd.getTargetInputCell()] = cmd.getResult(input);
            }
            if (cmd.hasOutput()) {
                System.out.println(cmd.getResult(input));
            }
            if (cmd.isJump()){
                cmdPointer = cmd.getResult(input);
            }
            else {
                cmdPointer += cmd.getNumOfParameters();
            }
        } while (CommandType.HALT != cmd.getType());
        System.out.println(Arrays.stream(input).mapToObj(Integer::toString).collect(Collectors.joining(",")));

    }

    private static int getParamValue(int value, boolean isParamByValue, int[] input) {
        if (isParamByValue)
            return input[value];
        return input[input[value]];
    }
}
