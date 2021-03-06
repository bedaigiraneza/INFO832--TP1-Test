package pub;

import junit.framework.TestCase;

import org.junit.Test;

public class BoissonTest extends TestCase {
	private Boisson soda = new Boisson("Soda");
	private Boisson gin = new Boisson("Gin", new Float(30));
	private Boisson pamplemousse = new Boisson("Pamplemousse", new Float(0));

	@Test
	public void testNonAlcoolise() {
		assertEquals(soda.nom, "Soda");
		assertFalse(soda.alcoolise);
		assertNotNull(soda.toString());
	}
	
	public void testAlcoolise() {
		assertEquals(gin.nom, "Gin");
		assertEquals(gin.degre,(float) 30);
		assertTrue(gin.alcoolise);
		assertNotNull(gin.toString());
	}
	
	public void testZeroDegres() {
		// On v�rifie qu'une boisson � 0 degre n'est pas alcoolis�e
		assertEquals(pamplemousse.nom,"Pamplemousse");
		assertFalse(pamplemousse.alcoolise); 
	}

}
