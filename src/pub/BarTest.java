package pub;
import junit.framework.TestCase;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Enumeration;
import java.util.Vector;

import org.junit.Test;

public class BarTest extends TestCase {
	private Bar bar = new Bar();
	private Boisson cafe = new Boisson("Café");
	private Boisson soda = new Boisson("Soda");
	private Boisson grenadine = new Boisson("Grenadine");
	private Boisson gin = new Boisson("Gin", new Float(30));

	private Cocktail sansAlcool = new Cocktail("cocktailSansAlcool");
	private Cocktail avecAlcool = new Cocktail("cocktailAvecAlcool");
	private Cocktail avecAlcool2 = new Cocktail("cocktailAvecAlcool2");

	@Test
	public void testAddBoissonChaude() {
		// Boisson chaude
		bar.add(cafe);
		assertTrue(bar.boissonChaude.contains(cafe));
	}
	
	public void testAddBoissonFroide() {
		// Boisson froide
		bar.add(soda);
		assertTrue(bar.boissonFroide.contains(soda));
		
		// Deuxième boisson froide
		bar.add(grenadine);
		assertTrue(bar.boissonFroide.contains(grenadine));
		assertTrue(bar.boissonFroide.contains(soda));
	}
	
	public void testAddBoissonAlcoolisee() {
		// Boisson alcoolisée
		bar.add(gin);
		assertTrue(bar.boissonAlcoolisee.contains(gin));
	}
	
	public void testAddCocktailSansAlcool() {
		// Cocktail sans alcool
		sansAlcool.add("grenadine", (double) 1);
		sansAlcool.add("soda", (double) 7);
		bar.add(sansAlcool);
		assertTrue(bar.cocktailSansAlcoole.contains(sansAlcool));
	}
	
	public void testAddCocktailAvecAlcool() {
		// Cocktail avec alcool
		avecAlcool.add("gin", (double) 2);
		avecAlcool.add("whiskey", (double) 3);
		bar.add(avecAlcool);
		assertTrue(bar.cocktailAvecAlcoole.contains(avecAlcool));
		
		// Deuxieme cocktail avec alcool
		avecAlcool2.add("whiskey", (double) 20);
		avecAlcool2.add("coca", (double) 80);
		bar.add(avecAlcool2);
		assertTrue(bar.cocktailAvecAlcoole.contains(avecAlcool2));
		assertTrue(bar.cocktailAvecAlcoole.contains(avecAlcool));
	}
	
	public void testServBoissonChaude() {
		// Remplissage du bar
		bar.add(cafe);
		bar.add(grenadine);
		bar.add(gin);
		
		sansAlcool.add("grenadine", (double) 1);
		sansAlcool.add("soda", (double) 7);
		bar.add(sansAlcool);
		
		avecAlcool.add("gin", (double) 2);
		avecAlcool.add("whiskey", (double) 3);
		bar.add(avecAlcool);
		
		// Commande café
		assertTrue(bar.boissonChaude.contains(cafe));
		assertSame(bar.serv("Cafe"),cafe);
		assertFalse(bar.boissonChaude.contains(cafe));
	}
	
	public void testServBoissonFroide() {
		// Remplissage du bar
		bar.add(cafe);
		bar.add(grenadine);
		bar.add(gin);
		
		sansAlcool.add("grenadine", (double) 1);
		sansAlcool.add("soda", (double) 7);
		bar.add(sansAlcool);
		
		avecAlcool.add("gin", (double) 2);
		avecAlcool.add("whiskey", (double) 3);
		bar.add(avecAlcool);
		
		// Commande grenadine
		assertTrue(bar.boissonFroide.contains(grenadine));
		assertSame(bar.serv("Grenadine"),grenadine);
		assertFalse(bar.boissonFroide.contains(grenadine));
	}
	
	public void testServSansAlcool() {
		// Remplissage du bar
		bar.add(cafe);
		bar.add(grenadine);
		bar.add(gin);
		
		sansAlcool.add("grenadine", (double) 1);
		sansAlcool.add("soda", (double) 7);
		bar.add(sansAlcool);
		
		avecAlcool.add("gin", (double) 2);
		avecAlcool.add("whiskey", (double) 3);
		bar.add(avecAlcool);
		
		// Commande boisson sans alcool
		assertTrue(bar.cocktailSansAlcoole.contains(sansAlcool));
		assertSame(bar.serv("cocktailSansAlcool"),sansAlcool);
		assertFalse(bar.boissonFroide.contains(sansAlcool));
	}
	
	public void testServAvecAlcool() {
		// Remplissage du bar
		bar.add(cafe);
		bar.add(grenadine);
		bar.add(gin);
		
		sansAlcool.add("grenadine", (double) 1);
		sansAlcool.add("soda", (double) 7);
		bar.add(sansAlcool);
		
		avecAlcool.add("gin", (double) 2);
		avecAlcool.add("whiskey", (double) 3);
		bar.add(avecAlcool);
		
		// Commande boisson avec alcool
		assertTrue(bar.cocktailAvecAlcoole.contains(avecAlcool));
		assertSame(bar.serv("cocktailAvecAlcool"),avecAlcool); // Plante a cause de liste vide
		assertFalse(bar.boissonFroide.contains(avecAlcool));
	}
	
	public void testToString() {
		assertNotNull(bar.toString());
	}

}
