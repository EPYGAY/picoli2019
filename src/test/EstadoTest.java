package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.control.Estado;

class EstadoTest {

	private Estado estado;
	
	@BeforeEach
	void setUp() {
		estado=new Estado();
		
		
	}
	@Test
	void testDespedir() {
		//estado.condicionesIniciales();
		estado.despedir(20);
		assertEquals(20, estado.getNumeroDesempleados());
		assertEquals(80, estado.getNumeroTrabajadores());
		estado.despedir(40);
		assertEquals(60, estado.getNumeroDesempleados());
		assertEquals(40, estado.getNumeroTrabajadores());
		estado.despedir(10);
		assertEquals(70, estado.getNumeroDesempleados());
		assertEquals(30, estado.getNumeroTrabajadores());
	}
	@Ignore
	public void TestNacer() {
		estado.nacer(8);
		assertEquals(8, estado.numeroNacimientos);
	}

}
