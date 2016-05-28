package fiuba.algo3.algoFormers.modelo.mapas;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;

public class Posicion {

	private int x;
	private int y;


	public Posicion(int i, int j) {
		x = i;
		y = j;
	}
	
	public Posicion sumarDireccion(Direccion direccion) {
		//Devuelve una nueva posicion con la direccion sumada
		return (new Posicion(direccion.SumarX(x), direccion.SumarY(y)));
	}


	//Metodos de comparacion.
	
	@Override
	public int hashCode() {
		final int numeroSemilla = 31;
		int resultado = 1;
		resultado = numeroSemilla * resultado + x;
		resultado = numeroSemilla * resultado + y;
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
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
	//Metodos para pruebas.

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	public int obtenerDiferenciaY(Posicion posicionUbicable) {
		return ((this.y + posicionUbicable.y)/2);
	}
	
	public int obtenerDiferenciaX(Posicion posicionUbicable) {
		return ((this.x + posicionUbicable.x)/2);
	}
}
