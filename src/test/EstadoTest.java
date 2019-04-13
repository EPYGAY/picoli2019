package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Estado;
import modelo.control.SeresVivos;

class EstadoTest {

	@Test
	void testJubilar() {
		Estado estado= new Estado();
		Estado estadoUno= new Estado();
		SeresVivos persona = new SeresVivos();
		SeresVivos personaUno = new SeresVivos();
		persona.setEdad(64);
		personaUno.setEdad(65);
		
		assertFalse(estado.jubilar(persona.getEdad()));
		assertTrue(estadoUno.jubilar(personaUno.getEdad()));
		
		
	}

}
