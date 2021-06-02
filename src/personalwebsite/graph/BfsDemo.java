package personalwebsite.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的广度遍历
 * http://www.java2blog.com/2015/12/breadth-first-search-in-java.html
 */
public class BfsDemo {

    static ArrayList<Node> nodes = new ArrayList<>();
    private final Queue<Node> queue;

    public BfsDemo() {
        queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);

        nodes.add(node40);
        nodes.add(node10);
        nodes.add(node20);
        nodes.add(node30);
        nodes.add(node60);
        nodes.add(node50);
        nodes.add(node70);

        int[][] matrix = {
                {0, 1, 1, 0, 0, 0, 0},  // Node 1: 40
                {0, 0, 0, 1, 0, 0, 0},  // Node 2 :10
                {0, 1, 0, 1, 1, 1, 0},  // Node 3: 20
                {0, 0, 0, 0, 1, 0, 0},  // Node 4: 30
                {0, 0, 0, 0, 0, 0, 1},  // Node 5: 60
                {0, 0, 0, 0, 0, 0, 1},  // Node 6: 50
                {0, 0, 0, 0, 0, 0, 0},  // Node 7: 70
        };
        System.out.println("The BFS traversal of the graph is ");
        BfsDemo bfsExample = new BfsDemo();
        bfsExample.bfs(matrix, node40);
    }

    // find neighbors of node using adjacency matrix
    // if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
    public ArrayList<Node> findNeighbours(int[][] matrix, Node node) {
        int index = -1;
        ArrayList<Node> neighbours = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(node)) {
                index = i;
                break;
            }
        }
        if (index == -1) return neighbours;
        for (int j = 0; j < matrix[index].length; j++) {
            if (matrix[index][j] == 1) {
                neighbours.add(nodes.get(j));
            }
        }
        return neighbours;
    }

    public void bfs(int[][] matrix, Node node) {
        queue.add(node);
        node.visited = true;
        while (!queue.isEmpty()) {
            Node element = queue.remove();
            System.out.print(element.data + "\t");
            ArrayList<Node> neighbours = findNeighbours(matrix, element);
            for (Node n : neighbours) {
                if (n != null && !n.visited) {
                    queue.add(n);
                    n.visited = true;
                }
            }
        }
    }

    static class Node {
        int data;
        boolean visited;

        Node(int data) {
            this.data = data;
        }
    }

}
