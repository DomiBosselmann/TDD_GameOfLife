package productiveCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Field {
	private int width, height;
	private HashMap<Integer, Human> playground = new HashMap<>();
	
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public HashMap<Integer, Human> getPlayground() {
		return playground;
	}

	public boolean bearAt(Human human, int x, int y) {
		
		if (null == human) {
			return false;
		}
		
		int key = this.getFieldKeyFor(x, y);
		if (this.playground.containsKey(key)) {
			return false;
		}
		
		this.playground.put(key, human);

		return true;
	}

	public Human getHuman(int x, int y) {
		int key = this.getFieldKeyFor(x, y);
		Human human = this.playground.get(key);
		return human;
	}
	
	private int getFieldKeyFor(int x, int y) {
		
		int newX = ((x % this.width) + this.width) % this.width;
		int newY = ((y % this.height) + this.height) % this.height;
		
		return newX * this.width + newY;
	}
	
	public boolean killHuman(Human human) {
		if (null == human) {
			return false;
		}
		
		
		Iterator<Integer> iter = this.playground.keySet().iterator();
		while (iter.hasNext()) {
			Integer potentialVictimKey = iter.next();
			Human potentialVictim = this.playground.get(potentialVictimKey);
			if (potentialVictim == human) {
				this.playground.remove(potentialVictimKey);
				return true;
			}
		}
		
		return false;
	}

	public int countNeightbours(int x, int y) {
		int count = 0;
		int size = 1;
		
		for (int i = x - size; i <= x + size; i++) {
			for (int j = y - size; j <= y + size; j++) {
				if (i == x && j == y) {
					continue;
				}
			
				int keyToTest = this.getFieldKeyFor(i, j);
				
				if (null != this.playground.get(keyToTest)) {
					count++;
				}
			}
		}
		
		return count;
	}

	public HashMap<Human, Integer> checkNeighbours() {
		HashMap<Human, Integer> checkedNeighbours = new HashMap<>();
		Iterator<Entry<Integer, Human>> iter = this.playground.entrySet().iterator();
		
		while (iter.hasNext()) {
			Entry<Integer, Human> entry = iter.next();
			Human human = entry.getValue();
			int y = entry.getKey() % this.width;
			int x = (int) (entry.getKey() / this.width);
			int neighbours = this.countNeightbours(x, y);
			
			checkedNeighbours.put(human, neighbours);
		}
		
		return checkedNeighbours;
	}

}
