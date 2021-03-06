package pub;
import junit.framework.TestCase;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Enumeration;
import java.util.Vector;

import org.junit.Test;

public class CaveTest extends TestCase {
	private Cave cave = new Cave();
	private Boisson soda = new Boisson("Soda");
	private Boisson gin = new Boisson("Gin", new Float(30));
	private Boisson cafe = new Boisson("Cafe");

	@Test
	public void testEmptyCave() {
		assertTrue(cave.rayons.isEmpty());
		assertNotNull(cave.toString());
	}
	
	public void testAdd() {
		// Taille
		cave.add(soda);
		cave.add(gin);
		cave.add(cafe);
		
		assertTrue(cave.rayons.contains(soda));
		assertTrue(cave.rayons.contains(gin));
		assertTrue(cave.rayons.contains(cafe));
		
		// toString
		assertNotNull(cave.toString());
	}
	
	public void testTake(){
		cave.add(soda);
		cave.add(gin);
		cave.add(cafe);
		
		// On prend un gin
		assertTrue(cave.rayons.contains(gin));
		assertSame(cave.take("Gin"),gin);
		assertFalse(cave.rayons.contains(gin));
		
		// On vérifie qu'une exception est bien levée si on veut prendre une boisson en rupture de stock
		assertThrows(Exception.class, () -> {
			cave.take("Orangina");
		});
	}
	

}
