package testCode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import productiveCode.Field;
import productiveCode.Game;
import productiveCode.Human;

public class GameTest {

	@Test
	public void existenceTest() {
		Game game = new Game(20, 20);
	}
	
	@Test
	public void setHumanTest() {
		Game game = new Game(20, 20);
		Human h1 = new Human(), h2 = new Human(), h3 = new Human(), h4 = new Human();
		game.setHuman(h1, 1,1);
		game.setHuman(h2, 2,2);
		game.setHuman(h3, 3,3);
		game.setHuman(h4, 4,4);
		
	}
	
	@Test
	public void checkGenerationNumberTest() {
		Game game = new Game(20, 20);
		game.next();
		game.next();
		game.next();
		boolean correct = (game.getGeneration() == 3);
		assertTrue(correct);
	}
	
}
