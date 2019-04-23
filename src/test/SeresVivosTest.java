package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.control.SeresVivos;
import modelo.control.TipoSerVivo;

class SeresVivosTest {

	private SeresVivos juan = new SeresVivos();
	private float dineroEstado;

	@Test
	void testCalcularSueldo() {
		juan.setTipo(TipoSerVivo.jubilado);
		juan.setAhorro(500);
		juan.calcularSueldo(0, dineroEstado);
		assertEquals(317.5, juan.getAhorro());

		this.dineroEstado = 82.5f;
		juan.setAhorro(100);
		juan.calcularSueldo(0, dineroEstado);
		assertTrue(0 == juan.getAhorro() && 0 == dineroEstado);

		this.dineroEstado = 0;
		juan.setTipo(TipoSerVivo.trabajador);
		juan.setAhorro(0);
		juan.calcularSueldo(730, dineroEstado);
		assertTrue(182.5 == juan.getAhorro() && 182.5 == dineroEstado);

		this.dineroEstado = 182.5f;
		juan.setAhorro(100);
		juan.calcularSueldo(265, dineroEstado);
		assertTrue(juan.getAhorro() == 0 && 182.5 == dineroEstado);

		this.dineroEstado = 182.5f;
		juan.setTipo(TipoSerVivo.desempleado);
		juan.setAhorro(182.5f);
		juan.calcularSueldo(0, dineroEstado);
		assertTrue(juan.getAhorro() == 0 && dineroEstado == 0);
	}

	@Test
	void testCalcularEdadMax() {
		juan.calcularEdadMax();
		assertTrue(juan.getEdadMax() >= 0 && juan.getEdadMax() <= 90);
	}

	@Test
	void testCalcularAhorros() {
		juan.setTipo(TipoSerVivo.trabajador);
		juan.setAhorro(0);
		juan.calcularAhorros(100);
		assertTrue(100 == juan.getAhorro());
	}

}
