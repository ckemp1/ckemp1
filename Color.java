import java.util.Vector;
import java.util.ArrayList;
public class Color {
  private int chromaticNumber;
  
  public void generateColoring(Graph graph) {
    Vector<Vertex> vertices = graph.getVertices();
    ArrayList<ArrayList<Edge>> adjacencyMatrix = graph.getAdjacencyMatrix();
    int currentLabel;
    // Looping through each vertex in adjacentMatrix
    for(int i = 0; i < vertices.size(); i++) {
      currentLabel = 1;
      // Checking each adjacent vertex for the coloring
      for(int j = i; j < vertices.size(); j++) {
        // First, the edge must exist, meaning the weight is > 0
        if(adjacencyMatrix.get(i).get(j).edgeExists()) {
          // Second we must check the labeling for the edges incident to both vertices
          if(!graph.checkEdge(i,j, currentLabel)) {
            // If there is a repeat color, then we want 
            // to redo that coloring until we get a color that works for that edge
            currentLabel++;
            j--;
          }
          else{
            // Setting the color/label of both incident vertices to the edge
            adjacencyMatrix.get(i).get(j).setColor(currentLabel);
            adjacencyMatrix.get(j).get(i).setColor(currentLabel);
          }
        }
      }
      // Setting the chromatic index to the largest that it could be for the coloring
      if(chromaticNumber < currentLabel) chromaticNumber = currentLabel;
    }
    
  }
  public int getChromaticNumber() {
    return this.chromaticNumber;
  }

  }

