package ABR;

import static org.junit.Assert.*;

import org.junit.Test;

public class ABR_Test {
	
	@Test
	public void testInsert() {
		ABR abr = new ABR();
		abr.insert(3);
		assertFalse(abr.isEmpty());
		abr.insert(2);
		assertEquals(abr.nbElements(),2);
		abr.insert(2);
		assertEquals(abr.nbElements(),2);
	}

	@Test
	public void testIsEmpty() {
		ABR abr = new ABR();
		assertTrue(abr.isEmpty());
		abr.insert(3);
		assertFalse(abr.isEmpty());
	}
	
	@Test
	public void testNbElements() {
		ABR abr = new ABR();
		assertEquals(abr.nbElements(),0);
		abr.insert(3);
		assertEquals(abr.nbElements(),1);
		abr.insert(5);
		abr.insert(1);
		abr.insert(2);
		assertEquals(abr.nbElements(),4);
	}
	

}
