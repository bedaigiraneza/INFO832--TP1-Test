package pub;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class BarTest {
	private Vector<Boisson> boissonChaude;
	private Vector<Boisson> boissonFroide;
	private Vector<Boisson> boissonAlcoolisee;
	private Vector<Cocktail> cocktailSansAlcoole;
	private Vector<Cocktail> cocktailAvecAlcoole;

	@Test
	public void testAdd() {
		pub.boissonAlcoolisee.add("Whisky");
		boissonFroide.add("soda");
		boissonChaude.add("cafe");

		assertTrue(boissonAlcoolisee.size() == 1);
		assertTrue(boissonFroide.size() == 1);
		assertTrue(boissonChaude.size() == 1);
		assertTrue(cocktailSansAlcoole.size() == 0);
		assertTrue(cocktailAvecAlcoole.size() == 0);
	}

	private static void add(String string) {
		// TODO Auto-generated method stub
		
	}

}
