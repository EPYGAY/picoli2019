package modelo.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.plaf.InternalFrameUI;

import org.junit.Test;

import utilesglobal.Constantes;


public class Empresa {
	private int tamanoMaximo=Constantes.TAMANO_MAXIMO_EMPRESA;
	private float salario=Constantes.SALARIO;
	
	
	//trabajador el primera que entra el ultimo que sale
		public Stack<SerVivo> trabjadores= new Stack<SerVivo>();//LIFO
	public Empresa(){
		
	}
	public float calcularProductividad() {
		int numeroTrabjadores=getNumeroTrabjadores();
		float productividad=(numeroTrabjadores*100)/tamanoMaximo;
		return productividad;
	}
	@Test
	public void testcalcularProductividad() {
		Empresa test =new Empresa();
		float numeroTrabajadores= test.calcularProductividad();
		assertEquals(0, numeroTrabajadores);
	}
	
	public double getProduccion() {
		double produccion= getNumeroTrabjadores()*Constantes.PRODUCCION_TRABAJADOR;
		return produccion;
		
	}

	public void anadirTrabajador(SerVivo trabjador) {
		trabjadores.push(trabjador);
		}
	
		
	public int getNumeroTrabjadores() {
		return trabjadores.size();
	}
	public void pagarEmpleado() {
		for (SerVivo trabajador : trabjadores) {
			trabajador.cobrar(salario);
		}
	}
	
	public Stack<SerVivo> getTrabjadores() {
		return trabjadores;
	}
	public List <SerVivo> despedir(long numeroTrabajadoresDespedir){
		List<SerVivo> trabajadoresDespido= new ArrayList();
		for (int i = 0; i < numeroTrabajadoresDespedir; i++) {
			trabajadoresDespido.add(trabjadores.pop());
			
		}
		return trabajadoresDespido;
		
	}
	public void contratar(SerVivo trabajador) {
		trabajador.contratar();
		trabjadores.push(trabajador);
	}
	public void eliminarTrabajador(SerVivo serVivo) {
		trabjadores.remove(serVivo);
	}
	
}
