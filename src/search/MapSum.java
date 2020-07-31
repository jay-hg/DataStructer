package search;

class MapSum {

    private int value;
    private char character;
    private MapSum[] nodes = new MapSum[26];

    /** Initialize your data structure here. */
    public MapSum() {
        value = 0;
        character = ' ';
    }

    public void insert(String key, int val) {
        MapSum idx = this;
        char[] array = key.toCharArray();
        for (char c : array) {
            MapSum node = idx.nodes[c - 'a'];
            if (node == null) {
                node = new MapSum();
                node.character = c;
                idx.nodes[c - 'a'] = node;
            }
            idx = node;
        }
        idx.value = val;
    }

    public int sum(String prefix) {
        MapSum idx = this;
        char[] array = prefix.toCharArray();
        for (char c : array) {
            idx = idx.nodes[c - 'a'];
            if (idx == null) {
                return 0;
            }
        }

        return sum(idx);
    }

    private int sum(MapSum idx) {
        int ret = idx.value;
        for (MapSum node : idx.nodes) {
            if (node != null) {
                ret += sum(node);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
        System.out.println(mapSum.sum("apple"));
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app",2);
        System.out.println(mapSum.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
