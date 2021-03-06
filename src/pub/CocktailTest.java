package pub;
import junit.framework.TestCase;
import pub.Cocktail.Ingrediant;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import org.junit.Test;

public class CocktailTest extends TestCase {

	private Cocktail sansAlcool = new Cocktail("sansAlcool");
	private Cocktail avecAlcool = new Cocktail("avecAlcool");
	private Cocktail avecAlcool2 = new Cocktail("avecAlcool2");

	@Test
	public void testNewCocktailAvecAlccol() {
		assertEquals(avecAlcool.nom,"avecAlcool");
		assertTrue(avecAlcool.ingrediants.isEmpty());
		assertFalse(sansAlcool.alcoolFree());
	}
	
	public void testNewCocktailSansAlccol() {
		assertEquals(sansAlcool.nom,"sansAlcool");
		assertTrue(sansAlcool.ingrediants.isEmpty());
		assertTrue(sansAlcool.alcoolFree());
	}
	
	public void testAddIngredients() {
		assertTrue(sansAlcool.ingrediants.isEmpty());
		sansAlcool.add("Grenadine", (double) 10);
		sansAlcool.add("Orangina", (double) 90);
		assertEquals(sansAlcool.ingrediants.size(),2);
	}
	
	public void test100pour100() {
		sansAlcool.add("Grenadine", (double) 20);
		sansAlcool.add("Orangina", (double) 90);
		
		double res = 0;
		for (int i=0; i<sansAlcool.ingrediants.size(); i++) {
			res += sansAlcool.ingrediants.get(i).quantite;
		}
		
		assertEquals(res,(double) 100);
	}
	
	public void testToString() {
		assertNotNull(sansAlcool.toString());
	}

}
