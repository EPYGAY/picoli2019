package control;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.control.SerVivo;

public class Estado {
	
	//trabajador el primera que entra el ultimo que sale
	//menores primeros en nacer primeros en salir
	//desempleados igual (si su nv baja 5 años consecutivos sube ne la lista)
	//jubilados depende de la edadmax


	public void aplicarPeriodo() {

	}

	public void producir() {

	}

	public void cobrarImpuestos() {

	}

	public void pagarSubsidio() {

	}

	public void envejecer() {

	}

	public void pasarAnno() {
		// TODO
	}

	public void crearEmpresa() {
		// TODO
	}

	public void destruirEmpresa() {
		// TODO
	}

	public void contartarTrabajador() {
		// TODO
	}

	public void nacimiento() {
		// TODO
	}

	public void desempleo() {
		// TODO
	}

	public void aumentarProducion() {
		// TODO
	}

	public void disminuirProducion() {
		// TODO
	}

	public void recolectarCapital() {
		// TODO
	}

	public void comprobarCapital() {
		// TODO
	}
	public float pagarTrabajador() {
		return 0;
		
	}
	public float pagarMenor() {
		return 0;
		
	}
	public float pagarJubilado() {
		return 0;
		
	}

/*	public boolean jubilar() {
		if (edad >= 65) {
			return true;
		}
		return false;
	}

	public boolean morir() {
		if (edad >= edadMax) {
			return true;
		}
		return false;
	}

	public boolean reducirVida() {
		if (sueldo < 365 && sueldo > 182.5f) {
			sueldo = sueldo - 182.5f;
			edadMax = edadMax - ((0.5f * sueldo) / 182.5f);
			persona.setEdadMax(edadMax);
			System.out.println(edadMax);
			return true;
		} else if (sueldo < 182.5f) {
			edadMax = edadMax - 0.5f;
			persona.setEdadMax(edadMax);
			System.out.println(edadMax);
			return true;
		}
		System.out.println(edadMax);
		return false;
	}

	@Test
	void testJubilar() {
		edad = 64;
		assertFalse(jubilar());
		edad = 65;
		assertTrue(jubilar());

	}

	@Test
	void testMorir() {
		edadMax = 64.5f;
		edad = 64;
		assertFalse(morir());
		edad = 65;
		assertTrue(morir());
	}

	@Test
	void testReducirVida() {
		edadMax = 90;
		sueldo = 364;
		assertTrue(reducirVida());
		sueldo = 183;
		assertTrue(reducirVida());
		sueldo = 182;
		assertTrue(reducirVida());
		sueldo = 365;
		assertFalse(reducirVida());
	}*/
}
