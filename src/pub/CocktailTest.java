package pub;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class CocktailTest {
	private Vector ingrediants= new Vector<ingrediant>;

	@Test
	public void testAddIngrediant() {
		String ingrediant1 = new Ingrediant("citron", 3.0);
		ingrediants.add(ingrediant1);
		assertEquals(ingrediants[0], "citron",3.0);
		assertTrue(!ingrediants.length() == 0, true);
	}

}
