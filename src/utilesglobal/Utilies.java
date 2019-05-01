package utilesglobal;

import java.util.Random;

public class Utilies {

	public static int obtenerAleatorio(int max) {
		return new Random().nextInt(max+1);
	}
	
	public static int obtenerAleatorio(int min,int max) {
		return min+obtenerAleatorio(max-min);
	}
	
	public static float calcularEdadMax(int min) {
		int maxEsperanzanVida = Constantes.EDAD_MAX_INICIAL;
		return Utilies.obtenerAleatorio(min, maxEsperanzanVida);
	}
	
	public static String obtenerNombreAleatorio() {
		StringBuilder nombre=new StringBuilder();
		int longitudNombre=obtenerAleatorio(3,10);
		for (int i = 0; i < longitudNombre; i++) {
			char letra = (char) obtenerAleatorio(97, 122);
			nombre.append(letra);
		}
		return nombre.toString();
	}
}
