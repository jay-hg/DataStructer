package graphics;

import java.util.*;

public class BipartialGraph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();
            // initialize graph
            List<UndirectedGraphNode> graph = new ArrayList<UndirectedGraphNode>();
            for (int n = 1; n <= N; n++) {
                graph.add(new UndirectedGraphNode(n));
            }
            // construct graph
            for (int j = 1; j <= M; j++) {
                int u = in.nextInt(), v = in.nextInt();
                graph.get(u - 1).neighbors.add(graph.get(v - 1));
                graph.get(v - 1).neighbors.add(graph.get(u - 1));
            }
            // solve
            if (solve(graph)) {
                System.out.println("Correct");
            } else {
                System.out.println("Wrong");
            }
        }
    }

    public static boolean solve(List<UndirectedGraphNode> graph) {
        for (UndirectedGraphNode node : graph) {
            if (node.color == 0) {
                node.color = 1;
                Queue<UndirectedGraphNode> queue = new LinkedList<>();
                queue.offer(node);
                while (!queue.isEmpty()) {
                    int len = queue.size();
                    for (int i = 0; i < len; i++) {
                        UndirectedGraphNode curr = queue.poll();
                        for (UndirectedGraphNode n : curr.neighbors) {
                            if (n.color == 0) {
                                n.color = -1 * curr.color;
                                queue.offer(n);
                            } else if (n.color == curr.color) {
                                return false;
                            }

                        }
                    }
                }
            }
        }
        return true;
    }
}

class UndirectedGraphNode {
    int label;
    int color;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        this.label = x;
        this.color = 0;
        this.neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
