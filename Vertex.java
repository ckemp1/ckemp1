public class Vertex {
	private char name;
	private int degree;

	public int getDegree() {
		return this.degree;
	}

	Vertex(char newName){
		name = newName;
		degree = 0;
	}
	Vertex() {
		this.name = ' ';
		this.degree = 0;
	}

	public boolean setDegree(int degree) {
		if(degree < 0) return false;
		this.degree = degree;
		return true;
	}

	public char getName() {
		return this.name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public String toString() {
		return "Vertex: " + getName();
	}
}
