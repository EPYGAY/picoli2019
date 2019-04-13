package control;

import modelo.control.SeresVivos;

public class Estado {
	
	SeresVivos persona=new SeresVivos();
	
	
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
	
	public boolean jubilar(int edad) {
		if(edad>=65) {
			return true;
		}
		return false;
	}


}
