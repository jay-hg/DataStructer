package graphics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null && end == null) return 0;
        if (start.length() == 0 && end.length() == 0) return 0;
        assert(start.length() == end.length());
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        dict.add(end);
        //最短路径问题
        //利用bfs遍历dict，直到访问到end节点
        //问题转化为节点之间有没有边的问题

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        int len = 0;
        while (!queue.isEmpty()) {
            //访问下一层
            len++;
            int levelLen = queue.size();
            for (int i = 0; i < levelLen; i++) {
                String currStr = queue.poll();
                if (currStr.equals(end)) {
                    return len;
                }
                if (visited.contains(currStr)) {
                    continue;
                }

                visited.add(currStr);
                //获取当前节点邻居入队
                offerNextLevel(queue, currStr, dict);
            }
        }
        return len;
    }

    private void offerNextLevel(Queue<String> queue, String currStr, Set<String> dict) {
        char[] currChars = currStr.toCharArray();
        int wordLen = currChars.length;
        for (int i = 0; i < wordLen; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (currChars[i] == c) {
                    continue;
                }
                currChars[i] = c;
                String changeStr = new String(currChars);
                if (dict.contains(changeStr)) {
                    queue.offer(changeStr);
                }
            }
            currChars = currStr.toCharArray();
        }
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        int ans = wl.ladderLength("hit","cog",set);
        System.out.println(ans);
    }
}
