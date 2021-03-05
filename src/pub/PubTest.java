package pub;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class PubTest extends TestCase {
	private Pub pub = new Pub();
	private Bar bar;
	private Cave cave = new Cave();
	
	Boisson coca = new Boisson("Coca");
	Boisson eau = new Boisson("Eau");
	Boisson sky = new Boisson("Whisky", new Float(40));
	Boisson bierre = new Boisson("Bierre", new Float(8));

	
	@Test
	public void testApprovisionnerBar() {

		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(sky);
		pub.cave.add(sky);
		pub.cave.add(bierre);
		pub.cave.add(bierre);
		pub.cave.add(eau);

		pub.approvisionnerBar("bierre");
		pub.approvisionnerBar("Whisky");
		pub.approvisionnerBar("Coca");
		pub.approvisionnerBar("eau");


		bar.add(cave.take("eau"));


		assertTrue(!(pub.approvisionnerBar() == null));
		assertEquals(bar.approvisionnerBar().length() == 4, 4);

		// test si un cocktail est alcoolisé ou pas
//		assertTrue(alcoolise.maz("bierre",50));
//		assertTrue(!alcoolise.maz("eau");

		assertTrue(!maz.length() == 0);
		assertEquals(maz.size() == 2, 2);

		assertTrue(!(pub.bar.boissonChaude.size() == 0));
	}

}
