
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * An undirected graph stored as an adjacency list.
 *
 * Vertices are numbered from 0 through vertexCount - 1. Breadth-first search
 * uses a queue; depth-first search explores each branch before backtracking.
 */
public class Graphs {

    private final List<List<Integer>> adjacencyList;

    public Graphs(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("Vertex count must be positive");
        }
        adjacencyList = new ArrayList<List<Integer>>(vertexCount);
        for (int vertex = 0; vertex < vertexCount; vertex++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
    }

    /** Adds an undirected edge between two vertices: O(1). */
    public void addEdge(int from, int to) {
        validateVertex(from);
        validateVertex(to);
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
    }

    /** Visits vertices level by level using a queue: O(V + E). */
    public List<Integer> breadthFirstSearch(int start) {
        validateVertex(start);
        boolean[] visited = new boolean[adjacencyList.size()];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        List<Integer> order = new ArrayList<Integer>();

        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            order.add(vertex);
            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return order;
    }

    /** Visits a branch as far as possible before backtracking: O(V + E). */
    public List<Integer> depthFirstSearch(int start) {
        validateVertex(start);
        List<Integer> order = new ArrayList<Integer>();
        depthFirstSearch(start, new boolean[adjacencyList.size()], order);
        return order;
    }

    private void depthFirstSearch(int vertex, boolean[] visited, List<Integer> order) {
        visited[vertex] = true;
        order.add(vertex);
        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                depthFirstSearch(neighbor, visited, order);
            }
        }
    }

    private void validateVertex(int vertex) {
        if (vertex < 0 || vertex >= adjacencyList.size()) {
            throw new IllegalArgumentException("Invalid vertex: " + vertex);
        }
    }

    @Override
    public String toString() {
        return adjacencyList.toString();
    }

    public static void main(String[] args) {
        Graphs graph = new Graphs(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("Adjacency list: " + graph);
        System.out.println("BFS from 0: " + graph.breadthFirstSearch(0));
        System.out.println("DFS from 0: " + graph.depthFirstSearch(0));
    }
}
