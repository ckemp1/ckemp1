public class Edge {
  private int weight;
  private int color;
  private Vertex vertex;

  

  Edge(){
    this.weight = 0;
    this.color = 0;
    this.vertex = new Vertex();
  }
  Edge(int weight) {
    this.weight = weight;
    this.color = 0;
  }

  public Boolean validateEdge(Edge e) {
    if(e.getWeight() > 0) return true;
    return false;
  }
  
  public Boolean edgeExists() {
    if(this.weight != 0) return true;
    return false;
  }

  // Setters/getters

  public Vertex getVertex() {
    return this.vertex;
  }

  public void setVertex(Vertex from) {
    this.vertex = from;
  }

 
  public void setBoth(Edge e) {
		this.weight = e.weight;
    this.color = e.color;
	}
  
  public int getWeight() {
    return this.weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getColor() {
    return this.color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public void resetEdge(Edge e) {
    this.color = 0;
    this.weight = 0;
  }
  // Simple tostring function for displaying in console

  public String toString(){
    return getWeight() + ", " + getColor();
  }

 
}
