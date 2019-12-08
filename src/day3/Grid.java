package day3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Grid {
    Map<GridNode, GridNode> nodes;
    private int currentX;
    private int currentY;
    private int currentDist;

    public Grid() {
        nodes = new HashMap<>();
    }

    public void addWire(String wireInput, String wireId) {
        this.currentY = 0;
        this.currentX = 0;
        this.currentDist=0;
        WireParser parser = new WireParser(wireInput);
        while (parser.hasNextToken()) {
            addSectionToGrid(parser.next(), wireId);
        }
    }

    private void addSectionToGrid(WireToken section, String wireId) {
        for (int i = 0; i < section.getWireLength(); i++) {
            GridNode node = getNextNode(section.getDirection());
            node.addWire(wireId, this.currentDist);

        }
    }

    private GridNode getNextNode(String direction) {
        switch (direction) {
            case "R":
                this.currentX++;
                break;
            case "L":
                this.currentX--;
                break;
            case "U":
                this.currentY--;
                break;
            case "D":
                this.currentY++;
                break;
            default:
                throw new RuntimeException("Unrecognized direction: " + direction);
        }
        this.currentDist++;
        GridNode gridNode = new GridNode(currentX, currentY);
        gridNode = nodes.getOrDefault(gridNode, gridNode);
        nodes.put(gridNode, gridNode);
        return gridNode;
    }

    public GridNode findClosestIntersection() {
        return nodes.keySet().stream()
                .filter(GridNode::isIntersection)
                .min(Comparator.comparingInt(GridNode::getDistance))
                .orElseThrow(RuntimeException::new);
    }

    public GridNode findShortestPathIntersection() {
        return nodes.keySet().stream()
                .filter(GridNode::isIntersection)
                .min(Comparator.comparingInt(GridNode::getCombinedDistance))
                .orElseThrow(RuntimeException::new);
    }
}
