package modelo.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.sound.midi.Track;

import org.junit.jupiter.api.Test;
import org.omg.CORBA.NVList;

import modelo.vista.DatosPoblacion;
import utilesglobal.Constantes;
import utilesglobal.Utilies;

public class Estado {

	private long identificadores = 0;

	// menores primeros en nacer primeros en salir
	private LinkedList<SerVivo> listaMenores = new LinkedList<SerVivo>();// FIFO
	// desempleados igual (si su nv baja 5 años consecutivos sube ne la lista)
	private LinkedList<SerVivo> listaDesempleados = new LinkedList<SerVivo>();
	// jubilados depende de la edadmax
	private List<SerVivo> listaJubilados = new ArrayList<>();
	// La ultima empresa en llegar es la primera en salir
	private Stack<Empresa> listaFactorias = new Stack<Empresa>();// LIFO

	private long numeroNacimientos = 0, numeroFallecimientos = 0, numeroJubilaciones = 0, numeroContrataciones = 0;
	private double capitalEstatal = 0, crecimientoAnual = 0, produccionAnterior = 0;

	public Estado() {
		capitalEstatal = Constantes.CAPITAL_ESTADO_INICIAL;
		condicionesIniciales();
	}

	public void nacimiento() {
		// TODO crea un menor tipo ser vivo con nombre aleatorio y identificador++
	}

	public void condicionesIniciales() {
		// Menores
		for (int i = 0; i < Constantes.NUMERO_MENORES_INICIAL; i++) {
			nacimiento();
		}
		// Jubilados
		for (int i = 0; i < Constantes.NUMERO_JUBILADOS_INICIAL; i++) {
			SerVivo jubilado = new SerVivo(Utilies.obtenerNombreAleatorio(), ++identificadores,
					Utilies.obtenerAleatorio(65, 90), Utilies.obtenerAleatorio(3000));
			listaJubilados.add(jubilado);
		}
		// Trabjadores
		Empresa empresa = new Empresa();
		for (int i = 0; i < Constantes.NUMERO_TRABAJADORES_INICIAL; i++) {
			SerVivo trabjador = new SerVivo(Utilies.obtenerNombreAleatorio(), ++identificadores,
					Utilies.obtenerAleatorio(18, 64), Utilies.obtenerAleatorio(1000));
			empresa.anadirTrabajador(trabjador);
		}
		listaFactorias.add(empresa);
	}

	public long getPoblacion() {
		long menores = getNumeroMenores();
		long jubilados = getNumeroJubilados();
		long desempleados = getNumeroDesempleados();
		long trabjadores = getNumeroTrabajadores();
		long poblacion = menores + jubilados + desempleados + trabjadores;
		return poblacion;
	}

	public long getNumeroDesempleados() {
		long desempleados = listaDesempleados.size();
		return desempleados;
	}

	public long getNumeroJubilados() {
		long jubilados = listaJubilados.size();
		return jubilados;
	}

	public long getNumeroMenores() {
		long menores = listaMenores.size();
		return menores;
	}

	public long getNumeroTrabajadores() {
		long trabjadores = 0;
		for (Empresa factoria : listaFactorias) {
			trabjadores += factoria.getNumeroTrabjadores();

		}
		return trabjadores;
	}

	public long getNumeroNacimientos() {
		return numeroNacimientos;
	}

	public long getNumeroFallecimientos() {
		return numeroFallecimientos;
	}

	public long getNumeroJubilaciones() {
		return numeroJubilaciones;
	}

	public long getNumeroContrataciones() {
		return numeroContrataciones;
	}

	public double getCapitalEstatal() {
		return capitalEstatal;
	}

	public double getCrecimientoAnual() {
		// TODO produccion actual-produccionAnterior e igualamos
		return 0;
	}

	public double getDemanda() {
		// TODO recorre cada lista e suma la demanda que tiene cada uno
		return 0;
	}

	public int getNumeroEmpresa() {
		return listaFactorias.size();

	}

	public float getPorcentajeGrandes() {
		//TODO A través de la lista Factorias, calcular el porcentaje
		return 0;
	}

	public long getProduccion() {
		
		//TODO A través de la lista Factorias, calcular la produccion
				return 0;
	}

	public void despedir(int numeroDespidos) {
		//TODO 1. borra la ultima empresa de la pila de empresas
		//	   2. crea un array de despedidos, los añade y comprueb asi hay suficientes
		//	   ...

	}

	public void nacer(int numeroDeNacimientos) {
		//TODO 
	}

	private void annadirDesempleados(List<SerVivo> despedidos) {
		for (SerVivo serVivo : despedidos) {
			listaDesempleados.push(serVivo);
		}

	}
	
	public void subsidioJubilado(SerVivo jubilado) {
		float nvJubilados = jubilado.getNecesidadVital();
		double subsidioJubilado= capitalEstatal/getNumeroJubilados();
		subsidioJubilado = jubilado.getAhorros() + nvJubilados / 4;
		if (!jubilado.tieneAhorrosSuficientes()) {
			if (subsidioJubilado>nvJubilados/2) {
				subsidioJubilado=nvJubilados/2;
			}
			capitalEstatal=capitalEstatal-subsidioJubilado;
			jubilado.cobrar(subsidioJubilado);
		}

	}
	@Test
	void testSubsidioJubilado(){
		SerVivo jubilado=new SerVivo("David", 1, 67, 0);
		subsidioJubilado(jubilado);
		SerVivo jubiladoUno=new SerVivo("Sergio", 1, 67, 92);
		subsidioJubilado(jubiladoUno);
		
	}
	public void subsidioDesempleo(SerVivo desempleado) {
		double NV= desempleado.getNecesidadVital();
		double subsidioDesempleo= capitalEstatal/getNumeroDesempleados();	
		if (!desempleado.tieneAhorrosSuficientes()) {
			if(subsidioDesempleo>NV) {
				subsidioDesempleo=NV;
			}
			capitalEstatal=capitalEstatal-NV;
			desempleado.cobrar(subsidioDesempleo);
		}

	}
	@Test
	void testSubsidioDesempleo(){
		SerVivo desempleado=new SerVivo("David", 1, 25, 0);
		subsidioDesempleo(desempleado);
		SerVivo desempleadoUno=new SerVivo("David", 1, 25, 366);
		subsidioDesempleo(desempleadoUno);
	}
	public void pagarImpuestosYAhorrar(SerVivo trabajador) {
		capitalEstatal=capitalEstatal+(trabajador.getSueldo()*0.25);
		trabajador.setAhorro(trabajador.getSueldo()*0.25f);
		trabajador.setSueldo(trabajador.getNecesidadVital());
	}
	@Test
	void testPagarImpuestosYAhorrar(){
		SerVivo trabajador;
		trabajador=new SerVivo("David", 1, 25, 0);
		trabajador.setSueldo(730);
		pagarImpuestosYAhorrar(trabajador);
		assertEquals(182.5f, trabajador.getAhorros());
		assertEquals(100182.5, capitalEstatal);
	}

}
