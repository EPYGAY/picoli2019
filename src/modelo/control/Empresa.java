package modelo.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.plaf.InternalFrameUI;

import utilesglobal.Constantes;


public class Empresa {
	private int tamanoMaximo=Constantes.TAMANO_MAXIMO_EMPRESA;
	private float salario=Constantes.SALARIO;
	
	
	//trabajador el primera que entra el ultimo que sale
		private Stack<SerVivo> trabjadores= new Stack<SerVivo>();//LIFO
	public Empresa(){
		
	}
		
	public float calcularProductividad() {
		//TODO calcula la productividad a partir del numero de Trabajadores
		return 0;
	}
	public double getProduccion() {
		//TODO obtiene la produccion por trabajador
		return 0;
		
	}

	public void anadirTrabajador(SerVivo trabjador) {
		trabjadores.push(trabjador);
		}
		
	public int getNumeroTrabjadores() {
		return trabjadores.size();
	}
	public void pagarEmpleado() {
		//TODO pagar a un Trabajador 
	}
	public Stack<SerVivo> getTrabjadores() {
		return trabjadores;
	}
	public List <SerVivo> despedir(int numeroTrabajadoresDespedir){
		//TODO despedir a un trabajador(pop)
		return trabjadores;
		
		
		
	}
}
