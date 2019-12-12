package day6;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Node {
    private String id;
    private Node parent;

    public Node(String id) {
        this.id = id;
        parent = null;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getNumOfOrbits() {
        return Objects.nonNull(parent) ? 1 + parent.getNumOfOrbits() : 0;
    }

    public List<Node> getAllParents() {
        if (Objects.nonNull(parent)) {
            LinkedList<Node> parents = new LinkedList<>(parent.getAllParents());
            parents.add(parent);
            return parents;
        }
        return new LinkedList<>();
    }
}
