package map;

import map.basic.Graph;
import map.basic.GraphGenerator;
import map.basic.Node;

import java.util.*;

public class TopologySort {

    public static void main(String[] args) {
        Integer[][] input={{1,1,2},{2,1,3},{3,2,4},{4,3,4}};
        Graph graph=GraphGenerator.createGraph(input);
        List<Node> result=sortedTopology(graph);
        for (Node node:result){
            System.out.println(node.value);
        }
    }

    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0)
                zeroInQueue.add(node);
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0)
                    zeroInQueue.add(next);
            }
        }
        return result;
    }
}
