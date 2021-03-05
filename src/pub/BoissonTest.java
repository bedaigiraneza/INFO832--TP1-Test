package pub;
import junit.framework.TestCase;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoissonTest extends TestCase {
	private Boisson boissonNonAlcoolise1= new Boisson("soda");
	private Boisson boissonAlcoolise1= new Boisson("Gin", 30);


	@Test
	public void testBoissonAlcoolise() {
		assertTrue(!boissonAlcoolise1.alcoolise());
		assertTrue(false, boissonNonAlcoolise1.alcoolise());

	}

}
