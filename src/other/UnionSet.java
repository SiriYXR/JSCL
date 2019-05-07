package other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UnionSet {
    public static void main(String[] args) {
        Data[] datas = new Data[5];
        List<Data> list = new LinkedList<Data>();
        for (int i = 0; i < 5; i++) {
            datas[i] = new Data();
            list.add(datas[i]);
        }
        UnionFindSet unionFindSet = new UnionFindSet(list);
        unionFindSet.union(datas[1],datas[2]);
        System.out.println(unionFindSet.isSameSet(datas[1],datas[2]));
    }

    public static class Data {

    }

    public static class UnionFindSet {
        //(key,value)表示，key的父节点，是value，（Data_A，Data_B）代表，Data_A的父节点是Data_B
        public HashMap<Data, Data> fatherMap;
        public HashMap<Data, Integer> sizeMap;

        public UnionFindSet(List<Data> nodes) {
            fatherMap = new HashMap<Data, Data>();
            sizeMap = new HashMap<Data, Integer>();
            makeSets(nodes);
        }

        private void makeSets(List<Data> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Data node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Data findHead(Data node) {
            Data father = fatherMap.get(node);
            if (father != node)
                father = findHead(father);
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Data a, Data b) {
            return findHead(a) == findHead(b);
        }

        public void union(Data a, Data b) {
            if (a == null || b == null)
                return;
            Data aHead = findHead(a);
            Data bHead = findHead(b);
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }
}
