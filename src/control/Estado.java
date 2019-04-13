package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.control.SeresVivos;

public class Estado {
	
	private SeresVivos persona=new SeresVivos();
	private float edad=persona.getEdad(), edadMax=persona.getEdadMax(), sueldo=persona.getSalario();
	private int nv=365;
	
	
	public void pasarAnno() {
		//TODO
	}
	
	public void crearEmpresa() {
		//TODO
	}
	
	public void destruirEmpresa() {
		//TODO
	}
	
	public void contartarTrabajador() {
		//TODO
	}
	
	public void nacimiento() {
		//TODO
	}
	
	public void desempleo() {
		//TODO
	}

	public void aumentarNacimiento() {
		//TODO
	}

	public void disminuirNacimiento() {
		//TODO
	}
	
	public void recolectarCapital() {
		//TODO
	}
	
	public void comprobarCapital() {
		//TODO
	}
	
	public void pagarSubsidio() {
		//TODO
	}
	
	public boolean jubilar() {
		if(edad>=65) {
			return true;
		}
		return false;
	}
	
	public boolean morir() {
		if (edad>=edadMax) {
			return true;
		}
		return false;
	}
	public boolean reducirVida() {
		if (sueldo<365 && sueldo>182.5f) {
			sueldo=sueldo-182.5f;
			edadMax=edadMax-((0.5f*sueldo)/182.5f);
			persona.setEdadMax(edadMax);
			System.out.println(edadMax);
			return true;
		}else if (sueldo<182.5f) {
			edadMax=edadMax-0.5f;
			persona.setEdadMax(edadMax);
			System.out.println(edadMax);
			return true;
		}
		System.out.println(edadMax);
		return false;
	}
	@Test
	void testJubilar() {
		edad=64;
		assertFalse(jubilar());
		edad=65;
		assertTrue(jubilar());
	
	}
	@Test
	void testMorir() {
		edadMax=64.5f;
		edad=64;
		assertFalse(morir());		
		edad=65;
		assertTrue(morir());
	}
	@Test
	void testReducirVida() {
		edadMax=90;
		sueldo=364;
		assertTrue(reducirVida());
		sueldo=183;
		assertTrue(reducirVida());
		sueldo=182;
		assertTrue(reducirVida());
		sueldo=365;
		assertFalse(reducirVida());
	}
}
