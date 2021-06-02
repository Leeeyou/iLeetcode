package personalwebsite.graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 图的深度遍历
 * http://www.java2blog.com/2015/12/depth-first-search-in-java.html
 */
public class DfsDemo {

    static ArrayList<Node> nodes = new ArrayList<>();

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

        DfsDemo demo = new DfsDemo();

        System.out.println("The DFS traversal of the graph using stack ");
        demo.dfsUsingStack(matrix, node40);
        System.out.println();
        demo.clearVisitedFlags();

        System.out.println("The DFS traversal of the graph using recursion ");
        demo.dfs(matrix, node40);
    }

    // find neighbors of node using adjacency matrix
    // if matrix[i][j]==1, then nodes at index i and index j are connected
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
            if (matrix[index][j] == 1) neighbours.add(nodes.get(j));
        }
        return neighbours;
    }

    // Recursive DFS
    public void dfs(int[][] matrix, Node node) {
        System.out.print(node.data + "\t");
        ArrayList<Node> neighbours = findNeighbours(matrix, node);
        for (Node n : neighbours) {
            if (n != null && !n.visited) {
                dfs(matrix, n);
                n.visited = true;
            }
        }
    }

    // Iterative DFS using stack
    public void dfsUsingStack(int[][] matrix, Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        node.visited = true;
        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.print(element.data + "\t");

            ArrayList<Node> neighbours = findNeighbours(matrix, element);
            for (Node n : neighbours) {
                if (n != null && !n.visited) {
                    stack.add(n); // stack的特点天然跟递归思想match，先进后出
                    n.visited = true;
                }
            }
        }
    }

    public void clearVisitedFlags() {
        for (Node node : nodes) node.visited = false;
    }

    static class Node {
        int data;
        boolean visited;

        Node(int data) {
            this.data = data;
        }
    }

}
