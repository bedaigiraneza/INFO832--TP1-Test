package pub;
import junit.framework.TestCase;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Vector;

import org.junit.Test;

public class CaveTest extends TestCase {
	private Vector<Boisson> rayons = new Vector<Boisson>();


	@Test
	public void test() {
	

//		Cave boissonsAlcoolisees = rayons.add(boissonAlcoolise1);
//		Cave boissonsNAlcoolisees = rayons.add(boissonNonAlcoolise1);
		assertEquals(rayons.size() == 3, rayons);
	}
	
	public void take(){
		Enumeration boissonsAlcoolisees = rayons.elements();
		Vector result = rayons.remove("boissonAlcoolise1");
		assertEquals(rayons.size() -1, 1);
	}

}
