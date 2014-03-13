package testCode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import productiveCode.Field;
import productiveCode.Human;

public class HumanTest {

	@Test
	public void existenceTest() {
		Human human = new Human();
	}
	
	@Test
	public void killHumanTest() {
		Human human = new Human();
		Field field = new Field(20,20);
		field.bearAt(human, 2, 5);
	
		boolean success = field.killHuman(human);
		assertTrue(success);
	}
	
	
	
	

}
