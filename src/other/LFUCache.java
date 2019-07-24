package other;

import java.util.*;

public class LFUCache {
    class LFUNode {
        int key;
        int val;
        int frequent;

        public LFUNode(int key, int val, int frequent) {
            this.key = key;
            this.val = val;
            this.frequent = frequent;
        }
    }

    TreeMap<Integer, List<LFUNode>> frequentMap;
    Map<Integer, LFUNode> nodeMap;
    int capacity;
    int used = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        frequentMap = new TreeMap<>();
        nodeMap = new HashMap<>();
    }

    public int get(int key) {
        LFUNode node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }

        //改变使用频率
        rmFrequentCount(node);
        addFrequentCount(node);
        setFrequentCount(node);
        //返回结果
        return node.val;
    }

    private void setFrequentCount(LFUNode node) {
        List<LFUNode> list = frequentMap.get(node.frequent);
        if (list == null) {
            list = new LinkedList<LFUNode>();
        }
        list.add(node);
        frequentMap.put(node.frequent, list);
        nodeMap.put(node.key, node);
    }

    private void addFrequentCount(LFUNode node) {
        node.frequent ++;
    }

    private void rmFrequentCount(LFUNode node) {
        List<LFUNode> list = frequentMap.get(node.frequent);
        list.remove(node);
        if (list.size() == 0) {
            frequentMap.remove(node.frequent);
        }
    }

    public void put(int key, int value) {
        LFUNode node = nodeMap.get(key);
        if (node != null) {
            node.val = value;
            rmFrequentCount(node);
            addFrequentCount(node);
        } else {
            node = new LFUNode(key, value, 1);
            used ++;

            //置换
            if (used > capacity) {
                used --;
                Map.Entry<Integer,List<LFUNode>> entry = frequentMap.firstEntry();
                if (entry == null) {
                    return;
                }
                LFUNode rmNode = entry.getValue().get(0);
                rmFrequentCount(rmNode);
                nodeMap.remove(rmNode.key);
            }
        }
        setFrequentCount(node);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0);
        cache.put(0,0);
        System.out.println(cache.get(0));
    }

    public static void test1() {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
