package graphics;

import java.util.ArrayList;

public class RouteBetweenTwoNode {
    private boolean flag = false;
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        dfs(s,t);
        return flag;
    }

    private void dfs(DirectedGraphNode s, DirectedGraphNode t) {
        if (s == null || t == null) {
            return;
        }

        if (s.label == t.label) {
            flag = true;
            return;
        }
        for (DirectedGraphNode node : s.neighbors) {
            dfs(node,t);
        }
    }
}
