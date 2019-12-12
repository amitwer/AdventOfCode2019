package day5;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CommandToken {
    private final List<Boolean> isImmediateList;
    private CommandType type;
    private int[] params;

    public CommandToken(CommandType type, int modes) {
        this.type = type;
        this.params = new int[type.getNumOfParameters()];
        this.isImmediateList = new LinkedList<>();
        for (int i = 0; i < type.getNumOfParameters(); i++) {
            isImmediateList.add(modes % 10 == 1);
            modes = modes / 10;
        }
    }

    public CommandType getType() {
        return type;
    }

    public boolean isImmediate(int paramPosition) {
        if (type == CommandType.OUTPUT){
            return isImmediateList.get(paramPosition);
        }
        return isImmediateList.get(paramPosition) ||
                (paramPosition == params.length - 1 &&
                        !(type.isJump()&&isJumpConditionTrue()));
    }

    public int getNumOfParameters() {
        return type.getNumOfParameters();
    }

    public void setParameter(int index, int paramValue) {
        this.params[index] = paramValue;
    }

    public boolean isWritingToInput() {
        return type.isWritingToInput();
    }

    public int getTargetInputCell() {
        if (!isWritingToInput()) {
            throw new RuntimeException("Cmd <" + type + ">is not writing to input array");
        }
        return params[params.length - 1];
    }

    public Integer getResult(int[] input) {
        switch (type) {

            case HALT:
                return null;
            case ADD:
//                System.out.println(String.format("adding %d+%d and storing in %d", params[0], params[1], params[2]));
                return params[0] + params[1];
            case MULTIPLY:
//                System.out.println(String.format("multiply %d*%d and storing in %d", params[0], params[1], params[2]));
                return params[0] * params[1];
            case INPUT:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please insert a number");
                return scanner.nextInt();
            case OUTPUT:
                return params[0];
            case JUMP_TRUE:
            case JUMP_FALSE:
                return params[1];
            case LESS_THAN:
                return params[0] < params[1] ? 1 : 0;
            case EQ:
                return params[0] == params[1] ? 1 : 0;
        }
        throw new IllegalStateException("Not expecting to be here...");
    }

    public boolean hasOutput() {
        return this.type == CommandType.OUTPUT;
    }

    public boolean isJump() {
        if (type.isJump()) {
            System.out.println("Command is jump - " + type + " value is " + params[0] + "And jump decistion is <" + isJumpConditionTrue() + ">");
        }
        return type.isJump() && isJumpConditionTrue();
    }

    private boolean isJumpConditionTrue() {
        switch (type) {
            case JUMP_TRUE:
                return params[0] != 0;
            case JUMP_FALSE:
                return params[0] == 0;
            default:
                throw new IllegalStateException("Command of type <" + type + "> is not a jump");
        }
    }
}
