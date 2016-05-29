package fiuba.algo3.algoFormers.modelo.mapas;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;

public class Posicion {

	private int numeroFila;
	private int numeroColumna;


	public Posicion(int fila, int columna) {
		numeroFila = fila;
		numeroColumna = columna;
	}
	
	public Posicion sumarDireccion(Direccion direccion) {
		//Devuelve una nueva posicion con la direccion sumada
		return (new Posicion(direccion.SumarX(numeroFila), direccion.SumarY(numeroColumna)));
	}
	
	public int obtenerDistancia(Posicion otraPosicion) {
		return (int) Math.sqrt((Math.pow((this.numeroFila + otraPosicion.numeroFila), 2)) + (Math.pow((this.numeroColumna + otraPosicion.numeroColumna), 2)));
	}


	//Metodos de comparacion.
	
	@Override
	public int hashCode() {
		final int numeroSemilla = 31;
		int resultado = 1;
		resultado = numeroSemilla * resultado + numeroFila;
		resultado = numeroSemilla * resultado + numeroColumna;
		return resultado;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (numeroFila != other.numeroFila)
			return false;
		if (numeroColumna != other.numeroColumna)
			return false;
		return true;
	}
	
	
	
	//Metodos para pruebas.

	public int getX() {
		return numeroFila;
	}


	public int getY() {
		return numeroColumna;
	}
}
