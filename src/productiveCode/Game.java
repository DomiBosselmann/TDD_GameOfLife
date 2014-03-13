package productiveCode;

public class Game {
	
	private int width, height;
	private Field field;
	private int generation = 0;

	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		this.field = new Field(width, height);
	}

	public void setHuman(Human human, int x, int y) {
		this.field.bearAt(human, x, y);
	}

	public void next() {
		this.generation++;
	}
	
	public int getGeneration() {
		return this.generation;
	}
}
