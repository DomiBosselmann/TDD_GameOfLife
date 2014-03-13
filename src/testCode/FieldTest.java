package testCode;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import productiveCode.Field;
import productiveCode.Game;
import productiveCode.Human;


public class FieldTest {
	

	@Test
	public void existenceTest() {
		Field field = new Field(20,20);
	}
	
	@Test
	public void hasPlaygroundTest() {
		Field field = new Field(10,20);
		boolean hasPlayground = field.getPlayground() instanceof HashMap;
		assertTrue(hasPlayground);
	}
	
	@Test
	public void bearHuman1Test() {
		Human human = new Human();
		Field field = new Field(20,20);
		boolean success = field.bearAt(human, 2, 2);
		assertTrue(success);
	}
	
	@Test
	public void bearHuman2Test() {
		Human human = new Human();
		Field field = new Field(20,20);
		boolean success = field.bearAt(human, -2, 2);
		assertTrue(success);
	}
	
	@Test
	public void bearHuman3Test() {
		Human human = new Human();
		Field field = new Field(20,20);
		boolean success = field.bearAt(human, 2, -2);
		assertTrue(success);
	}
	
	@Test
	public void bearHumanTwiceFailTest() {
		Human firstHuman = new Human();
		Human secondHuman = new Human();
		Field field = new Field(20,20);
		field.bearAt(firstHuman, 2, -2);
		boolean success = field.bearAt(secondHuman, 2, -2);
		assertFalse(success);
	}
	
	@Test
	public void bearTwoHumansTest() {
		Human firstHuman = new Human();
		Human secondHuman = new Human();
		Field field = new Field(20,20);
		field.bearAt(firstHuman, -2, 3);
		boolean success = field.bearAt(secondHuman, 18,3);
		assertFalse(success);
	}
	
	@Test
	public void bearHuman4Test() {
		Human inputHuman = new Human();
		Field field = new Field(20,20);
		field.bearAt(inputHuman, 2, 22);
	
		Human outputHuman = field.getHuman(2,22);
		boolean success = inputHuman.equals(outputHuman);
		assertTrue(success);
	}
	
	@Test
	public void bearHumanWithWrapAround1Test() {
		Human inputHuman = new Human();
		Field field = new Field(20,20);
		field.bearAt(inputHuman, 2, 22);
	
		Human outputHuman = field.getHuman(2,2);
		boolean success = inputHuman.equals(outputHuman);
		assertTrue(success);
	}
	
	@Test
	public void getNullHumanTest() {
		Field field = new Field(20,20);
	
		Human outputHuman = field.getHuman(2,2);
		boolean emptyCell = outputHuman == null;
		assertTrue(emptyCell);
	}
	
	@Test
	public void bearHumanWithWrapAround2Test() {
		Human inputHuman = new Human();
		Field field = new Field(20,20);
		field.bearAt(inputHuman, 22, 2);
	
		Human outputHuman = field.getHuman(2,2);
		boolean success = inputHuman.equals(outputHuman);
		assertTrue(success);
	}

	
	@Test
	public void bearNullHumanFail1Test() {
		Field field = new Field(15,1);
		boolean success = field.bearAt(null, 2, -2);
		assertFalse(success);
	}
	
	@Test
	public void killHumanTest() {
		Human human = new Human();
		Field field = new Field(20,20);
		field.bearAt(human, 2, 5);
	
		boolean success = field.killHuman(human);
		assertTrue(success);
	}
	
	@Test
	public void killNullHumanTest() {
		Field field = new Field(20,20);
	
		boolean success = field.killHuman(null);
		assertFalse(success);
	}
	
	@Test
	public void killHumanSuccessfullyTest() {
		Human human = new Human();
		Field field = new Field(20,20);
		field.bearAt(human, 2, 5);
	
		field.killHuman(human);
		boolean humanGone = field.getHuman(2, 5) == null; 
		assertTrue(humanGone);
	}
	
	@Test
	public void countZeroNeighboursTest() {
		Human human = new Human();
		Field field = new Field(20,20);
		field.bearAt(human, 2, 5);
	
		int count = field.countNeightbours(2,5);
		boolean countCorrect = (count == 0 ); 
		assertTrue(countCorrect);
	}
	
	@Test
	public void countOneNeighbourTest() {
		Human human = new Human();
		Field field = new Field(20,20);
		field.bearAt(human, 2, 5);
	
		int count = field.countNeightbours(1,5);
		boolean countCorrect = (count == 1); 
		assertTrue(countCorrect);
	}
	
	@Test
	public void countTwoNeighboursTest() {
		Human human = new Human();
		Human human2 = new Human();
		Field field = new Field(20,20);
		field.bearAt(human, 2, 5);
		field.bearAt(human2, 4, 5);
	
		int count = field.countNeightbours(3,5);
		boolean countCorrect = (count == 2 ); 
		assertTrue(countCorrect);
	}
	
	@Test
	public void countThreeNeighboursTest() {
		Human human = new Human();
		Human human2 = new Human();
		Human human3 = new Human();
		Human human4 = new Human();
		Field field = new Field(20,20);
		field.bearAt(human, 2, 5);
		field.bearAt(human2, 4, 5);
		field.bearAt(human3, 3, 4);
		field.bearAt(human4, 1, 1);
	
		int count = field.countNeightbours(3,5);
		boolean countCorrect = (count == 3); 
		assertTrue(countCorrect);
	}
	
	@Test
	public void checkNeighboursTest() {
		Human human = new Human();
		Human human2 = new Human();
		Human human3 = new Human();
		Human human4 = new Human();
		Field field = new Field(5,5);
		field.bearAt(human, 2, 4);
		field.bearAt(human2, 4, 5);
		field.bearAt(human3, 3, 4);
		field.bearAt(human4, 1, 1);
	
		HashMap<Human, Integer> results = field.checkNeighbours();
		HashMap<Human, Integer> expected = new HashMap<Human, Integer>();
		expected.put(human, 1);
		expected.put(human2, 1);
		expected.put(human3, 2);
		expected.put(human4, 0);
		assertEquals( results, expected );
	}
	
	@Test
	public void checkNeighboursAroundTheCornerTest() {
		Human human = new Human();
		Human human2 = new Human();
		Human human3 = new Human();
		Human human4 = new Human();
		Field field = new Field(5,5);
		field.bearAt(human, 1, 4);
		field.bearAt(human2, 3, 4);
		field.bearAt(human3, 2, 3);
		field.bearAt(human4, 0, 0);
	
		HashMap<Human, Integer> results = field.checkNeighbours();
		HashMap<Human, Integer> expected = new HashMap<Human, Integer>();
		expected.put(human, 2);
		expected.put(human2, 1);
		expected.put(human3, 2);
		expected.put(human4, 0);
		assertEquals( results, expected );
	}
	
	
	
	
}
