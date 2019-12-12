package day5;

import java.util.Arrays;

public enum  CommandType {
    HALT(99,0, false, false),
    ADD(1,3, true, false),
    MULTIPLY(2,3, true, false),
    INPUT(3,1, true, false),
    OUTPUT(4,1, false, false),
    JUMP_TRUE(5,2, false, true),
    JUMP_FALSE(6,2, false, true),
    LESS_THAN(7,3, true, false),
    EQ(8,3, true, false),

            ;

    private final int code;
    private final int numOfParameters;

    private boolean isWritingToInput;
    private final boolean jump;

    CommandType(int code, int numOfParameters, boolean isWritingToInput, boolean jump) {
        this.code = code;
        this.numOfParameters = numOfParameters;
        this.isWritingToInput = isWritingToInput;
        this.jump = jump;
    }

    public static CommandType identifyByNum(int cmd) {
        return Arrays.stream(values()).filter(v->v.code==cmd).findFirst()
                .orElseThrow(
                        ()->new RuntimeException("Could not identify command <"+cmd+">"));
    }

    public int getNumOfParameters() {
        return numOfParameters;
    }

    public boolean isWritingToInput() {
        return this.isWritingToInput;
    }

    public boolean isJump() {
        return jump;
    }
}
