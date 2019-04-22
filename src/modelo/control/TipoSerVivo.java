package modelo.control;

public enum TipoSerVivo {
	menor("50"),trabajador("100"),desempleado("0"),jubilado("30");
	
	private String TipoSerVivo ;

	private TipoSerVivo(String tipoSerVivo) {
		TipoSerVivo = tipoSerVivo;
	}

	public String getTipoSerVivo() {
		return TipoSerVivo;
	}

	public void setTipoSerVivo(String tipoSerVivo) {
		TipoSerVivo = tipoSerVivo;
	}
	
	
	
}
