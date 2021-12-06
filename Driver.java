import java.util.Scanner;
import java.util.Vector;

public class Driver {
  public static void main(String[] args) {
    // User inputs matrix instead
    Scanner input = new Scanner(System.in);
    Graph graph = new Graph();
    int amount;
    System.out.println("Please enter the amount of vertices for the graph");
    amount = input.nextInt();
    System.out.println("Creating amount");
    char currentVertex;
    for (int i = 0; i < amount; i++) {
      currentVertex = (char) ('A' + i);
      Vertex vertex = new Vertex(currentVertex);
      graph.addVertex(vertex);
    }
    Vector<Vertex> vertices = graph.getVertices();

    System.out.println("Your list of vertices");
    graph.printVertices();
    System.out.println();

    // Creating edges for the vertices
    for (int i = 0; i < graph.getVertices().size() - 1; i++) {
        for (int j = i + 1; j < vertices.size(); j++) {   
          System.out.println("Enter in the edge that is incident to " + vertices.get(i) + " and " + vertices.get(j));
          int weight = input.nextInt();
          Edge edge = new Edge(weight);
          if (weight != 0) {
            graph.addEdge(vertices.get(i), vertices.get(j), edge);
          }
        }
    }
    System.out.println("The graph has been created!");
    graph.printGraph();
    System.out.println();
    graph.printMatrix();
    System.out.println("To generate a coloring, enter any value to continue:");
    input.next();
    Color color = new Color();
    color.generateColoring(graph);
    graph.printGraph();
    graph.printMatrix();
    System.out.println("Chromatic Index is: " + color.getChromaticNumber());
    input.close();
  }
}