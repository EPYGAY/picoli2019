package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.control.Estado;

class EstadoTest {

	private Estado estado;
	
	@BeforeEach
	void setUp() {
		estado=new Estado();
		estado.condicionesIniciales();
		
	}
	@Test
	void testDespedir() {
		estado.despedir(101);
		assertEquals(101, estado.getNumeroDesempleados());
	}

}
