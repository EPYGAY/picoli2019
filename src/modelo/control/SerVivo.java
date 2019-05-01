package modelo.control;

import utilesglobal.Constantes;
import utilesglobal.Utilies;

public class SerVivo {

	private String nombre;
	private long identificador;
	private float necesidadVital;
	private float edad;
	private float ahorro;
	private float esperanzaVida;
	private EstadoSocial estadoSocial;
	private boolean desempleado;

	public SerVivo(String nombre, long identificador) {
		this.nombre = nombre;
		this.identificador = identificador;
		this.edad = 0f;
		this.ahorro = 0f;
		this.esperanzaVida = Utilies.calcularEdadMax((int) edad);
		this.necesidadVital = Constantes.NV_INICIAL;
		comprobarEstado();
	}

	public SerVivo(String nombre, long identificador, float edad, float ahorro) {
		this.nombre = nombre;
		this.identificador = identificador;
		this.edad = edad;
		this.ahorro = ahorro;
		this.esperanzaVida = Utilies.calcularEdadMax((int) edad);
		this.necesidadVital = Constantes.NV_INICIAL;
		comprobarEstado();
	}

	public void pasarAnno() {
		edad++;
		comprobarEstado();
	}

	public float cobrar(float salario) {
		//TODO 
		return 0;
	}

	public void despedir() {
		desempleado = true;
	}

	public void contratar() {
		desempleado = false;
	}

	public boolean isAdulto() {
		return EstadoSocial.ADULTO.equals(estadoSocial);
	}

	public boolean isJubilado() {
		return EstadoSocial.JUBILADO.equals(estadoSocial);
	}

	public boolean isVivo() {
		return EstadoSocial.FALLECIDO.equals(estadoSocial);
	}

	public boolean isDesempleado() {
		return isAdulto() && desempleado;
	}

	public boolean tieneAhorrosSuficientes() {
		return ahorro >= necesidadVital;
	}

	public boolean tieneAhorrosSuficientes(float gasto) {
		return ahorro >= gasto;
	}

	public String getNombre() {
		return nombre;
	}

	public long getIdentificador() {
		return identificador;
	}

	public float getAhorros() {
		return ahorro;
	}

	public float getNecesidadVital() {
		return necesidadVital;
	}

	private void comprobarEstado() {
		//TODO
	}

	private void decrementarEsperanzaVida(float deficit) {
		float decrementoVida = deficit / necesidadVital - Constantes.DECREMENTO_ESPERANZA;
		esperanzaVida -= Math.abs(decrementoVida);
	}

}
