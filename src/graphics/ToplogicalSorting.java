package graphics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ToplogicalSorting {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        //答案列表
        ArrayList<DirectedGraphNode> ansList = new ArrayList<>();
        //构建一个map维护每个节点的入度
        Map<DirectedGraphNode, Integer> graphMap = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            graphMap.putIfAbsent(node, 0);
            for (DirectedGraphNode e : node.neighbors) {
                graphMap.put(e, graphMap.getOrDefault(e, 0) + 1);
            }
        }

        for (DirectedGraphNode node : graph) {
            dfs(node, graphMap, ansList);
        }
        return ansList;
    }

    private void dfs(DirectedGraphNode node, Map<DirectedGraphNode, Integer> graphMap, ArrayList<DirectedGraphNode> ansList) {
        int inDegree = graphMap.get(node);
        if (inDegree == 0) {
            ansList.add(node);
            //模拟将node从图中移除
            graphMap.put(node, graphMap.get(node) - 1);
            for (DirectedGraphNode e : node.neighbors) {
                //每个邻居入度减1
                graphMap.put(e, graphMap.get(e) - 1);
                dfs(e,graphMap,ansList);
            }
        }
    }
}
