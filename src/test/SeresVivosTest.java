package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.control.SerVivo;
import utilesglobal.Constantes;

class SeresVivosTest {
	
	private List<SerVivo> personas;
	
	@BeforeEach
	public void setUp() {
		personas=new ArrayList<SerVivo>();
		personas.add(new SerVivo("a", 1, 22, 300));
		personas.add(new SerVivo("b", 2, 66, 300));//Jubilado
	}

	@Test
	public void testCobrar01() {
		List<Float> ahorros=new ArrayList<>();
		ahorros.add(0f);
		ahorros.add(137.5f);
		
		for (int i = 0; i < personas.size(); i++) {
			personas.get(i).cobrar(20);
			assertEquals(ahorros.get(i), personas.get(i).getAhorros(),0.1);
		}
		
	}
	
	@Test
	public void testCobrar02() {
		float obtieneGobierno=personas.get(0).cobrar(Constantes.NV_INICIAL*2);
		assertEquals(182.5f, obtieneGobierno,0.1);
		assertEquals(482.5f, personas.get(0).getAhorros(),0.1);
	}
}
