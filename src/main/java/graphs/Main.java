package graphs;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var graph = Map.of(
                "A", List.of("B", "C"),
                "B", List.of("A", "C"),
                "C", List.of("A", "B", "D", "E"),
                "D", List.of("C", "E"),
                "E", List.of("C", "D")
        );

        var checked = new HashSet<String>();
        var q = new LinkedList<String>();
        q.add("A");
        bfs(graph, q, checked);
    }

    public static Set<String> bfs(Map<String,List<String>> graph, LinkedList<String> queue, Set<String> checked) {
        if (queue.size() == 0) return checked;
        var first = queue.pollFirst();
        if (checked.contains(first)) return bfs(graph, queue, checked);
        System.out.println(first);
        checked.add(first);
        queue.addAll(graph.get(first));
        return bfs(graph, queue, checked);
    }
}
