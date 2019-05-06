package map.basic;

public class Edge {
    public int value;
    public Node from;
    public Node to;

    public Edge(int value, Node from, Node to) {
        this.value = value;
        this.from = from;
        this.to = to;
    }
}
