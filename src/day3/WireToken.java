package day3;

public class WireToken {
    private final String direction;
    private final int wireLength;

    public WireToken(String part) {
        this.direction =""+part.charAt(0);
        this.wireLength = Integer.parseInt(part.substring(1));
    }

    public int getWireLength() {
        return wireLength;
    }

    public String getDirection() {
        return direction;
    }
}
