package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.control.Empresa;
import modelo.control.Estado;
import utilesglobal.Constantes;

class EstadoTest {

	private Estado estado;

	@BeforeEach
	void setUp() {
		estado = new Estado();

	}

	@Test
	void testDespedir() {
		// estado.condicionesIniciales();
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

	@Test
	public void TestNacer() {
		estado.nacer(8);
		assertEquals(8, estado.numeroNacimientos);
	}

	@Test
	void testCondicionesIniciales() {
		
		assertEquals(Constantes.NUMERO_MENORES_INICIAL, estado.getNumeroMenores());
		assertEquals(Constantes.NUMERO_JUBILADOS_INICIAL, estado.getNumeroJubilados());
		assertEquals(Constantes.NUMERO_TRABAJADORES_INICIAL, estado.getNumeroTrabajadores());
		estado.condicionesIniciales();
		assertEquals(Constantes.NUMERO_MENORES_INICIAL * 2, estado.getNumeroMenores());
		assertEquals(Constantes.NUMERO_JUBILADOS_INICIAL * 2, estado.getNumeroJubilados());
		assertEquals(Constantes.NUMERO_TRABAJADORES_INICIAL * 2, estado.getNumeroTrabajadores());
	}

}
