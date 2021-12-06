import java.util.*;
public class Graph {
  private Vector<Vertex> vertices;
  private ArrayList<ArrayList<Edge>> adjacencyMatrix;

  Graph() {
    vertices = new Vector<Vertex>();
    adjacencyMatrix = new ArrayList<ArrayList<Edge>>();
  }
  public void addVertex(Vertex vertex){
    vertices.add(vertex);
    ArrayList<Edge> temp = new ArrayList<>();
    adjacencyMatrix.add(temp);
    for(int i = 0; i < vertices.size(); i++) {
      for(int j = 0; j < vertices.size(); j++) {
        Edge e = new Edge();
        if(i < vertices.size()- 1) { 
          j = vertices.size()-1;
        }
        adjacencyMatrix.get(i).add(e);
      }
    }
  }
  
  public void addEdge(Vertex from, Vertex to, Edge edge) { 
    if(vertices.contains(from) && vertices.contains(to) && edge.getWeight() > 0) {
        adjacencyMatrix.get(vertices.indexOf(from)).get(vertices.indexOf(to)).setWeight(edge.getWeight());
        adjacencyMatrix.get(vertices.indexOf(to)).get(vertices.indexOf(from)).setWeight(edge.getWeight());
        edge.setVertex(to);
        System.out.println("Undirected edge created from " + from.getName() + " to " + to.getName() + " with edge of weight " + edge.getWeight());
    }
    else {
      System.out.println("Error, the vertices or edge given is not valid");
    }
    System.out.println("\n");
  }

  // Check the edges colors for the current vertex and then adjacent vertex
  public Boolean checkEdge(int fromIndex, int toIndex, int color) {
    // From Vertex - current vertex
    for(Edge edge : adjacencyMatrix.get(fromIndex)) {
      if(edge.getColor() == color) {
        return false;
      }
    }
    // To Vertex - the adjacent vertex connected by the current edge
    for(Edge edge : adjacencyMatrix.get(toIndex)) {
      if(edge.getColor() == color) {
        return false;
      }
    }
    return true;
  }

  public boolean checkDegree(Vertex vertex, int degree) {
    if((vertices.size() - vertices.indexOf(vertex)) - degree <= 0) return false;
    return true;
  }
  public void resetEdges(ArrayList<Edge> edges) {
    for(Edge edge : edges) {
      edge.setWeight(0);
    }
  }

  public ArrayList<ArrayList<Edge>> getAdjacencyMatrix() {
    return adjacencyMatrix;
  }

  public Vector<Vertex> getVertices() {
    return vertices;
  }

  public void printVertices(){
    System.out.println("--All of the vertices in the graph--");
    for (Vertex vector : vertices) {
      System.out.println("Vector: " + vector.getName());
    }
  }
  public void printMatrix(){
    System.out.println("--Matrix of the Adjacency Matrix each item is an edge with the weight and color (0 represents initial colors before coloring edges)--");
    int vertexIndex = 0;
    for(ArrayList<Edge> list : adjacencyMatrix) {
      System.out.print(vertices.get(vertexIndex) + ": ");
      vertexIndex++;
      for(Edge e : list) {
        System.out.print(e.toString() + "  |  ");
      }
      System.out.print("\n");
    }
  }
  public void printGraph() {
    System.out.println("--Visual Graph--");
    for(int i = 0; i < vertices.size(); i++) {
      System.out.print(vertices.get(i).getName());
      int degree = 0;
      for(int j = 0; j < vertices.size(); j++) {
        Edge edge = adjacencyMatrix.get(i).get(j);
        if(edge.edgeExists()) {
          if(degree == 0) System.out.println("<--(" + edge.toString() + ")-->" + vertices.get(j).getName());
          else System.out.println("^\n|\n--(" + edge.toString() + ")-->" + vertices.get(j).getName());
          degree++;
        }
      }
      System.out.println();
    }
  }
}
