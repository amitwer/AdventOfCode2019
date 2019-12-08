package day3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GridNode {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridNode gridNode = (GridNode) o;
        return x == gridNode.x &&
                y == gridNode.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    private int x;
    private int y;
    private Map<String,Integer> wires;

    public GridNode(int x, int y) {
        this.x = x;
        this.y = y;
        this.wires = new HashMap<>();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isIntersection() {
        return wires.size() > 1;


    }

    public int getDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    public void addWire(String wireId, Integer distance) {
        this.wires.putIfAbsent(wireId,distance);
    }

    public  int getCombinedDistance() {
        return this.wires.values().stream().mapToInt(Integer::intValue).sum();
    }
}
