package modelo.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.sound.midi.Track;

import org.junit.jupiter.api.Test;

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

	private Stack<Empresa> listaFactorias = new Stack<Empresa>();// LIFO

	public long numeroNacimientos = 0;
	private long numeroFallecimientos = 0;
	private long numeroJubilaciones = 0;
	private long numeroContrataciones = 0;
	private double capitalEstatal = 0, crecimientoAnual = 0, produccionAnterior = 0;

	public Estado() {
		capitalEstatal = Constantes.CAPITAL_ESTADO_INICIAL;
		condicionesIniciales();
	}

	public void nacimiento() {
		SerVivo menor = new SerVivo(Utilies.obtenerNombreAleatorio(), identificadores++);
		numeroNacimientos++;
		listaMenores.add(menor);
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
		long produccionActual = getProduccion();
		crecimientoAnual = produccionActual - produccionAnterior;
		produccionAnterior = produccionActual;
		return crecimientoAnual;
	}

	public double getDemanda() {

		float demanda = 0;
		for (SerVivo serVivo : listaDesempleados) {
			demanda += serVivo.getNecesidadVital();
		}
		for (SerVivo serVivo : listaJubilados) {
			demanda += serVivo.getNecesidadVital();
		}
		for (SerVivo serVivo : listaMenores) {
			demanda += serVivo.getNecesidadVital();
		}

		for (Empresa empresa : listaFactorias) {
			for (SerVivo serVivo : empresa.getTrabjadores()) {
				demanda += serVivo.getNecesidadVital();
			}

		}

		return demanda;
	}

	public int getNumeroEmpresa() {
		return listaFactorias.size();

	}

	public float getPorcentajeGrandes() {
		float porcentaje = 0;
		for (Empresa empresa : listaFactorias) {
			porcentaje += empresa.calcularProductividad();
		}
		porcentaje /= getNumeroEmpresa();
		return porcentaje;
	}

	public long getProduccion() {
		long produccion = 0;
		for (Empresa empresa : listaFactorias) {
			produccion += empresa.getProduccion();
		}

		return produccion;

	}

	public void despedir(int numeroDespidos) {
		Empresa empresa = listaFactorias.peek();
		List<SerVivo> despedidos = new ArrayList<>();
		if (empresa.getNumeroTrabjadores() > numeroDespidos) {
			despedidos.addAll(empresa.despedir(numeroDespidos));
			numeroDespidos = 0;
		} else {
			int numeroPosiblesDespidos = empresa.getNumeroTrabjadores();
			numeroDespidos -= numeroPosiblesDespidos;
			empresa.despedir(numeroPosiblesDespidos);
			listaFactorias.pop();
		}
		annadirDesempleados(despedidos);
		// Recursividad
		if (numeroDespidos > 0) {
			despedir(numeroDespidos);
		}

	}

	public void nacer(int numeroDeNacimientos) {

		for (int i = 0; i < numeroDeNacimientos; i++) {
			nacimiento();
		}
		this.numeroNacimientos = numeroDeNacimientos;

	}

	private void annadirDesempleados(List<SerVivo> despedidos) {
		for (SerVivo serVivo : despedidos) {
			listaDesempleados.push(serVivo);
		}

	}

	public void aumentarProduccion(int i) {
		// TODO logica conectarBotones ParaUI

	}

	public void decrementarProduccion() {
		// TODO logica conectarBotones ParaUI

	}

	public void contratar(int numeroContrataciones) {
		// TODO
	}

	private void pagarPoblacion() {
		// TODO
	}

	private void pasarTrabajadoresAJubilados() {
		// TODO
	}

	private void pasarDesempleadosAJubilados() {
		// TODO
	}

	private void pasarMenoresADesempleado() {
		// TODO
	}

}
