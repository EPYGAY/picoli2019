package modelo.control;

public class SeresVivos {

	

	private String nombre;
	private int identificador, NV = 365;
	private float salario,edadMax, ahorro, edad;

	private TipoSerVivo tipo;

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public float getEdad() {
		return edad;
	}

	public void setEdad(float edad) {
		this.edad = edad;
	}

	public float getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(float edadMax) {
		this.edadMax = edadMax;
	}

	public void calcularSalario() {
		//TODO
	}
	
	public void calcularEdadMax() {
		//TODO
	}
	
	public void calcularAhorros() {
		//TODO
	}
	public float getAhorro() {
		return ahorro;
	}

	public void setAhorro(float ahorro) {
		this.ahorro = ahorro;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public TipoSerVivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoSerVivo tipo) {
		this.tipo = tipo;
	}

}
