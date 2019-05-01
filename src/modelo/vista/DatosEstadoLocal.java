package modelo.vista;

import java.util.ArrayList;

public class DatosEstadoLocal extends Datos {

	public DatosEstadoLocal(int grandes, float porcentajeGrandes) {
		super();
		ArrayList datos = getDatos();
		datos.add(grandes);
		datos.add(porcentajeGrandes);
	}
}
