package modelo.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
		float deficit = salario - necesidadVital;
		float dineroParaEstado = 0;
		// Si cobramos menos de lo que necesitamos
		if (deficit < 0) {
			deficit = Math.abs(deficit);
			if (tieneAhorrosSuficientes(deficit)) {
				ahorro -= deficit;
			} else {
				deficit -= ahorro;
				ahorro = 0;
				decrementarEsperanzaVida(deficit);
			}
		} else {
			float mitad = deficit / 2;
			ahorro += mitad;
			dineroParaEstado = mitad;
		}
		return dineroParaEstado;
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
		if (edad > esperanzaVida) {
			estadoSocial = EstadoSocial.FALLECIDO;
		} else if ((estadoSocial == null || !isJubilado()) && edad >= Constantes.EDAD_JUBILADO) {
			estadoSocial = EstadoSocial.JUBILADO;
			necesidadVital /= 2;
		} else if ((estadoSocial == null || !isAdulto()) && edad >= Constantes.EDAD_ADULTA) {
			estadoSocial = EstadoSocial.ADULTO;
		} else if(edad<Constantes.EDAD_ADULTA) {
			estadoSocial = EstadoSocial.MENOR;
		}
	}

	private void decrementarEsperanzaVida(float deficit) {
		float decrementoVida = deficit / necesidadVital - Constantes.DECREMENTO_ESPERANZA;
		esperanzaVida -= Math.abs(decrementoVida);
	}
	static class TestClass {
		@Test
		void testdecrementarEsperanzaVida() {
			SerVivo uno = new SerVivo("Joaquin", 1, 30, 0);
			uno.esperanzaVida=90;
			uno.decrementarEsperanzaVida(182.5f);
			assertEquals(90, uno.esperanzaVida);
		}
		@Test
		void testcobrar() {
			
		}
		
	}
}
