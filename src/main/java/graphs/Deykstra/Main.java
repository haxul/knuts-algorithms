package graphs.Deykstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Map<String, Map<String, Integer>> weightGraph = new HashMap<>();
        weightGraph.put("start", Map.of(
                "a", 6,
                "b", 2)
        );
        weightGraph.put("a", Map.of("fin", 1));
        weightGraph.put("b", Map.of(
                "a", 3,
                "fin", 5
        ));
        weightGraph.put("fin", Map.of());

        Map<String, Integer> costs = new HashMap<>();
        costs.put("start", 0);
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", Integer.MAX_VALUE);

        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        var processed = new LinkedList<String>();
        searchShortestWay(parents, weightGraph, costs, processed);
        System.out.println(costs);

    }

    public static String findLowestCodeNode(Map<String, Integer> costs, LinkedList<String> processed) {
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;
        for (var node : costs.keySet()) {
            int cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

    public static void searchShortestWay(Map<String, String> parents, Map<String, Map<String, Integer>> graph, Map<String, Integer> costs, LinkedList<String> processed) {
        String node = findLowestCodeNode(costs, processed);
        while (node != null) {
            int cost = costs.get(node);
            Map<String, Integer> neighbors = graph.get(node);
            for (var n : neighbors.keySet()) {
                int newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findLowestCodeNode(costs, processed);
        }
        displayWay(parents, "fin");
    }

    public static String displayWay(Map<String,String> parents, String v) {
        if (v.equals("fin")) System.out.print("fin <=");
        if (v.equals("start")) return "start";
        String node = parents.get(v);
        System.out.print(node + " <= ");
        return displayWay(parents, node);
    }

}
