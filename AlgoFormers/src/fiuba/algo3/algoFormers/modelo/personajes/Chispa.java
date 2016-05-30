package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;

public class Chispa implements Ubicable {

	private String nombre;
	private Posicion posicionActual;
	
	public Chispa(String unNombre) {
		
		nombre = unNombre;
	}
	
	@Override
	public void recibirDanio(Algoformer atacante) {
		return;

	}

	@Override
	public void setPosicion(Posicion pos) {
		posicionActual = pos;

	}

	@Override
	public Posicion getPosicion() {

		return posicionActual;
	}

	@Override
	public String getNombre() {
		
		return nombre;
	}
	

}
