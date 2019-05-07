package map.MST;

import map.basic.*;

import java.util.*;

public class KruskalMST {

    public static void main(String[] args) {
        Integer[][] input={{1,1,2},{2,1,3},{3,2,4},{4,3,4}};
        Graph graph= GraphGenerator.createGraph(input);
        Set<Edge> result=kruskalMST(graph);

    }

    public  static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }

    public static Set<Edge> kruskalMST(Graph graph){
        UnionFind unionFind =new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(new EdgeComparator());
        for (Edge edge:graph.edges){
            priorityQueue.add(edge);
        }
        Set<Edge> result=new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge=priorityQueue.poll();
            if(!unionFind.isSameSet(edge.from,edge.to)){
                result.add(edge);
                unionFind.union(edge.from,edge.to);
            }
        }
        return result;
    }
}
