package fiuba.algo3.algoFormers.modelo.mapas;

public class Posicion {

	private int x;
	private int y;


	public Posicion(int i, int j) {
		x = i;
		y = j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}


	//Metodos de comparacion.
	
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

}
